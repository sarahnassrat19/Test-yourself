package com.example.testyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamsListActivity extends AppCompatActivity {

    Button btn_english;
    Button btn_iq;
    Button btn_soft;
    Button btn_math;
    Button btn_prog1;
    Button btn_prog2;
    String examNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btn_english =(Button)findViewById(R.id.id_english);
        btn_iq =(Button)findViewById(R.id.id_iq);
        btn_soft =(Button)findViewById(R.id.id_softskills);
        btn_math =(Button)findViewById(R.id.id_math);
        btn_prog1 =(Button)findViewById(R.id.id_prog1);
        btn_prog2 =(Button)findViewById(R.id.id_prog2);


        btn_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum = "1";
                Intent int_english = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_english.putExtra("examname", examNum);

                startActivity(int_english);

            }
        });

        btn_iq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum="2";

                Intent int_iq = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_iq.putExtra("examname", examNum);

                startActivity(int_iq);

            }
        });

        btn_soft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum="3";

                Intent int_soft = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_soft.putExtra("examname", examNum);

                startActivity(int_soft);

            }
        });


        btn_math.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum="4";

                Intent int_math = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_math.putExtra("examname", examNum);

                startActivity(int_math);

            }
        });

        btn_prog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum="5";

                Intent int_prog1 = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_prog1.putExtra("examname", examNum);

                startActivity(int_prog1);

            }
        });

        btn_prog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                examNum="6";

                Intent int_prog2 = new Intent(ExamsListActivity.this, StartExamActivity.class);

                int_prog2.putExtra("examname", examNum);

                startActivity(int_prog2);

            }
        });
    }
}