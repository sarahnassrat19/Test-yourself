package com.example.testyourself;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;

public class JavaDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MyJavaTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public JavaDatabase(Context context) {
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
        Questions q1 = new Questions("Which of the following is a legal identifier in java?", "2variable", "#myvar", "+@$var", "$_myvar", 4);
        addQuestion(q1);
        Questions q2 = new Questions("which of these is NOT valid keyword or reserved word in java?", "default", "null", "String", "volatile", 2);
        addQuestion(q2);
        Questions q3 = new Questions("which is the legal range of values for a short?", "-128 to 127", "-256 to 255", "-32768 to 32767", "0 to 65535", 3);
        addQuestion(q3);
        Questions q4 = new Questions("which of the following array declaration statement is illegal?", "int [] a [] = new int [4][4];", "int a[][] = new int [4][4];", "int a[] [] = new int [] [4];", "int [] a [] = new int [4] [];", 3);
        addQuestion(q4);
        Questions q5 = new Questions("what will happen if you try to compile and run the following code ?\n" +
                "Public class test {\n" +
                "Public static void main(String[] argv ){\n" +
                "Int[] arr = new int[] {1,2,3};\n" +
                "System.out.println(arr[1]); }}\n", "1", "error: arr is referenced before it is initialized", "2", "error: size of array must be defined", 3);
        addQuestion(q5);
        Questions q6 = new Questions("in the given array declaration, which expression returns the output as 5?\n" +
                "Int [] arr = {23,5,78,34,2};\n", "arr.length()", "arr[].length()", "arr[].length", "arr.length", 4);
        addQuestion(q6);
        Questions q7 = new Questions("what will be the output upon the execution of the following code?\n" +
                "Public class test{\n" +
                "Public static void main (String[] argv ){\n" +
                "Int j = 5;\n" +
                "For(int i=0; i<j; i++){\n" +
                "If( I < j--)\n" +
                "System.out.print( (I * j));\n" +
                "}}}\n", "0   3   2", "1   2   3", "0   3   4", "1   4   2", 3);
        addQuestion(q7);
        Questions q8 = new Questions("which declaration of the main() method is valid?", "Public void main ( String args[] ){", "Public void static main ( String args[] ){", "final Public static void main ( String []args ){", "Public static void main ( String []args ){", 4);
        addQuestion(q8);
        Questions q9 = new Questions("which one of the following is invalid declarations of a char?", "char c1 = 064770;", "char c2 = ‘face’;", "char c3 = 0xbeef;", "char c6 = ‘#~%’;", 2);
        addQuestion(q9);
        Questions q10 = new Questions("which operator will always evaluate all the operands?", "||", "&&", "?:", "%", 4);
        addQuestion(q10);

        Questions q11 = new Questions("is 3 * 4 equivalent to 3<<2 ?", "YES", "NO", "N/A", "N/A", 1);
        addQuestion(q11);
        Questions q12 = new Questions("is it possible in java to create arrays of length zero ?", "YES", "NO", "N/A", "N/A", 1);
        addQuestion(q12);
        Questions q13 = new Questions("which of the following is not a valid declaration of a class?", "static public class test{}", "class $test{}", "static class test{}", "public abstract class_test{}", 1);
        addQuestion(q13);
        Questions q14 = new Questions("how can such a restriction be enforced?\n" +
                "A method within a class is only accessible by classes that are defined within the same package as the class of the method", "declare the method with the keyword public", "declare the method with keyword protected", "declare the method with keyword private", "without any accessibility specifiers", 4);
        addQuestion(q14);
        Questions q15 = new Questions("a special method that is used to initialize a class object?", "abstract method", "static method", "constructor", "overloaded method", 3);
        addQuestion(q15);
        Questions q16 = new Questions("two methods are said to be overloaded if they have?", "same name and same number of parameter but different return type.", "they have same name.", "they have different name but same number of argument.", "have same name but different parameters.", 4);
        addQuestion(q16);
        Questions q17 = new Questions("what will be the output of the program?\n" +
                "Class A{\n" +
                "Int x = 10;\n" +
                "Public void assign(int x){\n" +
                "x = x;\n" +
                "System.out.println(this.x);}\n" +
                "Public static void main ( String []args ){\n" +
                "New A().assign(100); }}\n", "10", "100", "0", "compile-time error", 1);
        addQuestion(q17);
        Questions q18 = new Questions("which statement does not create an object of class Student{} ?", "new Student();", "Student s1 = new Student(), s2 = new Student();", "Student s1;", "Student ss = new Student();", 3);
        addQuestion(q18);
        Questions q19 = new Questions("‘this’ keyword in java is used to ?", "refer to current class object.", "refer to static method of the class.", "refer to parent class object", "refer to static variable of the class", 1);
        addQuestion(q19);
        Questions q20 = new Questions("what is the prototype of the default constructor for given class?\n" +
                "Public class test{}\n", "test()", "public test()", "test(void)", "public test(void)", 2);
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
