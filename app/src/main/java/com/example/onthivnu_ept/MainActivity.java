package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener
{
    private Button btnExit,btnThiThu,btnThiNhanh,
            btnAboutUs,btnOnNgauNhien,btnOnTheoPhan;
    private Context context;
    private Bundle myBundle;
    private Intent myIntent;
    private DataBaseHelper dataBaseHelper;
    private List<QuestionModel> listQuestion;
    private List<InforModel> listReadingInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        setView();
        initDatabse();
    }
    public void setView()
    {
        btnExit = (Button) findViewById(R.id.btnExit);
        btnThiThu = (Button) findViewById(R.id.btnThiThu);
        btnThiNhanh = (Button) findViewById(R.id.btnThiNhanh);
        btnAboutUs  = (Button) findViewById(R.id.btnAboutUs);
        btnOnNgauNhien = (Button) findViewById(R.id.btnOnThiNgauNhien);
        btnOnTheoPhan = (Button) findViewById(R.id.btnOnThiTheoPhan);

        btnExit.setOnClickListener(this);
        btnThiNhanh.setOnClickListener( this);
        btnThiThu.setOnClickListener(this);
        btnOnNgauNhien.setOnClickListener(this);
        btnOnTheoPhan.setOnClickListener(this);
        btnAboutUs.setOnClickListener(this);

    }
    public void onClick(View view)
    {
        int id = view.getId();
        switch (id)
        {
            case R.id.btnExit:
                finish();
                break;
            case R.id.btnThiNhanh:
                //myIntent = new Intent(this,AboutUs_activity.class);
                //startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnAboutUs:
                myIntent = new Intent(this,AboutUs_activity.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnOnThiTheoPhan:
                myIntent = new Intent(this,OnTheoPhanActivity.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnOnThiNgauNhien:
                myIntent = new Intent(this,LuaChonCauHoi.class);
                startActivities(new Intent[]{myIntent});
                break;
            case R.id.btnThiThu:
                //myIntent = new Intent(this,AboutUs_activity.class);
                //startActivities(new Intent[]{myIntent});
                break;
        }
    }
    private void initDatabse(){
        dataBaseHelper = new DataBaseHelper(MainActivity.this);
        QuestionModel q1 = new QuestionModel("The topic of the radio program probably is _____.",
                "Never think about past mistakes",
                "How to be optimistic",
                "Be positive in failures",
                "Always use positive language",
                "B",
                "Listening",
                1,
                2);
        QuestionModel q2 = new QuestionModel("For Andy, _____ is very important",
                "living for today",
                "keeping past memories",
                "arranging for the future",
                "avoiding mistakes",
                "A",
                "Listening",
                1,
                2);
        QuestionModel q3 = new QuestionModel("Julie says people have negative thoughts _____. ",
                " if they fail in love",
                "every time they fail ",
                "now and then",
                "when they stop working",
                "C",
                "Listening",
                1,
                2);
        QuestionModel q4 = new QuestionModel("Julie probably tells herself “_____” if she learns to ride a bicycle.",
                "It will take me too much time.",
                "I’ll fail again.",
                "I’ll never try again if I fail now.",
                "I can ride it soon.",
                "D",
                "Listening",
                1,
                2);
        QuestionModel q5 = new QuestionModel("Miriam says that we should _____ to improve our bad feelings.  ",
                "do good things to other people",
                " list all the things for a good future",
                "keep a list of good memories at hand ",
                "try to have a good time every week",
                "C",
                "Listening",
                1,
                2);
        QuestionModel q6 = new QuestionModel("Michael doesn’t want to say “I’m sorry” because he thinks _____. ",
                "it’s not good to admit a mistake",
                "action is more important than words",
                "it’s better to say “I know my mistake” ",
                "positive language can encourage people better",
                "D",
                "Listening",
                1,
                2);
        dataBaseHelper.addQuestion(q1);
        dataBaseHelper.addQuestion(q2);
        dataBaseHelper.addQuestion(q3);
        dataBaseHelper.addQuestion(q4);
        dataBaseHelper.addQuestion(q5);
        dataBaseHelper.addQuestion(q6);
    }
}
