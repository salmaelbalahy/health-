package com.iscoapps.healthapp;

import android.app.Application;
import android.content.Context;

import com.crrepa.ble.CRPBleClient;

public class MyApplication extends Application {

    private CRPBleClient bleClient;
    private static Context context;

    public static CRPBleClient getBleClient(Context context) {
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.bleClient;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        bleClient = CRPBleClient.create(this);
    }

    public static Context getContext() {
        return context;
    }
}
