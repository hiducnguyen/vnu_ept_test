package com.example.onthivnu_ept;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class OnTheoPhanActivity extends Activity
{
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter;
    QuestionListenAdapterP1 myQuestionAdapter;
    Boolean is_done = true;
    Integer n_right_answer = 0;
    Integer n_question = 0;
    Button btnNopBai;
    List<QuestionModel> questionModels;
    List<InforModel> inforModels;
    Context context;
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
        myListAdapter = new ArrayAdapter(this,R.layout.my_simple_list_item_1,myList);
        myListView.setAdapter(myListAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)
                {
                    case 1:
                    {
                        n_question = 10;
                        break;
                    }
                    case 2:
                    {
                        n_question = 6;
                        for(int i = 0; i< n_question; i++)
                        {
                            questionModels.get(i).setAnswerA("A");
                            questionModels.get(i).setAnswerB("B");
                            questionModels.get(i).setAnswerC("C");
                            questionModels.get(i).setAnswerD("D");
                            questionModels.get(i).setRightAnswer("A");
                            inforModels.get(i).setInfor(Integer.toString(R.raw.p1_1));
                        }

                        context = getApplicationContext();
                        setContentView(R.layout.on_theo_phan_layout_listenning_p23);
                        myListQuestion= (ListView) findViewById(R.id.myListQuestionPart1);


                        btnNopBai = (Button) findViewById(R.id.btnNopBai2);
                        btnNopBai.setEnabled(false);

                        ImageView img = (ImageView) findViewById(R.id.image23);
                        img.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                //Play
                            }
                        });

                        myQuestionAdapter = new QuestionListenAdapterP1(context,R.layout.question_form_02,questionModels,inforModels);
                        myListQuestion.setAdapter(myQuestionAdapter);
                        break;
                    }
                    case 3:
                    {
                        n_question = 8;
                        break;
                    }
                    case 4:
                    {
                        n_question = 8;
                        break;
                    }
                    case 5:
                    {
                        n_question = 20;
                        break;
                    }
                    case 6:
                    {
                        n_question = 6;
                        break;
                    }
                    case 7:
                    {
                        n_question = 8;
                        break;
                    }
                    case 8:
                    {
                        n_question = 6;
                        break;
                    }

                }

//                else
//                {
//                    reading_question[] rq;
//                    //Lay data
//                    myQuestionAdapter= new ArrayAdapter<reading_question>(this,R.layout.question_form_listening,rq);
//                    myListQuestion.setAdapter(myQuestionAdapter);
//                }
                while (is_done)
                {
                    checkAnswers();
                    btnNopBai.setEnabled(true);
                    btnNopBai.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            ShowDialogResult();
                        }
                    });
                }
            }
        });


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
        for (int i = 0; i < n_question; i++)
        {

        }
    }
}