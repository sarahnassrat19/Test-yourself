package com.example.testyourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;


public class EnglishDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyEnglishTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public EnglishDatabase(Context context) {
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
        Questions q1 = new Questions("Have you sent that e-mail to Mr.O’Neill? yes, I’ve ______done that.", "still", "already", "yet", "now", 2);
        addQuestion(q1);
        Questions q2 = new Questions("Karim _______fly to Stockholm tomorrow.", "to going", "goes to", "is going to", "go to", 3);
        addQuestion(q2);
        Questions q3 = new Questions("-“Those shopping bags look very heavy. _____ carry one for you?”\n" +
                "-“that’s very kind of you!”\n", "Will I", "Do I have", "Shall I", "Do I", 3);
        addQuestion(q3);
        Questions q4 = new Questions("I haven’t seen your cousin ______over a year ago.", "since", "while", "for", "during", 1);
        addQuestion(q4);
        Questions q5 = new Questions("There is ______of drinks left from the party.", "little", "much", "a lot", "too", 3);
        addQuestion(q5);
        Questions q6 = new Questions("Have you phoned the restaurant about the booking? Yes, I’ve ______done that.", "still", "already", "yet", "now", 2);
        addQuestion(q6);
        Questions q7 = new Questions("If I didn’t have to work, i______the beach.", "will move to", "have moved to", "would move to", "would have moved to", 3);
        addQuestion(q7);
        Questions q8 = new Questions("We have to go to the supermarket _____some bread and milk.", "for getting", "to get", "to getting", "for to get ", 2);
        addQuestion(q8);
        Questions q9 = new Questions("Have you _____?", "got any friends in Barcelona", "not got no friends in Barcelona", "in Barcelona any friends", "friends in Barcelona got", 1);
        addQuestion(q9);
        Questions q10 = new Questions("We _______better study more if we want to pass the exam.", "would", "should", "had", "ought", 2);
        addQuestion(q10);
        Questions q11 = new Questions("What is a “lot”?", "an item sold in an auction", "a big item or a file", "a large island with no army", "", 1);
        addQuestion(q11);
        Questions q12 = new Questions("What’s another word for buckwild?", "untrained animal", "uncontrolled", "pet", "", 2);
        addQuestion(q12);
        Questions q13 = new Questions("The library is _____ for knowledge", "Placed", "Ground zero", "Starting", "", 2);
        addQuestion(q13);
        Questions q14 = new Questions("This means to produce or devise something", "Explore", "Scout out", "Come up with", "", 3);
        addQuestion(q14);
        Questions q15 = new Questions("What is Hepatitis?", "A liver disease", "An American holiday", "A marketing strategy", "", 1);
        addQuestion(q15);
        Questions q16 = new Questions("They were scammed in two separate ____.", "Incidents", "Accidents", "Collision ", "", 1);
        addQuestion(q16);
        Questions q17 = new Questions("A: Let me do that for you.", "B: I will do it myself", "B: I will do it by myself", "both answers are correct", "", 3);
        addQuestion(q17);
        Questions q18 = new Questions("A: Can I borrow some money?", "B: I have no money", "B: I have none money", "both answers are correct", "", 1);
        addQuestion(q18);
        Questions q19 = new Questions("I don’t pay attention to _____.", "Such individuals", "Such as individuals", "As such individuals", "", 1);
        addQuestion(q19);
        Questions q20 = new Questions("What does “Hundo P” mean?", "Short for “handout paper”", "Short for “hundred percent”", "Short for “Hyundai palisade”", "", 2);
        addQuestion(q20);
        Questions q21 = new Questions("I will wait ______twenty minutes","other","another","Both answers are correct","",2);
        addQuestion(q21);
        Questions q22 = new Questions("This was considered a _____day.","History","Historical","Historic","",3);
        addQuestion(q22);
        Questions q23 = new Questions("Prison time is ______ time.","Slow","Slowly","A slow","",1);
        addQuestion(q23);
        Questions q24 = new Questions("The whole class ran _____.","fast","fastly","fastest","",1);
        addQuestion(q24);
        Questions q25 = new Questions("ترجم: يمبغى عليك ان لا تتحدث  اليه","you should not to talk to him","you had better not to talk to him","you should not talk to him","",3);
        addQuestion(q25);
        Questions q26 = new Questions("_____ are stronger than _____.","Boys - girls","The boys – the girls","The boys - girls","",1);
        addQuestion(q26);
        Questions q27 = new Questions("What happened _____ after Christmas?","Sunday","The Sunday","Sundays","",2);
        addQuestion(q27);
        Questions q28 = new Questions("ترجم: كانت النافذة مكسورة","The window is break","The window is broken","The window was broken","",3);
        addQuestion(q28);
        Questions q29 = new Questions("Get the passive voice: “Jill wrote a book”","The book was written by Hill","A book is written by Jill","A book was written by Jill","",3);
        addQuestion(q29);
        Questions q30 = new Questions("She _____to Spain last year.","Went","Has gone","Had gone","",1);
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
        Cursor c = sql.rawQuery("SELECT * FROM " + QuestionTable.TABLE_NAME, null);

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
