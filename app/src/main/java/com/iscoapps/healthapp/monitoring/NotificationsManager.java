package com.iscoapps.healthapp.monitoring;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;

import com.iscoapps.healthapp.R;

import java.util.Locale;

public class NotificationsManager implements MonitorListener {
    // These values are arbitrary, just to distinguish each notification & the main channel
    private static final String CHANNEL_ID = "HEALTH_MONITOR_CHANNEL";
    private static final String CHANNEL_NAME = "Health Monitor Service Notifications";
    private static final int MONITOR_ID = 0x1F;
    private static final int ABNORMAL_HEART_RATE = 0x2F;
    private static final int ABNORMAL_BLOOD_PRESSIRE = 0x3F;
    private static final int ABNORMAL_OXYGEN_SATURATION = 0x4F;

    private Service service;

    private NotificationManager systemNotifications;

    // Variables to store notification data
    private int connectionState = MonitorListener.CONNECTION_STATE_DISCONNECTED;
    private int heartRate = -1;
    private int systolicBP = -1;
    private int diastolicBP = -1;
    private int oxygenSaturation = -1;

    public NotificationsManager(Service service) {
        this.service = service;

        systemNotifications = (NotificationManager) service.getSystemService(Context.NOTIFICATION_SERVICE);

        createNotificationChannel();
    }

    @Override
    public void onConnectionStateUpdate(int newState) {
        connectionState = newState;
        updateMonitorNotification();
    }

    @Override
    public void onHeartRateUpdate(int heartRate) {
        this.heartRate = heartRate;
        updateMonitorNotification();

        if (!HealthChecker.isHeartRateNormal(heartRate)) {
            alert(ABNORMAL_HEART_RATE);
        }
    }

    @Override
    public void onBloodPressureUpdate(int systolicBP, int diastolicBP) {
        this.systolicBP = systolicBP;
        this.diastolicBP = diastolicBP;
        updateMonitorNotification();

        if (!HealthChecker.isBloodPressureNormal(systolicBP, diastolicBP)) {
            alert(ABNORMAL_BLOOD_PRESSIRE);
        }
    }

    @Override
    public void onOxygenSaturationUpdate(int oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
        updateMonitorNotification();

        if (!HealthChecker.isOxygenSaturationNormal(oxygenSaturation)) {
            alert(ABNORMAL_OXYGEN_SATURATION);
        }
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel serviceChannel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            systemNotifications.createNotificationChannel(serviceChannel);
        }
    }

    public void startMonitorNotification() {
        service.startForeground(MONITOR_ID, buildMonitorNotification());
    }

    private void updateMonitorNotification() {
        systemNotifications.notify(MONITOR_ID, buildMonitorNotification());
    }

    private Notification buildMonitorNotification() {
        Notification.Builder builder = new Notification.Builder(service)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_heartrate)
                .setContentTitle("Band State: " + getConnectionStateString(connectionState))
                .setContentText(String.format(Locale.US,
                        "Heart Rate: %d - BP : %d/%d - Oxygen Saturation: %d%%",
                        heartRate, systolicBP, diastolicBP, oxygenSaturation));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }

        return builder.build();
    }

    private String getConnectionStateString(int connectionState) {
        switch (connectionState) {
            case MonitorListener.CONNECTION_STATE_DISCONNECTED:
                return "Disconnected";

            case CONNECTION_STATE_CONNECTING:
                return "Connecting";

            case CONNECTION_STATE_CONNECTED:
                return "Connected";

            case CONNECTION_STATE_DISCONNECTING:
                return "Disconnecting";

            default:
                return "Unknown";
        }
    }

    private void alert(int alertID) {
        Notification notification = null;

        switch (alertID) {
            case ABNORMAL_HEART_RATE:
                notification = buildAlert("Heart rate is abnormal", "Value: " + heartRate);
                break;

            case ABNORMAL_BLOOD_PRESSIRE:
                notification = buildAlert("Blood pressure is abnormal", "Value: " + systolicBP + "/" + diastolicBP);
                break;

            case ABNORMAL_OXYGEN_SATURATION:
                notification = buildAlert("Oxygen saturation is abnormal", "Value: " + oxygenSaturation + "%");
                break;
        }

        if (notification != null) {
            systemNotifications.notify(alertID, notification);
        }
    }

    private Notification buildAlert(String title, String text) {
        Notification.Builder builder = new Notification.Builder(service)
                .setPriority(Notification.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_heartrate)
                .setContentTitle(title)
                .setContentText(text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder.setChannelId(CHANNEL_ID);
        }

        return builder.build();
    }
}
