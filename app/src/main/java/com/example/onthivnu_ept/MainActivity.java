package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {
    private Button btnExit, btnThiThu, btnThiNhanh,
            btnAboutUs, btnOnNgauNhien, btnOnTheoPhan;
    private Context context;
    private Bundle myBundle;
    private Intent myIntent;
    public DataBaseHelper dataBaseHelper;
    private SQLiteDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        if (!validDataBase()) {
            InitiateDataBase initDB = new InitiateDataBase();
            initDB.start(dataBaseHelper);
        }
        setView();
    }

    public boolean validDataBase() {
        dataBaseHelper = new DataBaseHelper(MainActivity.this);
        try {
            dataBase = dataBaseHelper.getReadableDatabase();
            Cursor cursor = dataBase.rawQuery("SELECT * FROM QUESTION", null);
            if (cursor.moveToFirst()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public void setView() {
        btnExit = (Button) findViewById(R.id.btnExit);
        btnThiThu = (Button) findViewById(R.id.btnThiThu);
        btnThiNhanh = (Button) findViewById(R.id.btnThiNhanh);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnOnNgauNhien = (Button) findViewById(R.id.btnOnThiNgauNhien);
        btnOnTheoPhan = (Button) findViewById(R.id.btnOnThiTheoPhan);

        btnExit.setOnClickListener(this);
        btnThiNhanh.setOnClickListener(this);
        btnThiThu.setOnClickListener(this);
        btnOnNgauNhien.setOnClickListener(this);
        btnOnTheoPhan.setOnClickListener(this);
        btnAboutUs.setOnClickListener(this);

    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnExit:
                finish();
                break;
            case R.id.btnThiNhanh:
                myIntent = new Intent(this, ThiNhanhActivity.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnAboutUs:
                myIntent = new Intent(this, AboutUs_activity.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnOnThiTheoPhan:
                myIntent = new Intent(this, OnTheoPhanActivity.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnOnThiNgauNhien:
                myIntent = new Intent(this, LuaChonCauHoi.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnThiThu:
                //myIntent = new Intent(this,AboutUs_activity.class);
                //startActivities(new Intent[]{myIntent});
                break;
        }
    }
}
