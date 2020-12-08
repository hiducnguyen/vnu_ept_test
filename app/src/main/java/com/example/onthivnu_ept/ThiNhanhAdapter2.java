package com.example.onthivnu_ept;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ThiNhanhAdapter2 extends ArrayAdapter<QuestionModel> {
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    ArrayList<RadioButton> answerA = new ArrayList<>(), answerB = new ArrayList<>(), answerC = new ArrayList<>(), answerD = new ArrayList<>();
    RadioButton ra, rb, rc, rd;
    private int trueColor = R.color.colorBlue,
            falseColor = R.color.colorRed;
    ArrayList<String> listAnswer = new ArrayList<>();

    public ThiNhanhAdapter2(Context context, int resource, ArrayList<QuestionModel> questionModels) {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.resource = resource;
        for (int i = 0; i < questionModels.size(); i++) {
            answerA.add(ra);
            answerB.add(rb);
            answerC.add(rc);
            answerD.add(rd);
            listAnswer.add("N");
        }
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.question_form_02, null, false);

        TextView question = (TextView) row.findViewById(R.id.question2);
        ra = (RadioButton) row.findViewById(R.id.answerA);
        rb = (RadioButton) row.findViewById(R.id.answerB);
        rc = (RadioButton) row.findViewById(R.id.answerC);
        rd = (RadioButton) row.findViewById(R.id.answerD);

        question.setText(questionModels.get(position).getQuestion());
        ra.setText(questionModels.get(position).getAnswerA());
        rb.setText(questionModels.get(position).getAnswerB());
        rc.setText(questionModels.get(position).getAnswerC());
        rd.setText(questionModels.get(position).getAnswerD());

        answerA.set(position, ra);
        answerB.set(position, rb);
        answerC.set(position, rc);
        answerD.set(position, rd);

        if (listAnswer.get(position).equals("A")) {
            answerA.get(position).setChecked(true);
            check(position);
        }
        if (listAnswer.get(position).equals("B")) {
            answerB.get(position).setChecked(true);
            check(position);
        }
        if (listAnswer.get(position).equals("C")) {
            answerC.get(position).setChecked(true);
            check(position);
        }
        if (listAnswer.get(position).equals("D")) {
            answerD.get(position).setChecked(true);
            check(position);
        }

        answerA.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked) listAnswer.set(position, "A");
                check(position);
            }
        });

        answerB.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked) listAnswer.set(position, "B");
                check(position);
            }
        });
        answerC.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked) listAnswer.set(position, "C");
                check(position);
            }
        });
        answerD.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                if (isChecked) listAnswer.set(position, "D");
                check(position);

            }
        });


        answerA.get(position).setFocusable(false);
        answerB.get(position).setFocusable(false);
        answerC.get(position).setFocusable(false);
        answerD.get(position).setFocusable(false);
        return (row);
    }

    @SuppressLint("ResourceAsColor")
    void check(int position) {
        answerA.get(position).setEnabled(false);
        answerB.get(position).setEnabled(false);
        answerC.get(position).setEnabled(false);
        answerD.get(position).setEnabled(false);
        switch (questionModels.get(position).getRightAnswer()) {
            case "A": {
                answerA.get(position).setBackgroundColor(trueColor);
                break;
            }
            case "B": {
                answerB.get(position).setBackgroundColor(trueColor);
                break;
            }
            case "C": {
                answerC.get(position).setBackgroundColor(trueColor);
                break;
            }
            case "D": {
                answerD.get(position).setBackgroundColor(trueColor);
                break;
            }
        }
    }

}
