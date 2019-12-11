package com.iscoapps.healthapp.Views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.iscoapps.healthapp.R;

public class HomeActivity extends AppCompatActivity {


    public  final String[] doing = {  "do exercises" , "relaxing" , "anexeity"
            , "breathing hard"
            , "athlete"
            , "nothing"};
    public  final String[] smoker = {  "yes" , "no" };

    Spinner doingS,smokerS;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        doingS= findViewById(R.id.spinner);
        smokerS= findViewById(R.id.spinner2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item,doing);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        doingS.setAdapter(adapter);
        doingS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.spinner_item,smoker);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smokerS.setAdapter(adapter2);
        smokerS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void about(View view)
    {
        Intent intent = new Intent(HomeActivity.this,
                AboutActivity.class);
        startActivity(intent);
    }


    public void next(View view)
    {
        Intent intent = new Intent(HomeActivity.this,
                AdviceActivity.class);
        intent.putExtra("doing" , doingS.getSelectedItem()+"");
        intent.putExtra("smoker" , smokerS.getSelectedItem()+"");
        startActivity(intent);
    }
}
