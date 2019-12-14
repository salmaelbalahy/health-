package com.iscoapps.healthapp.Views.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.iscoapps.healthapp.DataBase.SharedPreferencesManager;
import com.iscoapps.healthapp.MyApplication;
import com.iscoapps.healthapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AdviceActivity extends AppCompatActivity {

    TextView title , body;


    String doing , smoker ;
    Long age;


    int heart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);

        title = findViewById(R.id.textView7);
        body = findViewById(R.id.textView8);

        doing =  getIntent().getExtras().getString("doing");
        smoker =  getIntent().getExtras().getString("smoker");
        age =  calculteAge(this);

        handleAdvice();
    }

    @Override
    protected void onResume() {
        super.onResume();
        heart = SharedPreferencesManager.getIntValue(MyApplication.getContext(),"HeartRate");
        Toast.makeText(this,"Your Heart Rate = "+heart,Toast.LENGTH_LONG).show();

    }

    private long calculteAge(Context context)
    {

        String birthdate = getUserDate(context);
        if (!birthdate.equals(""))
        {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date d = null;
            try {
                d = formatter.parse(birthdate);//catch exception
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Calendar thatDay = Calendar.getInstance();
            thatDay.setTime(d); //rest is the same....


            Calendar today = Calendar.getInstance();

            long diff = today.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis
            long months = (diff / (24 * 60 * 60 * 1000))/30;
            return months;
        }
        return 0;

    }


    private String getUserDate(Context context )
    {
        SharedPreferences sharedPreferences ;
        SharedPreferences.Editor editor;

        sharedPreferences = context.getSharedPreferences("olx" , Context.MODE_PRIVATE);

        return sharedPreferences.getString( "date" , "") ;

    }


    public void handleAdvice()
    {
        if(age > 0 &&
                age <3 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
        heart > 100  && heart < 181)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.";

            body.setText(advice);
        }
        else if(age > 0 &&
                age <3&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 100 && heart < 181)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 0 &&
                age <3&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 100 && heart < 181)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 3 &&
                age <6 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 95 && heart < 165)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 3 &&
                age <6 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 95 && heart < 165)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }

        else if(age > 3 &&
                age <6 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 95 && heart < 165)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }

        else if(age > 6 &&
                age <9 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 80 && heart < 160)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }

        else if(age > 6 &&
                age <9 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 80 && heart < 160)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }

        else if(age > 6 &&
                age <9 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 80 && heart < 160)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }


        else if(age > 9 &&
                age <12 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 80 && heart < 156)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }


        else if(age > 9 &&
                age <12 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 80 && heart < 156)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }


        else if(age > 9 &&
                age <12 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 80 && heart < 156)
        {
            String advice = "\uF0B7 Help the baby to relax. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the baby well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 Be aware of medication side effects. .\n" +
                    "\uF0B7 See your doctor for regular check-ups..\n" +
                    "\uF0B7 For mothers, maintain the protein and calcium percentage. \n";


            body.setText(advice);
        }
        else if(age > 12 &&
                age <18 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 80 && heart < 155)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 12 &&
                age <18 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 80 && heart < 155)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 12 &&
                age <18 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 80 && heart < 155)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 18 &&
                age <24 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 80 && heart < 150)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 18 &&
                age <24 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 80 && heart < 150)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 18 &&
                age <24 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 80 && heart < 150)
        {
            String advice = "\uF0B7 Let the baby sleep in a suitable environment which provides him with the sense of relaxation.\n" +
                    "\uF0B7 Feeding the baby well.\n" +
                    "\uF0B7 For the mother, you should take care of the protein and calcium percentage in your body.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Keep the baby away from smoke or polluted air.\n" +
                    "\uF0B7 See your doctor for regular check-ups.\n";

            body.setText(advice);
        }
        else if(age > 24 &&
                age <36 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 76 && heart < 145)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 24 &&
                age <36 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 76 && heart < 145)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 24 &&
                age <36 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 76 && heart < 145)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 36 &&
                age <48 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 70 && heart < 136)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 36 &&
                age <48 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 70 && heart < 136)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 36 &&
                age <48 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 70 && heart < 136)
        {
            String advice = "\uF0B7 Drink enough water. \n" +
                    "\uF0B7 Avoid making children stressed. \n" +
                    "\uF0B7 Keep the baby in a calm place. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups.\n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol) OR smoke.\n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 48 &&
                age <72 &&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 45 && heart < 120)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 48 &&
                age <72 &&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 65 && heart < 215)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 48 &&
                age <72 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 65 && heart < 160)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 48 &&
                age <72 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 65 && heart < 131)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 48 &&
                age <72 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 65 && heart < 131)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 72 &&
                age <96 &&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 45 && heart < 120)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 72 &&
                age <96 &&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 59 && heart < 213)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 72 &&
                age <96 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 59 && heart < 160)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 72 &&
                age <96 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 59 && heart < 123)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 72 &&
                age <96 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 59 && heart < 123)
        {
            String advice = "\uF0B7 Starting doing exercises.it is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 96 &&
                age <144&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 110)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 96 &&
                age <144&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 52 && heart < 212)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 96 &&
                age <144&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 52 && heart < 155)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 96 &&
                age <144&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 52 && heart < 115)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 96 &&
                age <144&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 52 && heart < 115)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Avoid making the child stressed. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 144 &&
                age <180&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 144 &&
                age <180&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 47 && heart < 202)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 144 &&
                age <180&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 47 && heart < 155)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 144 &&
                age <180&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 47 && heart < 108)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 144 &&
                age <180&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 47 && heart < 108)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 The parents shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 43 && heart < 203)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 43 && heart < 155)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 43 && heart < 104)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 43 && heart < 104)
        {
            String advice = "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.   \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Feeding the child well and take care of the protein and calcium percentage. \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 43 && heart < 203)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 43 && heart < 155)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 43 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 180 &&
                age <216&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 43 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.    \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 You shouldn’t drink drugs(Alcohol)   OR smoke.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 202)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 202)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 156)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 216 &&
                age < 300&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 184)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 184)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 156)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 432 &&
                age < 540&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 193)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 193)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 156)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 312 &&
                age < 420&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 174)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 174)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 552 &&
                age < 660&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 164)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 164)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 672 &&
                age < 780&&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 154)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("no") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 100)
        {
            String advice = "\uF0B7 Limit takeaway and processed food.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("anexeity") &&
                heart > 60 && heart < 150)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("athlete") &&
                heart > 40 && heart < 100)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("do exercises") &&
                heart > 60 && heart < 154)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("breathing hard") &&
                heart > 60 && heart < 140)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("relaxing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else if(age > 780 &&
                smoker.equals("yes") &&
                doing.equals("nothing") &&
                heart > 60 && heart < 125)
        {
            String advice = "\uF0B7 Quit smoking in order to avoid heart diseases, lung cancer, and breathing problems.     \n" +
                    "\uF0B7 You should relax. \n" +
                    "\uF0B7 Limit your caffeine intake. Using too much caffeine can lead to disturbance in your heart rates.  \n" +
                    "\uF0B7 Drink enough water.  \n" +
                    "\uF0B7 Sleep enough time. It is suggested to sleep at least 6 hours per day. \n" +
                    "\uF0B7 Do exercises continously.It is suggests to exercise for 20 to 30 minutes per day.  \n" +
                    "\uF0B7 See your doctor for regular check-ups. \n" +
                    "\uF0B7 Control health conditions, such as high blood pressure, high cholesterol and diabetes   \n" +
                    "\uF0B7 Maintain a healthy body weight.  \n" +
                    "\uF0B7 Limit takeaway and processed food.  \n" +
                    "\uF0B7 Don’t drink drugs.  \n" +
                    "\uF0B7 Use relaxation strategies including yoga, deep breathing exercises, tai chi and meditation.  \n" +
                    "\uF0B7 Be aware of medication side effects. \n";

            body.setText(advice);
        }
        else{
            String advice = "You Are Normal :))";

            body.setText(advice);
        }
    }


}
