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

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class ThiNhanhAdapter2 extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    private ArrayList<InforModel> inforModels;
    RadioButton answerA,answerB,answerC,answerD;
    ImageView img;
    MediaPlayer player;
    private int trueColor = R.color.colorBlue,
            falseColor = R.color.colorRed;
    public static ArrayList<String> listAnswer;
    public ThiNhanhAdapter2(Context context, int resource, ArrayList<QuestionModel> questionModels,ArrayList<InforModel> inforModels,ArrayList<String> answers)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.inforModels = inforModels;
        this.resource = resource;
        listAnswer = answers;
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

        answerA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (answerA.isChecked()) check("A", position);
            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (answerB.isChecked()) check("B", position);
            }
        });
        answerC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (answerC.isChecked()) check("C", position);
            }
        });
        answerD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (answerD.isChecked()) check("D", position);
            }
        });


        answerA.setFocusable(false);
        answerB.setFocusable(false);
        answerC.setFocusable(false);
        answerD.setFocusable(false);

        answerA.setChecked(listAnswer.get(position)=="A");
        answerA.setChecked(listAnswer.get(position)=="A");
        answerA.setChecked(listAnswer.get(position)=="A");
        answerA.setChecked(listAnswer.get(position)=="A");

        return (row);
    }
    @SuppressLint("ResourceAsColor")
    void check(String answer, int position)
    {
        if (listAnswer.get(position).equals(answer))
        {
            switch (answer)
            {
                case "A": {answerA.setTextColor(trueColor); break;}
                case "B": {answerB.setTextColor(trueColor);break;}
                case "C": {answerC.setTextColor(trueColor);break;}
                case "D": {answerD.setTextColor(trueColor);break;}
            }
        }

        answerA.setEnabled(false);
        answerB.setEnabled(false);
        answerC.setEnabled(false);
        answerD.setEnabled(false);

    }

}
