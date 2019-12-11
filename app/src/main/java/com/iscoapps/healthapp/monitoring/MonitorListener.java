package com.iscoapps.healthapp.monitoring;

import com.crrepa.ble.conn.listener.CRPBleConnectionStateListener;

import java.io.Serializable;

public interface MonitorListener extends Serializable {
    int CONNECTION_STATE_DISCONNECTED = CRPBleConnectionStateListener.STATE_DISCONNECTED;
    int CONNECTION_STATE_CONNECTING = CRPBleConnectionStateListener.STATE_CONNECTING;
    int CONNECTION_STATE_CONNECTED = CRPBleConnectionStateListener.STATE_CONNECTED;
    int CONNECTION_STATE_DISCONNECTING = CRPBleConnectionStateListener.STATE_DISCONNECTING;

    void onConnectionStateUpdate(int newState);

    void onHeartRateUpdate(int heartRate);

    void onBloodPressureUpdate(int systolicBP, int diastolicBP);

    void onOxygenSaturationUpdate(int oxygenSaturation);
}
