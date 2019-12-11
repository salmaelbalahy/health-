package com.iscoapps.healthapp.Views.activity;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iscoapps.healthapp.DataBase.DataBaseHelper;
import com.iscoapps.healthapp.DataBase.User;
import com.iscoapps.healthapp.R;
import com.iscoapps.healthapp.Views.activity.HomeActivity;
import com.iscoapps.healthapp.monitoring.BandConnector;
import com.iscoapps.healthapp.monitoring.BandScanListener;
import com.iscoapps.healthapp.monitoring.MonitorListener;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    EditText emailEt,passwordEd;
    TextView signUpTv;

    DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEt = findViewById(R.id.editText);
        passwordEd =  findViewById(R.id.editText2);
        signUpTv =  findViewById(R.id.textView9);

        dataBaseHelper = new DataBaseHelper(this);

        BandConnector bandConnector = new BandConnector(this);

        // MINE:"D6:34:16:7B:92:53"  - "D1:9F:30:60:9D:1E"
        bandConnector.startScan("D1:9F:30:60:9D:1E", new BandScanListener() {
            @Override
            public void onFound(BluetoothDevice device) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "Band found", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onNotFound(List<BluetoothDevice> foundDevices) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "Band not found", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

//        dataBaseHelper = new DataBaseHelper(this);
//        long id = dataBaseHelper.insertUser("user test" , "olx@hotmail.com" , "123456",
//                "96566328950");
//        System.out.println("id = " + id);
//        Log.e("test***" , "id = " + id);
    }

    public void loginFun(View view)
    {

        User user = dataBaseHelper.getUser(emailEt.getText().toString().trim());
        if(user != null &&
                user.getPassword().equals(passwordEd.getText().toString()))
        {
            saveUserAuth(user.getId()+"");
            saveUserDate(user.getDB());
            Toast.makeText(this,"Welecome " + user.getName()
                    , Toast.LENGTH_LONG).show();

            Intent intent = new Intent(LoginActivity.this,
                    HomeActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,"Wrong Auth" , Toast.LENGTH_LONG).show();
        }

    }


    public void signUpFun(View view)
    {
        Intent intent = new Intent(LoginActivity.this,
                com.iscoapps.healthapp.Views.activity.RegisterActivity.class);
        startActivity(intent);

    }


    public void saveUserAuth(String user_id)
    {
         SharedPreferences sharedPreferences ;
         SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("user_id" ,user_id);
        editor.commit();

    }


    public void saveUserDate(String date)
    {
        SharedPreferences sharedPreferences ;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("date" ,date);
        editor.commit();

    }


}
