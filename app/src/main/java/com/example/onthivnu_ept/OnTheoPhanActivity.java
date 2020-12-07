package com.example.onthivnu_ept;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OnTheoPhanActivity extends Activity
{
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter;
    QuestionListenAdapterP23 questionListenAdapterP23;
    QuestionListenAdapterP1 questionListenAdapterP1;
    Boolean is_not_done = true;
    MediaPlayer player;
    Integer n_right_answer = 0;
    Integer n_question = 0;
    Integer n_answer;
    Button btnNopBai;
    ImageView img;
    ArrayList<QuestionModel> questionModels;
    ArrayList<InforModel> inforModels = new ArrayList<>();
    Context context;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    String[] myList={"Phần nghe Part 1",
            "Phần nghe Part 2",
            "Phần nghe Part 3",
            "Phần nghe Part 4",
            "Phần đọc Part 1",
            "Phần đọc Part 2",
            "Phần đọc Part 3",
            "Phần đọc Part 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_theo_phan);
        context = getApplicationContext();
        myListView=(ListView) findViewById(R.id.list_item_otp);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 0:
                    {
                        n_question = 10;
                        questionModels = dataBaseHelper.findQuestionByPart(1, "Listening");

                        for (int i = 0; i < n_question; i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());

                            InforModel inforModel = new InforModel();
                            inforModel = dataBaseHelper.findInforById(questionModels.get(i).getIdInfor());
                            inforModels.add(inforModel);
                        }

                        setContentView(R.layout.on_theo_phan_layout_listenning_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart1);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai1);
//                        btnNopBai.setEnabled(false);
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP1 = new QuestionListenAdapterP1(context,R.layout.question_form_listening_p1,questionModels,inforModels);
                        myListQuestion.setAdapter(questionListenAdapterP1);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(questionListenAdapterP1.getPlayer() != null) questionListenAdapterP1.player.stop();
                                checkAnswers1();
                                ShowDialogResult();
                            }
                        });
                        myListQuestion.setOnItemClickListener(new AdapterView.OnItemClickListener()
                        {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
                            {

                            }
                        });

                        break;
                    }
                    case 1:
                    {
                        n_question = 6;
                        questionModels = dataBaseHelper.findQuestionByPart(2, "Listening");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p23);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart2);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai2);
//                        btnNopBai.setEnabled(false);
                        img = (ImageView) findViewById(R.id.image23);
                        img.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                context = getApplicationContext();
                                play(context, inforModels.get(0).getListeningInfor());
                            }
                        });
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });

                        break;
                    }
                    case 2:
                    {
                        n_question = 8;
                        questionModels = dataBaseHelper.findQuestionByPart(3, "Listening");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p23);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart2);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai2);
//                        btnNopBai.setEnabled(false);
                        img = (ImageView) findViewById(R.id.image23);
                        img.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                context = getApplicationContext();
                                play(context, inforModels.get(0).getListeningInfor());
                            }
                        });
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });

                        break;
                    }
                    case 3:
                    {
                        n_question = 8;
                        questionModels = dataBaseHelper.findQuestionByPart(4, "Listening");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p4);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart4);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai4);
//                        btnNopBai.setEnabled(false);

                        TextView txtP4 = (TextView) findViewById(R.id.txtP4);
                        txtP4.setText(inforModels.get(0).getReadingInfor());

                        img = (ImageView) findViewById(R.id.image4);
                        img.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                context = getApplicationContext();
                                play(context, inforModels.get(0).getListeningInfor());
                            }
                        });
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });
                        break;
                    }
                    case 4:
                    {
                        n_question = 20;
                        questionModels = dataBaseHelper.findQuestionByPart(11, "Reading");
                        ArrayList<QuestionModel> qm = dataBaseHelper.findQuestionByPart(12, "Reading");
                        questionModels.addAll(qm);

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);
//                        btnNopBai.setEnabled(false);

                        TextView txtP5 = (TextView) findViewById(R.id.txtP5);
                        txtP5.setText(inforModels.get(0).getReadingInfor());

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });
                        break;
                    }
                    case 5:
                    {
                        n_question = 6;
                        questionModels = dataBaseHelper.findQuestionByPart(2, "Reading");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);
//                        btnNopBai.setEnabled(false);

                        TextView txtP5 = (TextView) findViewById(R.id.txtP5);
                        txtP5.setText(inforModels.get(0).getReadingInfor());

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });
                        break;
                    }
                    case 6:
                    {
                        n_question = 7;
                        questionModels = dataBaseHelper.findQuestionByPart(3, "Reading");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);
//                        btnNopBai.setEnabled(false);

                        TextView txtP5 = (TextView) findViewById(R.id.txtP5);
                        txtP5.setText(inforModels.get(0).getReadingInfor());

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });
                        break;
                    }
                    case 7:
                    {
                        n_question = 6;
                        questionModels = dataBaseHelper.findQuestionByPart(4, "Reading");

                        for (int i = 0; i < questionModels.size(); i++)
                        {
                            Log.i("hihi", questionModels.get(i).toString());
                        }

                        InforModel inforModel = new InforModel(1,1,1,"");
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p4);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart8);
//                        btnNopBai.setEnabled(false);

                        TextView txtP8 = (TextView) findViewById(R.id.txtP8);
                        txtP8.setText(inforModels.get(0).getReadingInfor());
                        ImageView img8 = (ImageView) findViewById(R.id.image8);
                        img8.setBackgroundResource(inforModels.get(0).getListeningInfor());

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai8);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                checkAnswers2();
                                ShowDialogResult();
                            }
                        });
                        break;
                    }
                }

            }
        });
        context= getApplicationContext();
        myListAdapter = new ArrayAdapter(context,R.layout.my_simple_list_item_1,myList);
        myListView.setAdapter(myListAdapter);
    }
    void ShowDialogResult()
    {
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);

        myBuilder.setMessage("Bạn có "+n_right_answer.toString()+"/"+ n_question +" câu trả lời đúng")
                .setPositiveButton("Close", null)
                .show();
    }
    void checkAnswers1()
    {
        n_right_answer=0;
        n_answer = 0;

        for (int i = 0; i < n_question; i++)
        {
            String str1 = questionListenAdapterP1.finalResult(i);

            if (questionModels.get(i).getRightAnswer().equals(str1))
            {
                n_right_answer++;
                n_answer++;
            }
        }
    }
    void checkAnswers2()
    {

        n_right_answer=0;
        n_answer = 0;

        for (int i = 0; i < n_question; i++)
        {
            String str2 = questionListenAdapterP23.finalResult(i);

            if (questionModels.get(i).getRightAnswer().equals(str2))
            {
                n_right_answer++;
                n_answer++;
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

    @Override
    protected void onPause() {
        super.onPause();
        if (player!=null) player.stop();
    }
}