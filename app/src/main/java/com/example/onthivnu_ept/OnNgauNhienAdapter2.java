package com.example.onthivnu_ept;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class OnNgauNhienAdapter2 extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    int i;


    RadioButton answerA,answerB,answerC,answerD;
    ImageView img;
    MediaPlayer player;

    private ArrayList<String> listAnswer=new ArrayList<>();

    public OnNgauNhienAdapter2(Context context, int resource, ArrayList<QuestionModel> questionModels)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;


        this.resource = resource;
        i=0;
        listAnswer.clear();
        if(listAnswer.isEmpty()) {
            for (int i = 0; i < questionModels.size(); i++) {
                listAnswer.add("N");
            }
        }
    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.question_form_02, null,false);

        TextView question = (TextView) row.findViewById(R.id.question2);
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

                if (isChecked) listAnswer.set(position,"A");

            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked

                if (isChecked) listAnswer.set(position,"B");
            }
        });
        answerC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked

                if (isChecked) listAnswer.set(position,"C");

            }
        });
        answerD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked

                if (isChecked) listAnswer.set(position,"D");

            }
        });



        answerA.setFocusable(false);
        answerB.setFocusable(false);
        answerC.setFocusable(false);
        answerD.setFocusable(false);

        answerA.setChecked(listAnswer.get(position).equals("A"));
        answerB.setChecked(listAnswer.get(position).equals("B"));
        answerC.setChecked(listAnswer.get(position).equals("C"));
        answerD.setChecked(listAnswer.get(position).equals("D"));

        return (row);
    }
    public boolean isValid()
    {
        return !listAnswer.contains("N");
    }




    public ArrayList<String> getListAnswer() {
        return listAnswer;
    }
}
