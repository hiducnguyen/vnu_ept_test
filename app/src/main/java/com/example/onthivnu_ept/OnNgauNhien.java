package com.example.onthivnu_ept;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
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
    Button btnNext1,btnPrevious1;


    private int countListeningPart1;
    private int countListeningPart2;
    private int countListeningPart3;
    private int countListeningPart4;
    private int countReadingPart1;
    private int countReadingPart2;
    private int countReadingPart3;
    private int countReadingPart4;

    ArrayList<QuestionModel>arrayListListeningPart1;
    ArrayList<InforModel>arrayListListeningPart2;
    ArrayList<InforModel>arrayListListeningPart3;
    ArrayList<InforModel>arrayListListeningPart4;
    ArrayList<InforModel>arrayListReadingPart1;
    ArrayList<InforModel>arrayListReadingPart2;
    ArrayList<InforModel>arrayListReadingPart3;
    ArrayList<InforModel>arrayListReadingPart4;

    ArrayList<InforModel>arrayListListeningPart1Info=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart2Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart3Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart4Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart1Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart2Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart3Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart4Question=new ArrayList<>();

    ArrayList<QuestionModel>arrayResultListListeningPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart2=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart3=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart4=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart2=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart3=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart4=new ArrayList<>();

    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
    QuestionListenAdapterP1 questionListenAdapterP1;
    QuestionListenAdapterP23 questionListenAdapterP23;
    OnNgauNhienAdapter adapterListeningP2;

    Context context;

    Button btnKT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myInten=getIntent();
        Bundle myBundle=myInten.getExtras();

        countListeningPart1=myBundle.getInt("countListeningPart1");
        countListeningPart2=myBundle.getInt("countListeningPart2");
        countListeningPart3=myBundle.getInt("countListeningPart3");
        countListeningPart4=myBundle.getInt("countListeningPart4");
        countReadingPart1=myBundle.getInt("countReadingPart1");
        countReadingPart2=myBundle.getInt("countReadingPart2");
        countReadingPart3=myBundle.getInt("countReadingPart3");
        countReadingPart4=myBundle.getInt("countReadingPart4");

        initDataOfLists();
        randomQuestion();
        if(countListeningPart1>0)
            doPart1();
        else if(countListeningPart2>0)
            doPart2();
        else if(countListeningPart3>0)
        {
            //doPart3();
        }
        else if(countListeningPart4>0)
        {
            //doPart4();
        }
        else if(countReadingPart1>0)
        {
            //doPart5();
        }
        else if (countReadingPart2>0)
        {
            //doPart6();
        }
        else if(countReadingPart3>0)
        {
            //doPart7();
        }
        else if(countReadingPart4>0)
        {
            //doPart8();
        }

    }

    private void doPart1() {
        setContentView(R.layout.on_ngau_nhien_layout_listening_p1);
        listReadingPart1 = (ListView) findViewById(R.id.myListQuestionPart1tn);

        btnNext1 = (Button) findViewById(R.id.btnNext1);
        btnPrevious1 = (Button) findViewById(R.id.btnPrevios1);

        questionListenAdapterP1 = new QuestionListenAdapterP1(this, R.layout.question_form_listening_p1, arrayResultListListeningPart1, arrayListListeningPart1Info);
        listReadingPart1.setAdapter(questionListenAdapterP1);
        listReadingPart1.setFocusable(false);

        listReadingPart1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

            }
        });
        btnPrevious1.setEnabled(false);
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart2();
            }
        });
    }
    private void doPart2()
    {
        setContentView(R.layout.on_ngau_nhien_layout_listening_p2);

        btnNext1 = (Button) findViewById(R.id.btnNext2);
        btnPrevious1 = (Button) findViewById(R.id.btnPrevios2);
        img = (ImageView) findViewById(R.id.image2tn);
        listListeningPart2=(ListView) findViewById(R.id.myListQuestionPart2tn);

        context = OnNgauNhien.this;
        adapterListeningP2 = new OnNgauNhienAdapter(this,R.layout.question_form_02,arrayListListeningPart2Question);
        listListeningPart2.setAdapter(adapterListeningP2);
        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,arrayResultListListeningPart2.get(0).getListeningInfor());
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart3();
            }
        });
        btnPrevious1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart1();
            }
        });
    }

    private void doPart3()
    {
        setContentView(R.layout.on_ngau_nhien_layout_listening_p2);

        btnNext1 = (Button) findViewById(R.id.btnNext2);
        btnPrevious1 = (Button) findViewById(R.id.btnPrevios2);
        img = (ImageView) findViewById(R.id.image2tn);
        listListeningPart2=(ListView) findViewById(R.id.myListQuestionPart2tn);

        context = OnNgauNhien.this;
        adapterListeningP2 = new OnNgauNhienAdapter(this,R.layout.question_form_02,arrayListListeningPart3Question);
        listListeningPart2.setAdapter(adapterListeningP2);
        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,arrayResultListListeningPart3.get(0).getListeningInfor());
            }
        });
        btnNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //doPart4();
            }
        });
        btnPrevious1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart2();
            }
        });
    }




    private void initDataOfLists()
    {
        arrayListListeningPart1=new ArrayList<>(dataBaseHelper.findQuestionByPart(1,"Listening"));
        arrayListListeningPart2=new ArrayList<>(dataBaseHelper.findInforByPart(2,"Listening"));
        arrayListListeningPart3=new ArrayList<>(dataBaseHelper.findInforByPart(3,"Listening"));
        arrayListListeningPart4=new ArrayList<>(dataBaseHelper.findInforByPart(4,"Listening"));

        arrayListReadingPart1=new ArrayList<>();

        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(11,"Reading"));
        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(12,"Reading"));
        arrayListReadingPart2=new ArrayList<>(dataBaseHelper.findInforByPart(2,"Reading"));
        arrayListReadingPart3=new ArrayList<>(dataBaseHelper.findInforByPart(3,"Reading"));
        arrayListReadingPart4=new ArrayList<>(dataBaseHelper.findInforByPart(4,"Reading"));


    }


    private void randomQuestion()
    {
        Random rand=new Random();
        InforModel im;
        int randomIdx;

        for (int i = 0; i < countListeningPart1; i++) {
            int randomIndex = rand.nextInt(arrayListListeningPart1.size());
            QuestionModel ques  = arrayListListeningPart1.get(randomIndex);
            arrayResultListListeningPart1.add(ques);
            arrayListListeningPart1Info.add(dataBaseHelper.findInforById(ques.getIdInfor()));
            arrayListListeningPart1.remove(randomIndex);
        }

        //
        if(countListeningPart2>0) {
            randomIdx = rand.nextInt(arrayListListeningPart2.size());
            im = arrayListListeningPart2.get(randomIdx);
            arrayResultListListeningPart2.add(im);
            arrayListListeningPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart2Question.size() - countListeningPart2; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart2Question.size());
                arrayListListeningPart2Question.remove(randomIndex);

            }
        }
        //
        if(countListeningPart3>0) {

            randomIdx = rand.nextInt(arrayListListeningPart3.size());
            im = arrayListListeningPart3.get(randomIdx);
            arrayResultListListeningPart3.add(im);
            arrayListListeningPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart3Question.size() - countListeningPart3; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart3Question.size());
                arrayListListeningPart3Question.remove(randomIndex);

            }
        }
        if(countListeningPart4>0) {

            randomIdx = rand.nextInt(arrayListListeningPart4.size());
            im = arrayListListeningPart4.get(randomIdx);
            arrayResultListListeningPart4.add(im);
            arrayListListeningPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart4Question.size() - countListeningPart4; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart4Question.size());
                arrayListListeningPart4Question.remove(randomIndex);

            }
        }

        if(countReadingPart1>0) {

            randomIdx = rand.nextInt(arrayListReadingPart1.size());
            im = arrayListReadingPart1.get(randomIdx);
            arrayResultListReadingPart1.add(im);
            arrayListReadingPart1Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart1Question.size() - countReadingPart1; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart1Question.size());
                arrayListReadingPart1Question.remove(randomIndex);

            }
        }
        if(countReadingPart2>0) {

            randomIdx = rand.nextInt(arrayListReadingPart2.size());
            im = arrayListReadingPart2.get(randomIdx);
            arrayResultListReadingPart2.add(im);
            arrayListReadingPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart2Question.size() - countReadingPart2; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart2Question.size());
                arrayListReadingPart2Question.remove(randomIndex);

            }
        }

        if(countReadingPart3>0) {
            randomIdx = rand.nextInt(arrayListReadingPart3.size());
            im = arrayListReadingPart3.get(randomIdx);
            arrayResultListReadingPart3.add(im);
            arrayListReadingPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart3Question.size() - countReadingPart3; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart3Question.size());
                arrayListReadingPart3Question.remove(randomIndex);

            }
        }
        if(countReadingPart4>0) {

            randomIdx = rand.nextInt(arrayListReadingPart4.size());
            im = arrayListReadingPart4.get(randomIdx);
            arrayResultListReadingPart4.add(im);
            arrayListReadingPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart4Question.size() - countReadingPart4; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart4Question.size());
                arrayListReadingPart4Question.remove(randomIndex);

            }
        }
    }
    void play(Context context, int resource)
    {

        if (player != null)
        {
            player.release();
            player = null;
        }
        player = MediaPlayer.create(context, resource);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                player.release();
                player=null;
            }
        });
    }


}