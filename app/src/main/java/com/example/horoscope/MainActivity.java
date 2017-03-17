package com.example.horoscope;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public Intent intent;

    public int result;

    int day,month,year;
    EditText numberOfDay, numberOfMonth, numberOfYear;

    //int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static  final String RESULT = "RESULT";
    private static  final String TOP = "TOP";

    String birthdayStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOfDay = (EditText) findViewById(R.id.yearTextEdit);
        numberOfMonth = (EditText) findViewById(R.id.monthTextEdit);
        numberOfYear = (EditText) findViewById(R.id.dayTextEdit);

        final Button predictButton = (Button) findViewById(R.id.predict);
        predictButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                    day = Integer.parseInt(numberOfDay.getText().toString());
                    month = Integer.parseInt(numberOfMonth.getText().toString());
                    year = Integer.parseInt(numberOfYear.getText().toString());

                    result=day+month+year;

                    intent = new Intent(MainActivity.this, Main2Activity.class);
                    birthdayStr = ""+year+"."+month+"."+day;
                    intent.putExtra(RESULT,result);
                    intent.putExtra(TOP, birthdayStr);
                    startActivity(intent);



            }
        });

    }


    public void newScreen(View v) {
        Intent intObj = new Intent(this, Main2Activity.class);

        switch(v.getId()) {
            case R.id.button6:
                intObj.putExtra("RESULT", 12);
                intObj.putExtra("TOP", "Рыбы");
                break;
            case R.id.button5:
                intObj.putExtra("RESULT", 11);
                intObj.putExtra("TOP", "Рак");
                break;
            case R.id.button4:
                intObj.putExtra("RESULT", 10);
                intObj.putExtra("TOP", "Водолей");
                break;
            case R.id.button3:
                intObj.putExtra("RESULT", 9);
                intObj.putExtra("TOP", "Весы");
                break;
            case R.id.button10:
                intObj.putExtra("RESULT", 8);
                intObj.putExtra("TOP", "Телец");
                break;
            case R.id.button9:
                intObj.putExtra("RESULT", 7);
                intObj.putExtra("TOP", "Овен");
                break;
            case R.id.button8:
                intObj.putExtra("RESULT", 6);
                intObj.putExtra("TOP", "Козерог");
                break;
            case R.id.button7:
                intObj.putExtra("RESULT", 5);
                intObj.putExtra("TOP", "Лев");
                break;
            case R.id.button12:
                intObj.putExtra("RESULT", 4);
                intObj.putExtra("TOP", "Близнецы");
                break;
            case R.id.button14:
                intObj.putExtra("RESULT", 3);
                intObj.putExtra("TOP", "Дева");
                break;
            case R.id.button13:
                intObj.putExtra("RESULT", 2);
                intObj.putExtra("TOP", "Скорпион");
                break;
            case R.id.button11:
                intObj.putExtra("RESULT", 1);
                intObj.putExtra("TOP", "Стрелец");
                break;
        }

        startActivity(intObj);
    }
}
