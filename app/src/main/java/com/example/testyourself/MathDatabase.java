package com.example.testyourself;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;

public class MathDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyMathTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public MathDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.sql = db;
        final String SQL_CREATE_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NUM + " INTEGER" +
                ")";
        db.execSQL(SQL_CREATE_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Questions q1 = new Questions("حصل طالب على 1200 درجة من 1500 .....فكم نسبته ؟", "80%", "85%", "70%", "75%", 1);
        addQuestion(q1);
        Questions q2 = new Questions("انفق احمد 1200 ريال لشراء كتاب علما بأن هذا المبلغ يمثل 15% من راتبه الاساسي.....فكم يكون راتب احمد ؟", "7000", "7500", "8000", "8500", 3);
        addQuestion(q2);
        Questions q3 = new Questions("غرفة مستطيلة محيطها 48 م , لو زاد عرضها 2 م ونقص طولها 2م لأصبحت مربعة\n" +
                "وتصبح مساحتها = ...........؟\n", "121", "144", "169", "196", 2);
        addQuestion(q3);
        Questions q4 = new Questions("قطعت ورقة مربعة , طويت لمستطيلين متساويين محيط الواحد = 12 سم , ما مساحة الورقة الاصلية ؟", "8", "9", "16", "36", 3);
        addQuestion(q4);
        Questions q5 = new Questions("متوسط عشرة ارقام = 15 , اذا حذفنا رقم اصبح المتوسط = 16\n" +
                "ما هو الرقم المحذوف ؟\n", "5", "6", "7", "8", 2);
        addQuestion(q5);
        Questions q6 = new Questions("اذا كان 10% من س = 8..........فكم يساوى 50% من س؟", "30", "40", "50", "60", 2);
        addQuestion(q6);
        Questions q7 = new Questions("اذا كان 60 = 15% من س , فأن س = .........؟", "400", "600", "300", "500", 1);
        addQuestion(q7);
        Questions q8 = new Questions("80 طالب فى مدرسة كانت نسبة النجاح فيها 75% ,فما عدد الناجحين ؟ ", "40", "45", "50", "60", 4);
        addQuestion(q8);
        Questions q9 = new Questions("اذا كانت س = -1 ,فأن (2س)^2-س^2+8س-1 = .....؟", "-8", "-9", "-10", "-11", 3);
        addQuestion(q9);
        Questions q10 = new Questions("اذا علمت ان 2/1س+1=2/1+س\n"+"فأن س=.....؟\n", "صفر", "1", "-1", "2", 2);
        addQuestion(q10);


        Questions q11 = new Questions("اقلعت طائرة من الرياض و 1/3 مقاعدها شاغرة وفى جدة ركب 21 مسافرا دون ان ينزل احد فاصبح 3/4 مقاعدها مستعملة \n" +
                "اختر صيغة المعادلة الصحيحة مع العلم ان (س عدد المقاعد)؟\n","1/3س","2/3س","3/4س","1/4س",3);
        addQuestion(q11);
        Questions q12 = new Questions("2^100-2^99 = 2^س\n" +
                "س = ........؟\n", "1", "99", "9", "10", 2);
        addQuestion(q12);
        Questions q13 = new Questions("تحرك عقرب الساعة 120 درجة , كم دقيقة مضت ؟\n" +
                "(لاحظ ان العقرب المتحرك هو عقرب الساعات وليس الدقائق)\n", "200", "220", "240", "260", 3);
        addQuestion(q13);
        Questions q14 = new Questions("- ضبطت ساعة على الثامنة صباحا ,ولكنها تؤخر 20 دقيقة لكل ساعة\n" +
                "فكم يكون الوقت فيها اذا كان الوقت الفعلى 8 مساءا؟\n", "8م", "2م", "4ص", "4م", 4);
        addQuestion(q14);
        Questions q15 = new Questions("9/3+9/3", "6", "3", "9", "12", 1);
        addQuestion(q15);


    }

    private void addQuestion(Questions questions) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionTable.COLUMN_QUESTION, questions.getQuestion());
        cv.put(QuestionTable.COLUMN_OPTION1, questions.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2, questions.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3, questions.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4, questions.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NUM, questions.getAnswerNum());
        sql.insert(QuestionTable.TABLE_NAME, null, cv);
    }

    public List<Questions> getAllQuestions() {
        List<Questions> questionlist = new ArrayList<>();
        sql = getReadableDatabase();
        Cursor c = sql.rawQuery("SELECT * FROM " + EnglishContract.QuestionTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNum(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NUM)));
                questionlist.add(questions);
            }
            while (c.moveToNext());
        }

        c.close();
        return questionlist;

    }

}
