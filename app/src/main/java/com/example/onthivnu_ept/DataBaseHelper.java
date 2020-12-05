package com.example.onthivnu_ept;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_QUESTION = "QUESTION";
    public static final String COLUMN_QUESTION = "Question";
    public static final String COLUMN_ANSWER_A = "AnswerA";
    public static final String COLUMN_ANSWER_B = "AnswerB";
    public static final String COLUMN_ANSWER_C = "AnswerC";
    public static final String COLUMN_ANSWER_D = "AnswerD";
    public static final String COLUMN_RIGHT_ANSWER = "RightAnswer";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ID_INFOR = COLUMN_ID + "_infor";
    public static final String COLUMN_PART = "Part";
    public static final String TABLE_INFORMATION = "INFORMATION";
    public static final String COLUMN_INFOR = "Infor";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "vnuept_test.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuestion = "CREATE TABLE " + TABLE_QUESTION + " ("
                + COLUMN_QUESTION + " TEXT, "
                + COLUMN_ANSWER_A + " TEXT, "
                + COLUMN_ANSWER_B + " TEXT, "
                + COLUMN_ANSWER_C + " TEXT, "
                + COLUMN_ANSWER_D + " TEXT, "
                + COLUMN_RIGHT_ANSWER + " TEXT, "
                + COLUMN_TYPE + " TEXT, "
                + COLUMN_ID_INFOR + " INTEGER, "
                + COLUMN_PART + " INTEGER, "
                + "FOREIGN KEY (" + COLUMN_ID_INFOR + ") REFERENCES INFOR (" + COLUMN_ID + ")"
                +")";
        String createTableInfor = "CREATE TABLE " + TABLE_INFORMATION + " ("
                + COLUMN_ID + " INTEGER, "
                + COLUMN_INFOR + " TEXT, "
                + COLUMN_TYPE + " TEXT)";
        db.execSQL(createTableQuestion);
        db.execSQL(createTableInfor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addQuestion(QuestionModel questionModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_QUESTION, questionModel.getQuestion());
        cv.put(COLUMN_ANSWER_A, questionModel.getAnswerA());
        cv.put(COLUMN_ANSWER_B, questionModel.getAnswerB());
        cv.put(COLUMN_ANSWER_C, questionModel.getAnswerC());
        cv.put(COLUMN_ANSWER_D, questionModel.getAnswerD());
        cv.put(COLUMN_RIGHT_ANSWER, questionModel.getRightAnswer());
        cv.put(COLUMN_ID_INFOR, questionModel.getIdInfor());
        cv.put(COLUMN_PART, questionModel.getPart());
        cv.put(COLUMN_TYPE, questionModel.getType());

        long insert = db.insert(TABLE_QUESTION, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
}
