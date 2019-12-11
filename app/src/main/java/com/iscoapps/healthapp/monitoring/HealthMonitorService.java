package com.iscoapps.healthapp.monitoring;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;

import com.crrepa.ble.CRPBleClient;
import com.crrepa.ble.conn.CRPBleConnection;
import com.crrepa.ble.conn.CRPBleDevice;
import com.crrepa.ble.conn.bean.CRPHeartRateInfo;
import com.crrepa.ble.conn.bean.CRPMovementHeartRateInfo;
import com.crrepa.ble.conn.listener.CRPBleConnectionStateListener;
import com.crrepa.ble.conn.listener.CRPBloodOxygenChangeListener;
import com.crrepa.ble.conn.listener.CRPBloodPressureChangeListener;
import com.crrepa.ble.conn.listener.CRPHeartRateChangeListener;
import com.iscoapps.healthapp.MyApplication;

import java.util.List;

public class HealthMonitorService extends Service {
    private static final int DEFAULT_INTERVAL = 1200000; // 2 Minutes

    public static final String PARCEL_MAC_ADDR = "bandMacAddr";
    public static final String PARCEL_INTERVAL = "interval";

    int interval = DEFAULT_INTERVAL;

    private CRPBleClient mBleClient = null;
    private CRPBleDevice mBleDevice = null;
    private CRPBleConnection mBleConnection = null;

    private NotificationsManager notificationsManager;

    public HealthMonitorService() {
        // Empty Constructor
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Get passed data
        String bandMacAddr = intent.getStringExtra(PARCEL_MAC_ADDR);
        interval = intent.getIntExtra(PARCEL_INTERVAL, DEFAULT_INTERVAL);

        // Check mac address
        if (TextUtils.isEmpty(bandMacAddr)) {
            // Stop the service without requesting a restart
            stopSelf();
            return START_NOT_STICKY;
        }

        notificationsManager = new NotificationsManager(this);
        notificationsManager.startMonitorNotification();

        mBleClient = MyApplication.getBleClient(this);
        mBleDevice = mBleClient.getBleDevice(bandMacAddr);
        if (mBleDevice != null && !mBleDevice.isConnected()) {
            connect();
        }

        // Request a restart in case of the service being stopped
        return START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Not designed to be used as a bound service
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // Disconnect the band from the current service
        if (mBleDevice != null) {
            mBleDevice.disconnect();
        }

        // Restarting the service manually
        Intent restartServiceIntent = new Intent(getApplicationContext(), this.getClass());
        restartServiceIntent.setPackage(getPackageName());
        startService(restartServiceIntent);

        super.onTaskRemoved(rootIntent);
    }

    @Override
    public void onDestroy() {
        // Disconnect the band from the current service
        if (mBleDevice != null) {
            mBleDevice.disconnect();
        }

        super.onDestroy();
    }

    void connect() {
        mBleConnection = mBleDevice.connect();
        mBleConnection.setConnectionStateListener(new CRPBleConnectionStateListener() {
            @Override
            public void onConnectionStateChange(int newState) {
                notificationsManager.onConnectionStateUpdate(newState);

                if (newState == STATE_CONNECTED) {
                    // mBleConnection.syncTime();

                    final Handler handler = new Handler();
                    handler.post(new Runnable() {
                        public void run() {
                            if (!mBleDevice.isConnected()) {
                                connect();
                                return;
                            }

                            mBleConnection.startMeasureOnceHeartRate();

                            handler.postDelayed(this, interval);
                        }
                    });
                }
            }
        });

        mBleConnection.setHeartRateChangeListener(new CRPHeartRateChangeListener() {
            @Override
            public void onMeasuring(int i) {

            }

            @Override
            public void onOnceMeasureComplete(int i) {
                mBleConnection.stopMeasureOnceHeartRate();
                mBleConnection.startMeasureBloodPressure();

                notificationsManager.onHeartRateUpdate(i);
            }

            @Override
            public void onMeasureComplete(CRPHeartRateInfo crpHeartRateInfo) {

            }

            @Override
            public void on24HourMeasureResult(CRPHeartRateInfo crpHeartRateInfo) {

            }

            @Override
            public void onMovementMeasureResult(List<CRPMovementHeartRateInfo> list) {

            }
        });

        mBleConnection.setBloodPressureChangeListener(new CRPBloodPressureChangeListener() {
            @Override
            public void onBloodPressureChange(int i, int i1) {
                mBleConnection.startMeasureBloodOxygen();

                notificationsManager.onBloodPressureUpdate(i, i1);
            }
        });

        mBleConnection.setBloodOxygenChangeListener(new CRPBloodOxygenChangeListener() {
            @Override
            public void onBloodOxygenChange(int i) {
                notificationsManager.onOxygenSaturationUpdate(i);
            }
        });
    }
}
