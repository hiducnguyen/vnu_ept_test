package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class QuestionListenAdapterP23 extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    TextView question;
    RadioButton answerA,answerB,answerC,answerD;
    public static ArrayList<String> listAnswer;
    public QuestionListenAdapterP23(Context context, int resource, ArrayList<QuestionModel> questionModels)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.resource = resource;
        listAnswer=new ArrayList<>();
        for(int i=  0; i < questionModels.size();i++)
        {
            listAnswer.add("N");
        }
    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.question_form_02, null);
        question = (TextView) row.findViewById(R.id.question2);
        answerA = (RadioButton) row.findViewById(R.id.answerA);
        answerB = (RadioButton) row.findViewById(R.id.answerB);
        answerC = (RadioButton) row.findViewById(R.id.answerC);
        answerD = (RadioButton) row.findViewById(R.id.answerD);

        question.setText(questionModels.get(position).getQuestion());
        answerA.setText(questionModels.get(position).getAnswerA());
        answerB.setText(questionModels.get(position).getAnswerB());
        answerC.setText(questionModels.get(position).getAnswerC());
        answerD.setText(questionModels.get(position).getAnswerD());

        answerA.setChecked(listAnswer.get(position).equals("A"));
        answerB.setChecked(listAnswer.get(position).equals("B"));
        answerC.setChecked(listAnswer.get(position).equals("C"));
        answerD.setChecked(listAnswer.get(position).equals("D"));
        answerA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    listAnswer.set(position,"A");
            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    listAnswer.set(position,"B");
            }
        });
        answerC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    listAnswer.set(position,"C");
            }
        });
        answerD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked)
                    listAnswer.set(position,"D");
            }
        });

        answerA.setFocusable(false);
        answerB.setFocusable(false);
        answerC.setFocusable(false);
        answerD.setFocusable(false);

        answerA.setFocusableInTouchMode(false);
        answerB.setFocusableInTouchMode(false);
        answerC.setFocusableInTouchMode(false);
        answerD.setFocusableInTouchMode(false);
        return (row);
    }
    public String finalResult(int position)
    {
        return listAnswer.get(position);
    }
}
