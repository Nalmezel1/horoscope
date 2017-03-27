package com.example.horoscope;

import android.content.res.Resources;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {


    ImageView [] IVmass = new ImageView[5];
    TextView [] TVmass = new TextView[5];


    Random [] randoms = new Random[5];
    int [] randomResults = new int[5];

    TextView topTW;

    int userBirthday , sumOfCurrentDay;
    String top;


    int images[] = {R.drawable.pk1, R.drawable.pk2, R.drawable.pk3,
            R.drawable.pk4, R.drawable.pk5, R.drawable.pk6};


    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userBirthday = getIntent().getExtras().getInt("RESULT");
        top = getIntent().getExtras().getString("TOP");

        topTW = (TextView) findViewById(R.id.topTextView);
        topTW.setText(top);


        IVmass[0] = (ImageView) findViewById(R.id.hpIV);
        IVmass[1] = (ImageView) findViewById(R.id.luckIV);
        IVmass[2] = (ImageView) findViewById(R.id.moneyIV);
        IVmass[3] = (ImageView) findViewById(R.id.workIV);
        IVmass[4] = (ImageView) findViewById(R.id.loveIV);


        TVmass[0] = (TextView) findViewById(R.id.hpTextView);
        TVmass[1] = (TextView) findViewById(R.id.luckTextView);
        TVmass[2] = (TextView) findViewById(R.id.moneyTextView);
        TVmass[3] = (TextView) findViewById(R.id.workTextView);
        TVmass[4] = (TextView) findViewById(R.id.loveTextView);

        Calendar c = Calendar.getInstance();

        if(getIntent().getExtras().getBoolean("FLAG")){
            sumOfCurrentDay = c.get(Calendar.DAY_OF_MONTH);
        }

        sumOfCurrentDay += c.get(Calendar.MONTH) + c.get(Calendar.YEAR);

        for(int i = 0; i < 5; i++){
            randoms[i] = new Random(userBirthday+sumOfCurrentDay+i+1);
            randomResults [i] = randoms[i].nextInt(6);
            IVmass[i].setImageResource(images[randomResults [i]]);

        }

        Resources res = getResources();

        TVmass[0].setText(res.getStringArray(R.array.textPredictionHealth)[randomResults [0]]);
        TVmass[1].setText(res.getStringArray(R.array.textPredictionLuck)[randomResults [1]]);
        TVmass[2].setText(res.getStringArray(R.array.textPredictionMony)[randomResults [2]]);
        TVmass[3].setText(res.getStringArray(R.array.textPredictionWork)[randomResults [3]]);
        TVmass[4].setText(res.getStringArray(R.array.textPredictionLove)[randomResults [4]]);

    }


}
