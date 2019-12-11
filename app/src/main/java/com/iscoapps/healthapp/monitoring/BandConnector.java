package com.iscoapps.healthapp.monitoring;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

import com.crrepa.ble.CRPBleClient;
import com.crrepa.ble.scan.bean.CRPScanDevice;
import com.crrepa.ble.scan.callback.CRPScanCallback;
import com.iscoapps.healthapp.MyApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BandConnector {
    private static final int SCAN_PERIOD = 10000;

    private Context context;

    private CRPBleClient mBleClient;
    private boolean mScanState = false;

    public BandConnector(Context context) {
        this.context = context;

        mBleClient = MyApplication.getBleClient(context);
    }

    public void startScan(final String bandMacAddr, final BandScanListener bandScanListener) {
        Set<BluetoothDevice> pairedDevices = BluetoothAdapter.getDefaultAdapter().getBondedDevices();

        for (BluetoothDevice d : pairedDevices) {
            if (bandMacAddr.equalsIgnoreCase(d.getAddress())) {
                connectFast(bandMacAddr);
                bandScanListener.onFound(d);
                return;
            }
        }

        boolean success = mBleClient.scanDevice(new CRPScanCallback() {
            @Override
            public void onScanning(final CRPScanDevice device) {
                if (device.getDevice().getAddress().equalsIgnoreCase(bandMacAddr)) {
                    connectFast(bandMacAddr);
                    bandScanListener.onFound(device.getDevice());
                }
            }

            @Override
            public void onScanComplete(List<CRPScanDevice> results) {
                if (mScanState) {
                    List<BluetoothDevice> devices = new ArrayList<>();
                    for (CRPScanDevice x : results) {
                        devices.add(x.getDevice());
                    }
                    mScanState = false;

                    bandScanListener.onNotFound(devices);
                }
            }
        }, SCAN_PERIOD);
        if (success) {
            mScanState = true;
        }
    }

    public void cancelScan() {
        mBleClient.cancelScan();
    }

    public void connectFast(String macAddress) {
        mBleClient.cancelScan();

        final Intent intent = new Intent(context, HealthMonitorService.class);
        intent.putExtra(HealthMonitorService.PARCEL_MAC_ADDR, macAddress);
        context.startService(intent);
    }
}
