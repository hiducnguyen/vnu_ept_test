package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ThiNhanhActivity extends Activity
{
    ArrayList<QuestionModel> questionModelsPart1,questionModelsPart2,
    questionModelsPart3,questionModelsPart4,
    questionModelsPart5,questionModelsPart6,
    questionModelsPart7,questionModelsPart8, questionModels;
    QuestionListenAdapterP1 adapterP1,adapterP2,adapterP3,
            adapterP4,adapterP5,adapterP6,adapterP7,adapterP8;
    MediaPlayer player;
    ArrayList<InforModel> inforModelsPart1 = new ArrayList<>(),inforModelsPart2 = new ArrayList<>(),
    inforModelsPart3 = new ArrayList<>(),inforModelsPart4 = new ArrayList<>(),
    inforModelsPart5 = new ArrayList<>(),inforModelsPart6 = new ArrayList<>(),
    inforModelsPart7 = new ArrayList<>(),inforModelsPart8 = new ArrayList<>();
    Integer n_right_answer = 0;
    Integer n_answer;
    Context context;
    ListView myListQuestionPart1,myListQuestionPart2,
            myListQuestionPart3,myListQuestionPart4,
            myListQuestionPart5,myListQuestionPart6,
            myListQuestionPart7,myListQuestionPart8;
    ImageView imgPart1,imgPart2,imgPart3,imgPart4;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_nhanh);
        setView();

        questionModelsPart1 = dataBaseHelper.findQuestionByPart(1, "Listening");
        questionModelsPart2 = dataBaseHelper.findQuestionByPart(2, "Listening");
        questionModelsPart3 = dataBaseHelper.findQuestionByPart(3, "Listening");
        questionModelsPart4 = dataBaseHelper.findQuestionByPart(4, "Listening");
        questionModelsPart5 = dataBaseHelper.findQuestionByPart(11, "Listening");
        questionModels = dataBaseHelper.findQuestionByPart(12, "Listening");
        questionModelsPart5.addAll(questionModels);
        questionModelsPart6 = dataBaseHelper.findQuestionByPart(2, "Listening");
        questionModelsPart7 = dataBaseHelper.findQuestionByPart(3, "Listening");
        questionModelsPart8 = dataBaseHelper.findQuestionByPart(4, "Listening");


        for (int i = 0; i < 10; i++)
        {
            Log.i("hihi", questionModelsPart1.get(i).toString());

            InforModel inforModel = new InforModel();
            inforModel = dataBaseHelper.findInforById(questionModelsPart1.get(i).getIdInfor());
            inforModelsPart1.add(inforModel);
        }


        adapterP1 = new QuestionListenAdapterP1(this,R.layout.question_form_listening_p1,questionModelsPart1);
        myListQuestionPart1.setAdapter(adapterP1);

//        myListQuestionPart1.setOnItemClickListener(new AdapterView.OnItemClickListener()
//        {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
//            {
//                imgPart1 = (ImageView) view.findViewById(R.id.image);
//                imgPart1.setOnClickListener(new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View v)
//                    {
//                        context = getApplicationContext();
//                        player = MediaPlayer.create(context,inforModelsPart1.get(position).getListeningInfor());
//                        player.start();
//                    }
//                });
//            }
//        });

        for (int i = 0; i < questionModelsPart2.size(); i++)
        {
            Log.i("hihi", questionModelsPart2.get(i).toString());
        }

        InforModel inforModel = new InforModel();
        inforModel = dataBaseHelper.findInforById(questionModelsPart2.get(0).getIdInfor());
        inforModelsPart2.add(inforModel);


        imgPart2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                context = getApplicationContext();
                play(context, inforModelsPart2.get(0).getListeningInfor());
            }
        });
        context = ThiNhanhActivity.this;
        adapterP2 = new QuestionListenAdapterP1(context,R.layout.question_form_02,questionModelsPart2);
        myListQuestionPart2.setAdapter(adapterP2);


    }
    void setView()
    {
        myListQuestionPart1= (ListView) findViewById(R.id.myListQuestionPart1tn);
        myListQuestionPart2= (ListView) findViewById(R.id.myListQuestionPart2tn);
        myListQuestionPart3= (ListView) findViewById(R.id.myListQuestionPart3tn);
        myListQuestionPart4= (ListView) findViewById(R.id.myListQuestionPart4tn);
        myListQuestionPart5= (ListView) findViewById(R.id.myListQuestionPart5tn);
        myListQuestionPart6= (ListView) findViewById(R.id.myListQuestionPart6tn);
        myListQuestionPart7= (ListView) findViewById(R.id.myListQuestionPart7tn);
        myListQuestionPart8= (ListView) findViewById(R.id.myListQuestionPart8tn);

        imgPart2 = (ImageView) findViewById(R.id.imagePart2);
        imgPart3 = (ImageView) findViewById(R.id.imagePart3);
        imgPart4 = (ImageView) findViewById(R.id.imagePart4);
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