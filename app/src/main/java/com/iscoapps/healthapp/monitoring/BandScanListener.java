package com.iscoapps.healthapp.monitoring;

import android.bluetooth.BluetoothDevice;

import java.util.List;

public interface BandScanListener {

    void onFound(BluetoothDevice device);

    void onNotFound(List<BluetoothDevice> foundDevices);
}
