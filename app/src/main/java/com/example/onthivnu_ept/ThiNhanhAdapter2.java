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
    ArrayList<String> answers;
    RadioButton answerA,answerB,answerC,answerD;
    ImageView img;
    MediaPlayer player;
    private int trueColor = R.color.colorBlue,
            falseColor = R.color.colorRed;
    public ArrayList<String> listAnswer= new ArrayList<>();
    public ThiNhanhAdapter2(Context context, int resource, ArrayList<QuestionModel> questionModels,ArrayList<InforModel> inforModels,ArrayList<String> answers)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.inforModels = inforModels;
        this.answers= answers;
        this.resource = resource;
        for(int i=0;i<questionModels.size();i++)
        {
            listAnswer.add("N");
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
                check("A", position, answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"A");
            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("B", position, answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"B");
            }
        });
        answerC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("C", position, answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"C");

            }
        });
        answerD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("D", position, answerA,answerB,answerC,answerD);
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
    @SuppressLint("ResourceAsColor")
    void check(String answer, int position, RadioButton ra, RadioButton rb, RadioButton rc, RadioButton rd)
    {
        if (answer.equals(answers.get(position)))
        {
            switch (answer)
            {
                case "A": {ra.setBackgroundColor(trueColor); break;}
                case "B": {rb.setBackgroundColor(trueColor);break;}
                case "C": {rc.setBackgroundColor(trueColor);break;}
                case "D": {rd.setBackgroundColor(trueColor);break;}
            }

        }
        else
        {
            switch (answers.get(position))
            {
                case "A": {ra.setBackgroundColor(falseColor); break;}
                case "B": {rb.setBackgroundColor(falseColor);break;}
                case "C": {rc.setBackgroundColor(falseColor);break;}
                case "D": {rd.setBackgroundColor(falseColor);break;}
            }
        }

        answerA.setEnabled(false);
        answerB.setEnabled(false);
        answerC.setEnabled(false);
        answerD.setEnabled(false);

    }

}
