package com.iscoapps.healthapp.Views.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import com.iscoapps.healthapp.DataBase.DataBaseHelper;
import com.iscoapps.healthapp.R;
import com.iscoapps.healthapp.Views.activity.HomeActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity
{

    Dialog generalDialog;
    Boolean isVaildEmail = false , isVaildPhone = false,
    isLicensed = false;


    public  final String[] paths = {  "Choose Diseases" , "Diabetes" ,
    "Coronay artery disease" , "Valvular heart diseases" , "Hyper throidism",
    "cardiomyopathy","Anemia" , "others","No diseases"};

    String city="";

    DataBaseHelper dataBaseHelper;

    //--------------------------- views -----------------------------------//

    EditText phone , email  ,  username   ,
        password ;

    Button signupBtn;
    ConstraintLayout layout;
    ProgressBar loadingPb;
    Spinner countryS;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.sign_up);



        setContentView(R.layout.signup_user_screen);

        layout = findViewById(R.id.container);

        dataBaseHelper = new DataBaseHelper(this);

        findViewsToReferences();

        setListenerOfViews();
        createDatePicker();

    }

    public void backFun(View view)
    {
        finish();
    }

    public void setListenerOfViews()
    {
//        try {



        signupBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                loadingPb.setVisibility(View.VISIBLE);
                signupBtn.setVisibility(View.INVISIBLE);
                checkDataThenRegister();
            }
        });




        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this,
                R.layout.spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countryS.setAdapter(adapter);
        countryS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                city = paths[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void findViewsToReferences()
    {
//        try {

        phone = findViewById(R.id.textView33);
        email = findViewById(R.id.textView55);

        username = findViewById(R.id.textView22);

         layout= findViewById(R.id.container);


        countryS= findViewById(R.id.spinner);

        loadingPb = findViewById(R.id.progressBar4);
        signupBtn= findViewById(R.id.button19);

        password= findViewById(R.id.textView2223);


//        }
//        catch ( Exception e)
//        {
//            Log.e("exception" , e.getMessage());
//        }

    }




    public  boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }



    public void checkDataThenRegister()
    {
//
        if(!username.getText().toString().isEmpty() &&
                !phone.getText().toString().isEmpty() &&
                !password.getText().toString().isEmpty() &&
                !email.getText().toString().isEmpty() &&
                countryS.getSelectedItemPosition()>0)
        {

            DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
            long id = dataBaseHelper.insertUser(username.getText().toString()
                    , email.getText().toString() , password.getText().toString(),
                    phone.getText().toString(),
                    city);


            SharedPreferences sharedPreferences ;
            SharedPreferences.Editor editor;

            sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();

            editor.putString("user_id" ,id+"");
            editor.putString("name" ,username.getText().toString());
            editor.putString("email" ,email.getText().toString());

            editor.putString("date" ,phone.getText().toString());


            editor.commit();

            Toast.makeText(this,"Register successfully", Toast.LENGTH_LONG).show();

            Intent i = new Intent(RegisterActivity.this , HomeActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);


        }
        else{

            loadingPb.setVisibility(View.GONE);
            signupBtn.setVisibility(View.VISIBLE);


            Toast.makeText(this,"Validation error ," +
                    "Missing some of Data", Toast.LENGTH_LONG).show();
        }
    }


    public void saveUserAuth(String user_id )
    {
        SharedPreferences sharedPreferences ;
        SharedPreferences.Editor editor;

        sharedPreferences = getSharedPreferences("olx" , Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editor.putString("user_id" ,user_id);
        editor.commit();

    }


    final Calendar myCalendar = Calendar.getInstance();
    private void updateLabel()
    {
        String myFormat = "dd-mm-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        phone.setText(sdf.format(myCalendar.getTime()));
    }
    private void createDatePicker()
    {
        phone.setFocusable(false);
        phone.setFocusableInTouchMode(false);
        final DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };



        phone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(RegisterActivity.this, dateListener, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
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
