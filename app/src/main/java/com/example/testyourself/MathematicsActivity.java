package com.example.testyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MathematicsActivity extends AppCompatActivity {

    //public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 60000;

    private TextView txtQuestion;
    private TextView txtScore;
    private TextView txtQuestionCount;
    private TextView txtCountDown;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button btnConfirm;

    private ColorStateList textDefaultColorRb;
    private ColorStateList textDefaultColorCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Questions> questionlist;
    private int questionCounter;
    private int questionCountTotal;
    private Questions currentQuestion;

    private int score;
    private boolean answered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematics);

        txtQuestion = findViewById(R.id.txt_question);
        txtScore = findViewById(R.id.txt_score);
        txtQuestionCount = findViewById(R.id.txt_question_count);
        txtCountDown = findViewById(R.id.txt_count_down);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_btn1);
        rb2 = findViewById(R.id.radio_btn2);
        rb3 = findViewById(R.id.radio_btn3);
        rb4 = findViewById(R.id.radio_btn4);
        btnConfirm = findViewById(R.id.btn_confirm);

        textDefaultColorRb = rb1.getTextColors();
        textDefaultColorCd = txtCountDown.getTextColors();

        MathDatabase dbHelper = new MathDatabase(this);
        questionlist = dbHelper.getAllQuestions();
        questionCountTotal = questionlist.size();
        Collections.shuffle(questionlist);
        showNextQuestion();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answered){
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()||rb4.isChecked()){
                        checkAnswer();
                    }
                    else{
                        Toast.makeText(MathematicsActivity.this, "please, Select an answer!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    showNextQuestion();
                }
            }
        });
    }
    private void showNextQuestion(){
        rb1.setTextColor(textDefaultColorRb);
        rb2.setTextColor(textDefaultColorRb);
        rb3.setTextColor(textDefaultColorRb);
        rb4.setTextColor(textDefaultColorRb);
        rbGroup.clearCheck();

        if(questionCounter < questionCountTotal){
            currentQuestion = questionlist.get(questionCounter);
            txtQuestion.setText(currentQuestion.getQuestion());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());

            questionCounter++;
            txtQuestionCount.setText("Question:"+questionCounter+"/"+questionCountTotal);
            answered = false;
            btnConfirm.setText("Confirm");

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();
        }
        else{
            finishTest();
        }
    }

    private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes = (int)(timeLeftInMillis / 1000) / 60;
        int seconds = (int)(timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);

        txtCountDown.setText(timeFormatted);

        if(timeLeftInMillis < 1000){
            txtCountDown.setTextColor(Color.RED);
        }
        else {
            txtCountDown.setTextColor(textDefaultColorCd);
        }
    }

    private void checkAnswer(){
        answered = true;

        countDownTimer.cancel();

        RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNum = rbGroup.indexOfChild(rbSelected) + 1;

        if(answerNum == currentQuestion.getAnswerNum()){
            score++;
            txtScore.setText("Score: "+score);
        }
        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);


        switch (currentQuestion.getAnswerNum()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                txtQuestion.setText("Answer 1 is correct");
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                txtQuestion.setText("Answer 2 is correct");
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                txtQuestion.setText("Answer 3 is correct");
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                txtQuestion.setText("Answer 4 is correct");
                break;
        }

        if(questionCounter < questionCountTotal){
            btnConfirm.setText("Next");
        }
        else{
            btnConfirm.setText("Finish");

        }
    }

    private void finishTest(){
        /*Intent resultIntent = new Intent();
        resultIntent.putExtra(EXTRA_SCORE,score);
        setResult(RESULT_OK,resultIntent);*/
        Intent int_end = new Intent(MathematicsActivity.this, EndActivity.class);

        int_end.putExtra("score", score);
        int_end.putExtra("total", "/15");

        startActivity(int_end);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer != null){
            countDownTimer.cancel();
        }
    }
}