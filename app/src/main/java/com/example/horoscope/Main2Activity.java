package com.example.horoscope;

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

    ImageView iv1, iv2, iv3, iv4, iv5;
    TextView tv1, tv2, tv3, tv4, tv5, topTW;

    int s;
    String top;

    int images[] = {R.drawable.pk1, R.drawable.pk2, R.drawable.pk3,
            R.drawable.pk4, R.drawable.pk5, R.drawable.pk6};

    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        s = getIntent().getExtras().getInt("RESULT");
        top = getIntent().getExtras().getString("TOP");

        topTW = (TextView) findViewById(R.id.topTextView);
        topTW.setText(top);



        iv1 = (ImageView) findViewById(R.id.imageViev1);
        iv2 = (ImageView) findViewById(R.id.imageViev2);
        iv3 = (ImageView) findViewById(R.id.imageViev3);
        iv4 = (ImageView) findViewById(R.id.imageViev4);
        iv5 = (ImageView) findViewById(R.id.imageViev5);


        tv1 = (TextView) findViewById(R.id.hpTextView);
        tv2 = (TextView) findViewById(R.id.luckTextView);
        tv3 = (TextView) findViewById(R.id.moneyTextView);
        tv4 = (TextView) findViewById(R.id.workTextView);
        tv5 = (TextView) findViewById(R.id.loveTextView);

        Calendar c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);



        int seed1 = s+day+month+year+1;
        int seed2 = s+day+month+year+2;
        int seed3 = s+day+month+year+3;
        int seed4 = s+day+month+year+4;
        int seed5 = s+day+month+year+5;



        Random r1 = new Random(seed1);
        Random r2 = new Random(seed2);
        Random r3 = new Random(seed3);
        Random r4 = new Random(seed4);
        Random r5 = new Random(seed5);


        int randomResultHp = r1.nextInt(6);
        int randomResultLuck = r2.nextInt(6);
        int randomResultMoney = r3.nextInt(6);
        int randomResultWork = r4.nextInt(6);
        int randomResultLove = r5.nextInt(6);

        //textView.setText(R.string.hello);

        if(randomResultHp<2)
            tv1.setText(R.string.badHp);
        if (randomResultHp>3)
            tv1.setText(R.string.goodHp);
        if(randomResultLuck<2)
            tv2.setText(R.string.badLuck);
        if (randomResultLuck>3)
            tv2.setText(R.string.goodLuck);
        if(randomResultMoney<2)
            tv3.setText(R.string.badMoney);
        if (randomResultMoney>3)
            tv3.setText(R.string.goodMoney);
        if(randomResultWork<2)
            tv4.setText(R.string.badWork);
        if (randomResultWork>3)
            tv4.setText(R.string.goodWork);
        if(randomResultLove<2)
            tv5.setText(R.string.badLove);
        if (randomResultLove>3)
            tv5.setText(R.string.goodLove);


        iv1.setImageResource(images[randomResultHp]);
        iv2.setImageResource(images[randomResultLuck]);
        iv3.setImageResource(images[randomResultMoney]);
        iv4.setImageResource(images[randomResultWork]);
        iv5.setImageResource(images[randomResultLove]);


    }
}
