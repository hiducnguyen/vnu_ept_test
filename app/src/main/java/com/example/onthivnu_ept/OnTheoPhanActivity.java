package com.example.onthivnu_ept;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;

public class OnTheoPhanActivity extends Activity
{
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter;
    QuestionListenAdapterP23 questionListenAdapterP23;
    QuestionListenAdapterP1 questionListenAdapterP1;
    MediaPlayer player;
    Integer n_right_answer = 0;
    Integer n_question = 0;
    int trueColor =R.color.colorRed;
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
                        questionModels = dataBaseHelper.findQuestionByPart(1, "Listening");
                        for (int i = 0; i < n_question; i++)
                        {
                            InforModel inforModel = new InforModel();
                            inforModel = dataBaseHelper.findInforById(questionModels.get(i).getIdInfor());
                            inforModels.add(inforModel);
                        }

                        setContentView(R.layout.on_theo_phan_layout_listenning_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart1);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai1);
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP1 = new QuestionListenAdapterP1(context,R.layout.question_form_listening_p1,questionModels,inforModels);
                        myListQuestion.setAdapter(questionListenAdapterP1);

                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(questionListenAdapterP1.getPlayer() != null) questionListenAdapterP1.player.stop();
                                if (questionListenAdapterP1.is_filled()){
                                    checkAnswers1();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });

                        break;
                    }
                    case 1:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(2, "Listening");
                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p23);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart2);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai2);
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
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });


                        break;
                    }
                    case 2:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(3, "Listening");
                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p23);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart2);
                        TextView textView = (TextView) findViewById(R.id.txtDirectionPart23);
                        textView.setText(R.string.in_part_3_you_will_hear_a_talk_after_the_second_listening_there_are_eight_questions_select_the_best_answer_to_each_question);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai2);
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
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();

                            }
                        });

                        break;
                    }
                    case 3:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(4, "Listening");
                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_listenning_p4);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart4);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai4);

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
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    }
                    case 4:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(11, "Reading");
                        ArrayList<QuestionModel> qm = dataBaseHelper.findQuestionByPart(12, "Reading");
                        questionModels.addAll(qm);

                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);

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
                                if(player!= null) player.stop();
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    }
                    case 5:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(2, "Reading");
                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);

                        TextView txtP5 = (TextView) findViewById(R.id.txtP5);
                        txtP5.setText(inforModels.get(0).getReadingInfor());
                        TextView textView = (TextView) findViewById(R.id.txtPart);
                        textView.setText(R.string.part_6);
                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    }
                    case 6:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(3, "Reading");
                        InforModel inforModel = new InforModel();
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p1);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart5);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai5);

                        TextView txtP5 = (TextView) findViewById(R.id.txtP5);
                        txtP5.setText(inforModels.get(0).getReadingInfor());
                        TextView textView = (TextView) findViewById(R.id.txtPart);
                        textView.setText(R.string.part_7);

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
                            }
                        });
                        break;
                    }
                    case 7:
                    {
                        questionModels = dataBaseHelper.findQuestionByPart(4, "Reading");
                        InforModel inforModel = new InforModel(1,1,1,"");
                        inforModel = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inforModel);

                        setContentView(R.layout.on_theo_phan_layout_reading_p4);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart8);

                        TextView txtP8 = (TextView) findViewById(R.id.txtP8);
                        txtP8.setText(inforModels.get(0).getReadingInfor());
                        TextView textView = (TextView) findViewById(R.id.txtPart);
                        textView.setText(R.string.part_8);
                        ImageView img8 = (ImageView) findViewById(R.id.image8);
                        img8.setBackgroundResource(inforModels.get(0).getImgInfor());

                        context = OnTheoPhanActivity.this;
                        questionListenAdapterP23 = new QuestionListenAdapterP23(context,R.layout.question_form_02,questionModels);
                        myListQuestion.setAdapter(questionListenAdapterP23);
                        btnNopBai = (Button) findViewById(R.id.btnNopBai8);
                        btnNopBai.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                if(player!= null) player.stop();
                                if (questionListenAdapterP23.is_filled())
                                {
                                    checkAnswers2();
                                    ShowDialogResult();
                                }
                                else Toast.makeText(context, "Hãy trả lời tất cả các câu hỏi", Toast.LENGTH_LONG).show();
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
        btnNopBai.setText(R.string.xong);
        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnTheoPhanActivity.this.finish();
                Intent myIntent = new Intent(OnTheoPhanActivity.this, MainActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivities(new Intent[]{myIntent});
            }
        });
    }
    @SuppressLint("ResourceAsColor")
    void checkAnswers1()
    {
        n_question=questionModels.size();
        n_right_answer=questionListenAdapterP1.check();
    }
    void checkAnswers2()
    {
        n_question=questionModels.size();
        n_right_answer=questionListenAdapterP23.check();
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