package com.example.testyourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;

public class IqDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyIqTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public IqDatabase(Context context) {
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
        Questions q1 = new Questions("if you rearrange the letters ‘CIFAIPC’ you would have the name of an:", "city", "animal", "ocean", "river", 3);
        addQuestion(q1);
        Questions q2 = new Questions("which one of the numbers does not belong in the following series?\n" +
                "2-3-6-7-8-14-15-30\n", "7", "6", "3", "8", 4);
        addQuestion(q2);
        Questions q3 = new Questions("if each person in a group shakes hands with other six persons, then how many handshakes occur in total?", "21", "42", "12", "6", 1);
        addQuestion(q3);
        Questions q4 = new Questions("what is the missing number in the sequence shown below?\n" +
                "1-8-27-?-125-216\n", "46", "64", "36", "63", 2);
        addQuestion(q4);
        Questions q5 = new Questions("if two men start at a point and travel 2 Km each in opposite directions and then turn right and travel 1.5 Km each, then the distance between them is?", "7", "6", "5", "5.5", 3);
        addQuestion(q5);
        Questions q6 = new Questions("which one of the five choices makes the best comparison?\n" +
                "PEACH is to HCAEP as 46251 is to :\n", "25641", "15264", "16254", "15246", 2);
        addQuestion(q6);
        Questions q7 = new Questions("which letter continues the series with?\n" +
                "A, B, D, G, K, …\n", "M", "N", "O", "P", 4);
        addQuestion(q7);
        Questions q8 = new Questions("if it were two hours later, it would be half as long until midnight as it would be if it were an hour later. What time is it now?", "18:30", "20:00", "21:00", "22:00", 3);
        addQuestion(q8);
        Questions q9 = new Questions("which vowel comes midway between J and T?", "A", "E", "I", "O", 4);
        addQuestion(q9);
        Questions q10 = new Questions("fill in the missing number:\n" +
                "0,1,1,2,3,5,8,13,---,34,55\n", "20", "21", "22", "23", 2);
        addQuestion(q10);

        Questions q11 = new Questions("if a circle is one, how many is an octagon?", "2", "4", "6", "8", 4);
        addQuestion(q11);
        Questions q12 = new Questions("if you count from 1 to 100, how many 7’s will you pass on the way?", "10", "11", "19", "2O", 4);
        addQuestion(q12);
        Questions q13 = new Questions("continue the following number series with the group of numbers below which best continues the series?\n" +
                "1 10 3 9 5 8 7 7 9 6 ? ?\n", "11 5", "10 5", "10 4", "11 6", 1);
        addQuestion(q13);
        Questions q14 = new Questions("four years ago, Jane was twice as old as Sam. Four years on from now, Sam will be ¾ Jane’s age. How old is Jane now?", "8", "10", "12", "14", 3);
        addQuestion(q14);
        Questions q15 = new Questions("two men, starting at the same point, walk in opposite directions for 4 meters, turn left and walk another 3 meters. What is the distance between them?", "2m", "6m", "10m", "12.5m", 3);
        addQuestion(q15);
        Questions q16 = new Questions("one word in this list doesn’t belong to the same group: Receiver, Reviver, Racecar, Radar.", "Receiver", "Reviver", "Racecar", "Radar", 1);
        addQuestion(q16);
        Questions q17 = new Questions("choose the number that is 1/4 of 1/2 of 1/5 of 200:", "2", "5", "0", "25", 2);
        addQuestion(q17);
        Questions q18 = new Questions("if two typists can type two pages in two minutes, how many typists will it take to type 18 pages in six minutes?", "3", "4", "6", "12", 3);
        addQuestion(q18);
        Questions q19 = new Questions("I’m a male. If Albert’s son is my son’s father, what is the relationship between Albert and I?", "he is my brother", "he is my uncle", "he is my father", "he is my son", 3);
        addQuestion(q19);
        Questions q20 = new Questions("6121135 is to flame as 21215120 is to ?", "voice", "bald", "castle", "bloat", 4);
        addQuestion(q20);

        Questions q21 = new Questions("which letter comes next in this series of letters?\n" +
                "B A C B D C E D F ?\n", "C", "D", "E", "F", 3);
        addQuestion(q21);
        Questions q22 = new Questions("A UFO was detected on the radar flying 7400 miles in 3 min, what is the estimated speed per hour?", "117400 miles/h.", "1480 miles/h.", "14800 miles/h.", "148000 miles/h.", 4);
        addQuestion(q22);
        Questions q23 = new Questions("please enter the missing number: \n" +
                "4, 5, 8, 17, 44, ?\n", "134", "38", "3", "125", 4);
        addQuestion(q23);
        Questions q24 = new Questions("finish the sentence, Gym is to Healthy as Book is to ?", "Good", "Intelligent", "Fluent", "Knowledgeable", 4);
        addQuestion(q24);
        Questions q25 = new Questions("what number continues the series with?\n" +
                "0, 1, 1, 2, 3, 5, 8, 13, …\n", "18", "21", "25", "14", 2);
        addQuestion(q25);
        Questions q26 = new Questions("if A is bigger than B but smaller than C, then:", "B is the biggest", "B is bigger than C", "C is bigger than A", "C is the smallest", 3);
        addQuestion(q26);
        Questions q27 = new Questions("which of the four is least like the other three?", "copper", "Ivory", "gold", "silver", 2);
        addQuestion(q27);
        Questions q28 = new Questions("which word best expresses the meaning of: ”Reassure”?", "hearten", "induce", "proffer", "submit", 1);
        addQuestion(q28);
        Questions q29 = new Questions("WING is to AIR as _______.", "FLIPPER is to WATER", "LUNG is to BREATH", "ENGINE is to JET", "ELBOW is to HAND", 1);
        addQuestion(q29);
        Questions q30 = new Questions("4 + 4 * ¼ + 4 - 4 = ?", "16", "5", "17", "4", 2);
        addQuestion(q30);


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
