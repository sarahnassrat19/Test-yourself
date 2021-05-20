package com.example.testyourself;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testyourself.EnglishContract.*;

import java.util.ArrayList;
import java.util.List;

public class SoftskillsDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "MySoftTest.db";
    private static final int DATABASE_VERSION = 1;

    private SQLiteDatabase sql;

    public SoftskillsDatabase(Context context) {
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
        Questions q1 = new Questions("يمثل مربع الأزمات في مصفوفة ادارة الوقت:", "الأمور الهامة و العاجلة", "الأمور الهامة و الغير عاجلة", "الأمور الغير هامة و العاجلة", "الأمور الغير هامة و الغير عاجلة", 1);
        addQuestion(q1);
        Questions q2 = new Questions("اختر من الاتي العمليات الرئيسيه التي ترتكز عليها الاداره", "تحديد الاتجاه والرؤية", "التخطيط", "حشد القوى تحت هذه الرؤية", "التنظيم", 2);
        addQuestion(q2);
        Questions q3 = new Questions("اهم عوامل نجاح الاتصال اللفظى", "حركات اليدين", "المجاملات والتشجيع", "تغيرات الوجه", "كل ما سبق", 4);
        addQuestion(q3);
        Questions q4 = new Questions("من عوامل نجاح الاتصال الغير لفظى في الاتصال الشخصى:", "المجاملات", "اختيار الكلمات الواضحة", "تكرار المعلومات", "الابتسامة", 4);
        addQuestion(q4);
        Questions q5 = new Questions("تعتبر أهم مرحلة في حل المشكلات هى:", "تحديد بدائل الحلول", "تحديد طبيعة المشكلة", "متابعة تنفيذ حلول المشكلة", "تحديد أسباب المشكلة", 2);
        addQuestion(q5);
        Questions q6 = new Questions("يعرف الاتصال علي انه تبادل", "افكار", "معلومات", "مشاعر", "كل ما سبق", 4);
        addQuestion(q6);
        Questions q7 = new Questions("مؤلف كتاب العادات السبعة للناس الأكثر فعالية هو:", "جون كوفى", "ادوارد كوفى", "ستيفين كوفى", "جورج كوفى", 3);
        addQuestion(q7);
        Questions q8 = new Questions("اختر من الاتي العمليات الرئيسيه التي ترتكز عليها القياده", "تحديد الاتجاه والرؤية", "التخطيط", "حشد القوى تحت هذه الرؤية", "التنظيم", 2);
        addQuestion(q8);
        Questions q9 = new Questions("في التأثير على الأخرين لا يمثل الكلام اكثر من:", "7%", "8%", "9%", "10%", 1);
        addQuestion(q9);
        Questions q10 = new Questions("نموذج عظمة السمكة تم استخدامه للمرة الأولى بواسطة العالم اليابانى:", "ميشيكاوا", "ايشيكاوا", "سيشيكاوا", "تيشيكاوا", 2);
        addQuestion(q10);

        Questions q11 = new Questions("عدد الثوانى في اليوم الواحد:", "86400", "94600", "80640", "84060", 1);
        addQuestion(q11);
        Questions q12 = new Questions("أول مرحلة في بناء فريق العمل هى", "التكوين", "التصارع", "التوافق", "الأداء", 1);
        addQuestion(q12);
        Questions q13 = new Questions("يتراوح حجم فريق العمل المثالى بين:", "4 أفراد", "5 و 7 أفراد", "2 و 9 أفراد", "5 و 9 أفراد", 4);
        addQuestion(q13);
        Questions q14 = new Questions("انواع الرسائل", "مرئيه وغيرمرئيه", "لفظيه وغير لفظيه", "نصيه وغير نصيه", "لا شئ مما سبق", 2);
        addQuestion(q14);
        Questions q15 = new Questions("يحتوى تعريف القيادة على لفظ:", "التأثير", "الاتصال", "حل المشكلات", "ادارة الوقت", 1);
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
