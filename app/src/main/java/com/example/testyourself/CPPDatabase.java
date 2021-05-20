package com.example.testyourself;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;

public class CPPDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyCPPTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public CPPDatabase(Context context) {
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
        Questions q1 = new Questions("- in object oriented programming abstraction refers to?", "showing only the essential features of the application and hiding the details", "data binding", "reuse once written code again and again", "features which allows to create functions with same name", 1);
        addQuestion(q1);
        Questions q2 = new Questions("-_______________is also an operator that is used to get information about the amount of memory allocated for data types and objects", "typedef", "ternary", "sizeOf", "shift", 3);
        addQuestion(q2);
        Questions q3 = new Questions("what will be the output of following code?\n" +
                "#include<iostream>\n" +
                "Int main(){\n" +
                "Int i=10;\n" +
                "if(i==20)\n" +
                "cout<<I;\n" +
                "return 0;}\n", "10", "20", "0", "error", 2);
        addQuestion(q3);
        Questions q4 = new Questions("what will be the output of the following code?\n" +
                "Void fun(){\n" +
                "Static int i=10;\n" +
                "Int i=10;\n" +
                "I++;\n" +
                "Cout<<I;}\n" +
                "Int main(){\n" +
                "Fun();    fun();       fun();}\n", "10    11    12", "11    11    11", "11    12   13", "error", 3);
        addQuestion(q4);
        Questions q5 = new Questions("you can never use or compute address of________ variable?", "local", "static", "global", "register", 4);
        addQuestion(q5);
        Questions q6 = new Questions("what will be the output of the following code?\n" +
                "Void calc(int x);\n" +
                "Int main(){\n" +
                "Int x=10;\n" +
                "Calc(x);\n" +
                "Printf(“%d”,x);}\n" +
                "Void calc(int x){\n" +
                "X = x + 10;}\n", "20", "10", "0", "error", 2);
        addQuestion(q6);
        Questions q7 = new Questions("default storage class for local variables is?", "auto", "register", "static", "extern", 1);
        addQuestion(q7);
        Questions q8 = new Questions("-____________is defined as user defined data type and it also contains functions in it?", "object", "data members", "class", "polymorphism", 3);
        addQuestion(q8);
        Questions q9 = new Questions("function which is defined inside a class is by default treated as______.", "virtual", "public", "inline", "none of above", 3);
        addQuestion(q9);
        Questions q10 = new Questions("function overloading do not rely on_______.", "number of parameter", "order of parameter", "return values", "differ in type of parameter", 3);
        addQuestion(q10);

        Questions q11 = new Questions("which of the following statement is correct?", "overloaded functions can have at most one default argument", "an overloaded function cannot have default argument", "all arguments of an overloaded function can be default", "a function if overloaded more than once cannot have default argument", 3);
        addQuestion(q11);
        Questions q12 = new Questions("what will be the output of the following code?\n" +
                "Void sum(int x, int y=0){\n" +
                "Cout<<x+y;}\n" +
                "Int main(){\n" +
                "Sum(10);\n" +
                "Sum(10,0);\n" +
                "Sum(10,10);}\n", "10   10   20", "10   20   20", "0   10   10", "error", 1);
        addQuestion(q12);
        Questions q13 = new Questions("what does a compiler add to an empty class declaration in c++?", "a constructor", "a destructor", "assignment operator", "all of the above", 4);
        addQuestion(q13);
        Questions q14 = new Questions("which of the following statement is not correct for a namespace?", "namespace definition doesn’t terminates with a semicolon like in class definition", "you can use an alias name for your namespace name, for ease of use.", "you can create instance of namespace.", "namespace definition must be done at global scope, or nested inside another namespace", 3);
        addQuestion(q14);
        Questions q15 = new Questions("what will be the output of the following code?\n" +
                "Int main(){\n" +
                "Int i=10;\n" +
                "Int &j=I;\n" +
                "Int k=20;\n" +
                "J=k;\n" +
                "Cout<<i<<j<<k;\n" +
                "Return 0;}\n", "10    20    20", "20    20    20", "10    10    20", "error", 2);
        addQuestion(q15);
        Questions q16 = new Questions("Destructor has the same name as the constructor and it is preceded by_____.", "!", "?", "~", "$", 3);
        addQuestion(q16);
        Questions q17 = new Questions("_________used to make a copy of one class object from another class object of the same class type?", "constructor", "copy constructor", "destructor", "default constructor", 2);
        addQuestion(q17);
        Questions q18 = new Questions("what will be the out put of the following code?\n" +
                "Int main(){\n" +
                "Const int i=10;\n" +
                "Const int j=i+10;  //line 4\n" +
                "Cout<<i++;    //line 5}\n", "10", "11", "error at line 4", "error at line 5", 4);
        addQuestion(q18);
        Questions q19 = new Questions("member inside class are by default________.", "public", "private", "protected", "none of the above", 2);
        addQuestion(q19);
        Questions q20 = new Questions("which of the following statement is not correct about references in C++?", "reference must be initialized when it is created", "once initialized, we cannot reinitialize a reference", "we can have a NULL reference.", "reference is automatically dereferenced.", 3);
        addQuestion(q20);

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
