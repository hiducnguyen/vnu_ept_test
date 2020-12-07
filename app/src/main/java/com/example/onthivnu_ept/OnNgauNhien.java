package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class OnNgauNhien extends Activity {
    ImageView img;
    MediaPlayer player;


    ListView listListeningPart1, listListeningPart2, listListeningPart3, listListeningPart4,
            listReadingPart1, listReadingPart2;

    private int countListeningPart1;
    private int countListeningPart2;
    private int countListeningPart3;
    private int countListeningPart4;
    private int countReadingPart1;
    private int countReadingPart2;

    ArrayList<QuestionModel>arrayListListeningPart1;
    ArrayList<InforModel>arrayListListeningPart2=new ArrayList<>();
    ArrayList<InforModel>arrayListListeningPart3=new ArrayList<>();
    ArrayList<InforModel>arrayListListeningPart4=new ArrayList<>();
    ArrayList<InforModel>arrayListReadingPart1=new ArrayList<>();
    ArrayList<InforModel>arrayListReadingPart2=new ArrayList<>();

    ArrayList<InforModel>arrayListListeningPart1Info=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart2Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart3Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart4Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart1Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart2Question=new ArrayList<>();

    ArrayList<QuestionModel>arrayResultListListeningPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart2=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart3=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart4=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart2=new ArrayList<>();

    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
    QuestionListenAdapterP1 questionListenAdapterP1;
    Context context;

    Button btnKT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_ngau_nhien);
        setWidget();

        Intent myInten=getIntent();
        Bundle myBundle=myInten.getExtras();

        countListeningPart1=myBundle.getInt("countListeningPart1");
        countListeningPart2=myBundle.getInt("countListeningPart2");
        countListeningPart3=myBundle.getInt("countListeningPart3");
        countListeningPart4=myBundle.getInt("countListeningPart4");
        countReadingPart1=myBundle.getInt("countReadingPart1");
        countReadingPart2=myBundle.getInt("countReadingPart2");


        handlingDataOfListeningPart1();

        randomQuestion();
        context=OnNgauNhien.this;

        questionListenAdapterP1 = new QuestionListenAdapterP1(context,R.layout.question_form_listening_p1,arrayResultListListeningPart1,arrayListListeningPart1Info);
        listReadingPart1.setAdapter(questionListenAdapterP1);
        listReadingPart1.setFocusable(false);

        listReadingPart1.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {
            }
        });


    }
    private void setWidget()
    {
        btnKT=(Button)findViewById(R.id.btnKT);
        listListeningPart1=(ListView)findViewById(R.id.lListeningPart1);
        listListeningPart2=(ListView)findViewById(R.id.lListeningPart2);
        listListeningPart3=(ListView)findViewById(R.id.lListeningPart3);
        listListeningPart4=(ListView)findViewById(R.id.lListeningPart4);
        listReadingPart1=(ListView)findViewById(R.id.lReadingPart1);
        listReadingPart2=(ListView)findViewById(R.id.lReadingPart2);

    }

    private void handlingDataOfListeningPart1()
    {
        arrayListListeningPart1=new ArrayList<>(dataBaseHelper.findQuestionByPart(1,"Listening"));
    }
    private void handlingDataOfListeningPart2()
    {
        arrayListListeningPart2Question=new ArrayList<>(dataBaseHelper.)
    }


    private void randomQuestion()
    {
        Random rand=new Random();

        for (int i = 0; i < countListeningPart1; i++) {
            int randomIndex = rand.nextInt(arrayListListeningPart1.size());
            QuestionModel ques  = arrayListListeningPart1.get(randomIndex);
            arrayResultListListeningPart1.add(ques);
            arrayListListeningPart1Info.add(dataBaseHelper.findInforById(ques.getIdInfor()));
            arrayListListeningPart1.remove(randomIndex);
        }

        for (int i = 0; i < countListeningPart2; i++) {
            int randomIndex = rand.nextInt(arrayListListeningPart2.size());
            InforModel im  = arrayListListeningPart2.get(randomIndex);
            arrayResultListListeningPart2.add(im);
            arrayListListeningPart2.remove(randomIndex);
        }

        for (int i = 0; i < countListeningPart3; i++) {
            int randomIndex = rand.nextInt(arrayListListeningPart3.size());
            InforModel im  = arrayListListeningPart3.get(randomIndex);
            arrayResultListListeningPart3.add(im);
            arrayListListeningPart3.remove(randomIndex);
        }

        for (int i = 0; i < countListeningPart4; i++) {
            int randomIndex = rand.nextInt(arrayListListeningPart4.size());
            InforModel im  = arrayListListeningPart4.get(randomIndex);
            arrayResultListListeningPart4.add(im);
            arrayListListeningPart4.remove(randomIndex);
        }

        for (int i = 0; i < countReadingPart1; i++) {
            int randomIndex = rand.nextInt(arrayListReadingPart1.size());
            InforModel im  = arrayListReadingPart1.get(randomIndex);
            arrayResultListReadingPart1.add(im);
            arrayListReadingPart1.remove(randomIndex);
        }

        for (int i = 0; i < countReadingPart2; i++) {
            int randomIndex = rand.nextInt(arrayListReadingPart2.size());
            InforModel im  = arrayListReadingPart2.get(randomIndex);
            arrayResultListReadingPart2.add(im);
            arrayListReadingPart2.remove(randomIndex);
        }
    }





}