package com.iscoapps.healthapp.Views.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.iscoapps.healthapp.R;


public class AboutActivity extends AppCompatActivity {

    TextView title , body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        title = findViewById(R.id.textView7);
        body = findViewById(R.id.textView8);

        title.setText("About");
        body.setText("Are you having problems with your heart rate? Here comes Cardio Regulator workout: Cardio regulator, health advisor, and the best indicator for heart attack. \n" +
                "Cardio regulator is extremely accurate. Get your heart rate and advices if you are in risk instantly, process is quick and easy. It can be used for all ages. Cardio regulator also helps you \n" +
                "•\tmonitoring your blood pressure \n" +
                "•\t Oxygen content in blood and your steps.  \n" +
                "How to use the Cardio Regulator free app to measure your heart beat?\n" +
                "To use this heartbeat counter, just wear the smart watch and connect it via Bluetooth. THEN, choose which disease you have, your age, your activity and if you are smoker or not. A few seconds later, after the measurement, the advices will be shown if you are in risk.\n");
    }

//    public void skip(View view)
//    {
//        Intent intent = new Intent(AboutActivity.this,
//                HomeActivity.class);
//        startActivity(intent);
//    }
}
