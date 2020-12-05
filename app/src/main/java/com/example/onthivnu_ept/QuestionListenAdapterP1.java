package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class QuestionListenAdapterP1 extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private List<QuestionModel> questionModels;
    private List<InforModel> inforModels;

    public QuestionListenAdapterP1(Context context, int resource, List<QuestionModel> questionModels,List<InforModel> inforModels)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.resource = resource;
        this.inforModels = inforModels;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.question_form_listening_p1, null);

        TextView question = (TextView) row.findViewById(R.id.question);
        RadioButton answerA = (RadioButton) row.findViewById(R.id.answerA);
        RadioButton answerB = (RadioButton) row.findViewById(R.id.answerB);
        RadioButton answerC = (RadioButton) row.findViewById(R.id.answerC);
        RadioButton answerD = (RadioButton) row.findViewById(R.id.answerD);

        question.setText(questionModels.get(position).getQuestion());
        answerA.setText(questionModels.get(position).getAnswerA());
        answerB.setText(questionModels.get(position).getAnswerA());
        answerC.setText(questionModels.get(position).getAnswerC());
        answerD.setText(questionModels.get(position).getAnswerD());
        return (row);
    }
}
