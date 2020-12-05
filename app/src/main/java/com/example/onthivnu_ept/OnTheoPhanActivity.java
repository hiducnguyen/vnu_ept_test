package com.example.onthivnu_ept;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class OnTheoPhanActivity extends Activity
{
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter, myQuestionAdapter;
    Boolean is_listen = true;
    Boolean is_done = true;
    Integer n_right_answer = 0;
    Integer n_answer = 0;
    Button btnNopBai;
    String[] myList={"Phần nghe Part 1","Phần nghe Part 2",
            "Phần nghe Part 3","Phần nghe Part 4",
            "Phần đọc Part 1","Phần đọc Part 2",
            "Phần đọc Part 3","Phần đọc Part 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_theo_phan);

        myListView=(ListView) findViewById(R.id.list_item_otp);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                switch (position)       //Chọn data base và form_listenning hay reading
                {
                    case 1:
                    {
                        break;
                    }
                    case 2:
                    {
                        break;
                    }
                    case 3:
                    {
                        break;
                    }
                    case 4:
                    {
                        break;
                    }
                    case 5:
                    {
                        break;
                    }
                    case 6:
                    {
                        break;
                    }
                    case 7:
                    {
                        break;
                    }
                    case 8:
                    {
                        break;
                    }

                }

                setContentView(R.layout.on_theo_phan_layout);
                myListQuestion= (ListView) findViewById(R.id.myListQuestion);
                btnNopBai=(Button)findViewById(R.id.btnNopBai);
                btnNopBai.setEnabled(false);
//                if (is_listen)
//                {
//                    listening_question[] lq;
//                    //Lay data
//                    myQuestionAdapter= new ArrayAdapter<listening_question>(this,R.layout.question_form_listening,lq);
//                    myListQuestion.setAdapter(myQuestionAdapter);
//                }
//                else
//                {
//                    reading_question[] rq;
//                    //Lay data
//                    myQuestionAdapter= new ArrayAdapter<reading_question>(this,R.layout.question_form_listening,rq);
//                    myListQuestion.setAdapter(myQuestionAdapter);
//                }

                if(is_done)
                {
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

        myListAdapter = new ArrayAdapter<>(this,R.layout.my_simple_list_item_1,myList);
        myListView.setAdapter(myListAdapter);
    }
    void ShowDialogResult()
    {
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);

        myBuilder.setMessage("Bạn có "+n_right_answer.toString()+"/"+n_answer+" câu trả lời đúng")
                .setPositiveButton("Close", null)
                .show();
    }
}