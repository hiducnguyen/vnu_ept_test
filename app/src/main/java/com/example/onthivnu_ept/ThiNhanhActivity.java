package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThiNhanhActivity extends Activity
{
    ArrayList<QuestionModel> questionModelsPart1,questionModelsPart2,
    questionModelsPart3,questionModelsPart4,
    questionModelsPart5,questionModelsPart6,
    questionModelsPart7,questionModelsPart8, questionModels;
    QuestionListenAdapterP1 adapterP1;
    ThiNhanhAdapter2 adapterP2,adapterP3,
            adapterP4,adapterP5,adapterP6,adapterP7,adapterP8;
    ThiNhanhAdapter adapter;
    Button btnPrevios1, btnNext1,btnPrevios2, btnNext2,btnPrevios3, btnNext3,btnPrevios4, btnNext4,
            btnPrevios5, btnNext5,btnPrevios6, btnNext6,btnPrevios7, btnNext7,btnPrevios8, btnNext8;
    TextView txtP4tn,txtP5tn,txtP6tn,txtP7tn,txtP8tn;
    public MediaPlayer player = null;
    ArrayList<InforModel> inforModelsPart1 = new ArrayList<>(),inforModelsPart2 = new ArrayList<>(),
    inforModelsPart3 = new ArrayList<>(),inforModelsPart4 = new ArrayList<>(),
    inforModelsPart5 = new ArrayList<>(),inforModelsPart6 = new ArrayList<>(),
    inforModelsPart7 = new ArrayList<>(),inforModelsPart8 = new ArrayList<>();

    Context context;
    ListView myListQuestionPart1,myListQuestionPart2,
            myListQuestionPart3,myListQuestionPart4,
            myListQuestionPart5,myListQuestionPart6,
            myListQuestionPart7,myListQuestionPart8;
    ImageView imgPart2,imgPart3,imgPart4;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        doPart1();
    }
    void doPart1()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p1);
        questionModelsPart1 = dataBaseHelper.findQuestionByPart(1, "Listening");
        myListQuestionPart1= (ListView) findViewById(R.id.myListQuestionPart1tn);
        btnNext1 = (Button) findViewById(R.id.btnNext1);
        btnPrevios1 = (Button) findViewById(R.id.btnPrevios1);
        btnPrevios1.setEnabled(false);
        btnNext1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                player = adapter.getPlayer();
                doPart2();
            }
        });

        for (int i = 0; i < 10; i++)
        {
            InforModel inforModel = new InforModel();
            inforModel = dataBaseHelper.findInforById(questionModelsPart1.get(i).getIdInfor());
            inforModelsPart1.add(inforModel);
        }
        if (adapter==null) adapter = new ThiNhanhAdapter(this,R.layout.question_form_listening_p1,questionModelsPart1,inforModelsPart1);
        context = ThiNhanhActivity.this;
        myListQuestionPart1.setAdapter(adapter);

    }
    void doPart2()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p2);
        questionModelsPart2 = dataBaseHelper.findQuestionByPart(2, "Listening");

        myListQuestionPart2= (ListView) findViewById(R.id.myListQuestionPart2tn);
        btnNext2 = (Button) findViewById(R.id.btnNext2);
        btnPrevios2 = (Button) findViewById(R.id.btnPrevios2);
        imgPart2 = (ImageView) findViewById(R.id.image2tn);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart2.get(0).getIdInfor());
        inforModelsPart2.add(inforModel);
        context = ThiNhanhActivity.this;
        if (adapterP2==null) adapterP2 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart2);
        myListQuestionPart2.setAdapter(adapterP2);
        imgPart2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,inforModelsPart2.get(0).getListeningInfor());
            }
        });
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart3();
            }
        });
        btnPrevios2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart1();
            }
        });
    }
    void doPart3()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p3);
        questionModelsPart3 = dataBaseHelper.findQuestionByPart(3, "Listening");

        myListQuestionPart3= (ListView) findViewById(R.id.myListQuestionPart3tn);
        btnNext3 = (Button) findViewById(R.id.btnNext3);
        btnPrevios3 = (Button) findViewById(R.id.btnPrevios3);
        imgPart3 = (ImageView) findViewById(R.id.image3tn);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart3.get(0).getIdInfor());
        inforModelsPart3.add(inforModel);

        context = ThiNhanhActivity.this;
        if (adapterP3==null) adapterP3 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart3);
        myListQuestionPart3.setAdapter(adapterP3);
        imgPart3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,inforModelsPart3.get(0).getListeningInfor());
            }
        });
        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart4();
            }
        });
        btnPrevios3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart2();
            }
        });
    }
    void doPart4()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p4);
        questionModelsPart4 = dataBaseHelper.findQuestionByPart(4, "Listening");

        myListQuestionPart4= (ListView) findViewById(R.id.myListQuestionPart4tn);
        btnNext4 = (Button) findViewById(R.id.btnNext4);
        btnPrevios4 = (Button) findViewById(R.id.btnPrevios4);
        imgPart4 = (ImageView) findViewById(R.id.image4tn);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart4.get(0).getIdInfor());
        inforModelsPart4.add(inforModel);
        txtP4tn = (TextView) findViewById(R.id.txtP4tn);
        txtP4tn.setText(inforModelsPart4.get(0).getReadingInfor());

        context = ThiNhanhActivity.this;
        if (adapterP4==null) adapterP4 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart4);
        myListQuestionPart4.setAdapter(adapterP4);
        imgPart4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,inforModelsPart4.get(0).getListeningInfor());
            }
        });
        btnNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart5();
            }
        });
        btnPrevios4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart3();
            }
        });
    }
    void doPart5()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p5);
        questionModelsPart5 = dataBaseHelper.findQuestionByPart(11, "Reading");
        questionModels = dataBaseHelper.findQuestionByPart(12, "Reading");
        questionModelsPart5.addAll(questionModels);

        myListQuestionPart5= (ListView) findViewById(R.id.myListQuestionPart5tn);
        btnNext5 = (Button) findViewById(R.id.btnNext5);
        btnPrevios5 = (Button) findViewById(R.id.btnPrevios5);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart5.get(0).getIdInfor());
        inforModelsPart5.add(inforModel);
        txtP5tn = (TextView) findViewById(R.id.txtP5tn);
        txtP5tn.setText(inforModelsPart5.get(0).getReadingInfor());

        context = ThiNhanhActivity.this;
        if (adapterP5==null) adapterP5 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart5);
        myListQuestionPart5.setAdapter(adapterP5);
        btnNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart6();
            }
        });
        btnPrevios5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart4();
            }
        });
    }
    void doPart6()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p6);
        questionModelsPart6 = dataBaseHelper.findQuestionByPart(2, "Reading");

        myListQuestionPart6= (ListView) findViewById(R.id.myListQuestionPart6tn);
        btnNext6 = (Button) findViewById(R.id.btnNext6);
        btnPrevios6 = (Button) findViewById(R.id.btnPrevios6);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart6.get(0).getIdInfor());
        inforModelsPart6.add(inforModel);
        txtP6tn = (TextView) findViewById(R.id.txtP6tn);
        txtP6tn.setText(inforModelsPart6.get(0).getReadingInfor());

        context = ThiNhanhActivity.this;
        if (adapterP6==null) adapterP6 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart6);
        myListQuestionPart6.setAdapter(adapterP6);

        btnNext6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart7();
            }
        });
        btnPrevios6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart5();
            }
        });
    }
    void doPart7()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p7);
        questionModelsPart7 = dataBaseHelper.findQuestionByPart(3, "Reading");

        myListQuestionPart7= (ListView) findViewById(R.id.myListQuestionPart7tn);
        btnNext7 = (Button) findViewById(R.id.btnNext7);
        btnPrevios7 = (Button) findViewById(R.id.btnPrevios7);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart7.get(0).getIdInfor());
        inforModelsPart7.add(inforModel);

        context = ThiNhanhActivity.this;
        if (adapterP7==null) adapterP7 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart7);
        myListQuestionPart7.setAdapter(adapterP7);
        txtP7tn = (TextView) findViewById(R.id.txtP7tn);
        txtP7tn.setText(inforModelsPart7.get(0).getReadingInfor());

        btnNext7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart8();
            }
        });
        btnPrevios7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart6();
            }
        });
    }
    void doPart8()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.activity_thi_nhanh_p8);
        questionModelsPart8 = dataBaseHelper.findQuestionByPart(4, "Reading");

        myListQuestionPart8= (ListView) findViewById(R.id.myListQuestionPart8tn);
        btnNext8 = (Button) findViewById(R.id.btnNext8);
        btnPrevios8 = (Button) findViewById(R.id.btnPrevios8);

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart8.get(0).getIdInfor());
        inforModelsPart8.add(inforModel);
        txtP8tn = (TextView) findViewById(R.id.txtP8tn);
        txtP8tn.setText(inforModelsPart8.get(0).getReadingInfor());

        context = ThiNhanhActivity.this;
        if (adapterP8==null) adapterP8 = new ThiNhanhAdapter2(this,R.layout.question_form_02,questionModelsPart8);
        myListQuestionPart8.setAdapter(adapterP8);
        btnNext8.setEnabled(false);
        btnPrevios8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart7();
            }
        });
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

    @Override
    protected void onPause() {
        super.onPause();
        if (player!=null) player.stop();
    }
}