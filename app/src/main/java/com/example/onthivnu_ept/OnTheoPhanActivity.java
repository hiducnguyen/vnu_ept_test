package com.example.onthivnu_ept;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class OnTheoPhanActivity extends Activity {
    ListView myListView, myListQuestion;
    ArrayAdapter<String> myListAdapter, myQuestionAdapter;
    Boolean is_listen = true;
    Boolean is_done = false;
    Button btnNopBai;
    String[] myList={"Phần nghe Part 1","Phần nghe Part 2",
            "Phần nghe Part 3","Phần nghe Part 4",
            "Phần đọc Part 1","Phần đọc Part 2",
            "Phần đọc Part 3","Phần đọc Part 4"};
    DataBaseHelper dbHelper = new DataBaseHelper(OnTheoPhanActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_theo_phan);

        ArrayList<QuestionModel> l = dbHelper.findQuestionByPart(2, "Listening");

        for (int i = 0; i < l.size(); i++){
            Log.i("haha", l.get(i).toString());
        }

        //find inforModel by id
        InforModel i = dbHelper.findInforById(1);
        Log.i("haha", i.toString());

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

            }
        });

        myListAdapter = new ArrayAdapter<>(this,R.layout.my_simple_list_item_1,myList);
        myListView.setAdapter(myListAdapter);
    }
}