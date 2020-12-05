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

public class QuestionListenAdapter extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private List<QuestionModel> questionModels;

    public QuestionListenAdapter(Context context, int resource, List<QuestionModel> objects)
    {
        super(context, resource, objects);
        this.context = context;
        this.questionModels = objects;
        this.resource = resource;
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
        ImageView img = (ImageView) row.findViewById(R.id.image);

        question.setText(questionModels.get(position).getQuestion());
        answerA.setText(questionModels.get(position).getAnswerA());
        answerB.setText(questionModels.get(position).getAnswerA());
        answerC.setText(questionModels.get(position).getAnswerC());
        answerD.setText(questionModels.get(position).getAnswerD());
        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        return (row);
    }
}
