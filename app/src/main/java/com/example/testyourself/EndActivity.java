package com.example.testyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    TextView txt_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);


        txt_score = (TextView)findViewById(R.id.final_score);
        String sc = Integer.toString(getIntent().getIntExtra("score",0));
        String total = getIntent().getStringExtra("total");
        txt_score.setText(sc+total);

    }
}