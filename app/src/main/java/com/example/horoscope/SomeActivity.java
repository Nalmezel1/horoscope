package com.example.horoscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_some);

        String gift = getIntent().getExtras().getString("RESULT");

        TextView infoTextView = (TextView)findViewById(R.id.textView4);
        infoTextView.setText(gift);
    }
}
