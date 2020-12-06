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
import android.widget.RadioButton;

import java.util.ArrayList;

public class OnTheoPhanActivity extends Activity
{
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter;
    QuestionListenAdapterP23 questionListenAdapterP23;
    Boolean is_not_done = true;
    MediaPlayer player;
    Integer n_right_answer = 0;
    Integer n_question = 0;
    Integer n_answer;
    Button btnNopBai;
    ImageView img;
    ArrayList<QuestionModel> questionModels;
    ArrayList<InforModel> inforModels;
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
                        break;
                    }
                    case 1:
                    {
                        n_question = 6;
                        questionModels = new ArrayList<>();
                        inforModels = new ArrayList<>();
                        questionModels = dataBaseHelper.findQuestionByPart(2,"Listening");
                        InforModel inf = new InforModel();
                        inf = dataBaseHelper.findInforById(questionModels.get(0).getIdInfor());
                        inforModels.add(inf);

                        for (int i=0;i<n_question;i++)
                        {
                            Log.i("as",questionModels.get(i).toString()+"\n");

                        }
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
                                player = MediaPlayer.create(context,inforModels.get(0).getListeningInfor());
                                player.start();
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
                                checkAnswers();
                                ShowDialogResult();
                            }
                        });
//                        while (is_not_done)
//                        {
//
//
//                            if (n_answer == n_question)
//                            {
//                                btnNopBai.setEnabled(true);
//                                is_not_done=false;
//                            }
//                        }

                        break;
                    }
                    case 2:
                    {
                        n_question = 8;
                        break;
                    }
                    case 3:
                    {
                        n_question = 8;
                        break;
                    }
                    case 4:
                    {
                        n_question = 20;
                        break;
                    }
                    case 5:
                    {
                        n_question = 6;
                        break;
                    }
                    case 6:
                    {
                        n_question = 8;
                        break;
                    }
                    case 7:
                    {
                        n_question = 6;
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
    void checkAnswers()
    {
        n_right_answer=0;
        n_answer = 0;

        for (int i = 0; i < n_question; i++)
        {

            View row;
            row = questionListenAdapterP23.getView(i,null,null);
            RadioButton answerA,answerB,answerC,answerD;
            answerA = (RadioButton) row.findViewById(R.id.answerA);
            answerB = (RadioButton) row.findViewById(R.id.answerB);
            answerC = (RadioButton) row.findViewById(R.id.answerC);
            answerD = (RadioButton) row.findViewById(R.id.answerD);

            if ((answerA.isChecked()&&questionModels.get(i).getRightAnswer()=="A") ||
                    (answerB.isChecked()&&questionModels.get(i).getRightAnswer()=="B") ||
                    (answerC.isChecked()&&questionModels.get(i).getRightAnswer()=="C") ||
                    (answerD.isChecked()&&questionModels.get(i).getRightAnswer()=="D")
            )
            {
                n_right_answer++;
                n_answer++;
            }
//            String str= questionListenAdapterP23.finalResult(i);
//            if (questionModels.get(i).getRightAnswer().equals(str))
//            {
//                n_right_answer++;
//                n_answer++;
//            }
//            else if (!"0".equals(str)) n_answer++;
        }
    }
}