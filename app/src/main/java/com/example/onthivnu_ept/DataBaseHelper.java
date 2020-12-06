package com.example.onthivnu_ept;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public static final String COLUMN_IMG_INFOR = "ImageInfor";
    public static final String COLUMN_LISTENING_INFOR = "ListeningInfor";
    public static final String COLUMN_READING_INFOR = "ReadingInfor";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "vnuept_test.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try { //if database is not exists
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
                    + "FOREIGN KEY (" + COLUMN_ID_INFOR + ") REFERENCES " + TABLE_INFORMATION + " (" + COLUMN_ID + ")"
                    +")";
            String createTableInfor = "CREATE TABLE " + TABLE_INFORMATION + " ("
                    + COLUMN_ID + " INTEGER, "
                    + COLUMN_IMG_INFOR + " INTEGER, "
                    + COLUMN_LISTENING_INFOR + " INTEGER, "
                    + COLUMN_READING_INFOR + " TEXT)";
            db.execSQL(createTableQuestion);
            db.execSQL(createTableInfor);
        }
        catch(Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addQuestion(String question, String answerA, String answerB, String answerC, String answerD, String rightAnswer, String type, int idInfor, int part){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_QUESTION, question);
        cv.put(COLUMN_ANSWER_A, answerA);
        cv.put(COLUMN_ANSWER_B, answerB);
        cv.put(COLUMN_ANSWER_C, answerC);
        cv.put(COLUMN_ANSWER_D, answerD);
        cv.put(COLUMN_RIGHT_ANSWER, rightAnswer);
        cv.put(COLUMN_ID_INFOR, idInfor);
        cv.put(COLUMN_PART, part);
        cv.put(COLUMN_TYPE, type);

        long insert = db.insert(TABLE_QUESTION, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addInfor(int id, int imgInfor, int listeningInfor, String readingInfor){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ID, id);
        cv.put(COLUMN_IMG_INFOR, imgInfor);
        cv.put(COLUMN_LISTENING_INFOR, listeningInfor);
        cv.put(COLUMN_READING_INFOR, readingInfor);

        long insert = db.insert(TABLE_INFORMATION, null, cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public ArrayList<QuestionModel> findQuestionByPart(int myPart, String myType){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_QUESTION + " WHERE " + COLUMN_PART + " = " + Integer.toString(myPart)
                + " AND " + COLUMN_TYPE + " = '" + myType + "'";
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<QuestionModel> list = new ArrayList<>();

        int num = cursor.getCount();

        cursor.moveToFirst();
        for (int i = 0; i < num; i++){
            QuestionModel q = new QuestionModel();

            q.setQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION)));
            q.setAnswerA(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_A)));
            q.setAnswerB(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_B)));
            q.setAnswerC(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_C)));
            q.setAnswerD(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER_D)));
            q.setRightAnswer(cursor.getString(cursor.getColumnIndex(COLUMN_RIGHT_ANSWER)));
            q.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
            q.setIdInfor(cursor.getInt(cursor.getColumnIndex(COLUMN_ID_INFOR)));
            q.setPart(cursor.getInt(cursor.getColumnIndex(COLUMN_PART)));

            list.add(q);
            cursor.moveToNext();
        }

        return list;
    }

    public InforModel findInforById(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM "+ TABLE_INFORMATION + " WHERE " + COLUMN_ID + " = " + Integer.toString(id);
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        InforModel i = new InforModel();
        i.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
        i.setImgInfor(cursor.getInt(cursor.getColumnIndex(COLUMN_IMG_INFOR)));
        i.setListeningInfor(cursor.getInt(cursor.getColumnIndex(COLUMN_LISTENING_INFOR)));
        i.setReadingInfor(cursor.getString(cursor.getColumnIndex(COLUMN_READING_INFOR)));

        return i;
    }
}
