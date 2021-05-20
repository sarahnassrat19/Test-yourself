package com.example.testyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartExamActivity extends AppCompatActivity {
    /*private static final int REQUEST_CODE_TEST=1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";
    private TextView txt_highScore;
    private int highscore;*/

    Button btn_start;
    TextView txt_examname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_exam);

        //txt_highScore = (TextView)findViewById(R.id.id_highscore);
        //loadhighscore();

        btn_start = (Button)findViewById(R.id.id_start);
        txt_examname = (TextView)findViewById(R.id.id_examname);

        String examNum = getIntent().getStringExtra("examname");

        switch (examNum){
            case "1":
                txt_examname.setText("English Exam");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_english = new Intent(StartExamActivity.this,EnglishActivity.class);
                        startActivity(int_english);
                    }
                });
                break;
            case "2":
                txt_examname.setText("IQ Exam");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_iq = new Intent(StartExamActivity.this,IqActivity.class);
                        startActivity(int_iq);
                    }
                });
                break;
            case "3":
                txt_examname.setText("Soft Skills Exam");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_soft = new Intent(StartExamActivity.this,SoftskillsActivity.class);
                        startActivity(int_soft);
                    }
                });
                break;
            case "4":
                txt_examname.setText("Math Exam");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_math = new Intent(StartExamActivity.this,MathematicsActivity.class);
                        startActivity(int_math);
                    }
                });
                break;
            case "5":
                txt_examname.setText("Programming Exam (C++)");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_prog1 = new Intent(StartExamActivity.this,CPPActivity.class);
                        startActivity(int_prog1);
                    }
                });
                break;
            case "6":
                txt_examname.setText("Programming Exam (Java)");
                btn_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent int_prog2 = new Intent(StartExamActivity.this,JavaActivity.class);
                        startActivity(int_prog2);
                    }
                });
                break;
        }

    }
    /*@Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_TEST){
            if(resultCode == RESULT_OK){
                int score = data.getIntExtra(EnglishActivity.EXTRA_SCORE,0);
                if(score > highscore){
                    updateHighscore(score);
                }
            }
        }

    }

    private void loadhighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE,0);
        txt_highScore.setText("Highscore: "+highscore);
    }


    private void updateHighscore(int newhighscore){
        highscore = newhighscore;
        txt_highScore.setText("Highscore: "+highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor ed = prefs.edit();
        ed.putInt(KEY_HIGHSCORE,highscore);
        ed.apply();
    }*/

}