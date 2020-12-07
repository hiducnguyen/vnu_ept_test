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

public class ThiNhanhAdapter extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    private ArrayList<InforModel> inforModels;
    RadioButton answerA,answerB,answerC,answerD;
    ImageView img;
    ArrayList<String> answers;
    MediaPlayer player;
    private int trueColor = R.color.colorBlue,
            falseColor = R.color.colorRed;
    public ArrayList<String> listAnswer = new ArrayList<>();

    public MediaPlayer getPlayer() {
        return player;
    }

    public ThiNhanhAdapter(Context context, int resource, ArrayList<QuestionModel> questionModels, ArrayList<InforModel> inforModels, ArrayList<String> answers)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.inforModels = inforModels;
        this.resource = resource;
        this.answers = answers;
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
        View row = inflater.inflate(R.layout.question_form_listening_p1, null,false);

        TextView question = (TextView) row.findViewById(R.id.question1);
        answerA = (RadioButton) row.findViewById(R.id.answerA);
        answerB = (RadioButton) row.findViewById(R.id.answerB);
        answerC = (RadioButton) row.findViewById(R.id.answerC);
        answerD = (RadioButton) row.findViewById(R.id.answerD);
        img=(ImageView)row.findViewById(R.id.image1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                play(context,inforModels.get(position).getListeningInfor());
            }
        });
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
                check("A", position,answerA,answerB,answerC,answerD);
                if (isChecked)  listAnswer.set(position,"A");
            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("B",position,answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"B");
            }
        });
        answerC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("C",position,answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"C");
            }
        });
        answerD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check("D", position,answerA,answerB,answerC,answerD);
                if (isChecked) listAnswer.set(position,"D");
            }
        });


        answerA.setFocusable(false);
        answerB.setFocusable(false);
        answerC.setFocusable(false);
        answerD.setFocusable(false);
        return (row);
    }
    @SuppressLint("ResourceAsColor")
    void check(String answer, int position, RadioButton radioButtonA, RadioButton radioButtonB, RadioButton radioButtonC, RadioButton radioButtonD)
    {
        if (answer.equals(answers.get(position)))
        {
            switch (answer)
            {
                case "A": {radioButtonA.setBackgroundColor(trueColor); break;}
                case "B": {radioButtonB.setBackgroundColor(trueColor);break;}
                case "C": {radioButtonC.setBackgroundColor(trueColor);break;}
                case "D": {radioButtonD.setBackgroundColor(trueColor);break;}
            }
        }
        else
        {
            switch (answers.get(position))
            {
                case "A": {radioButtonA.setBackgroundColor(falseColor); break;}
                case "B": {radioButtonB.setBackgroundColor(falseColor);break;}
                case "C": {radioButtonC.setBackgroundColor(falseColor);break;}
                case "D": {radioButtonD.setBackgroundColor(falseColor);break;}
            }
        }

        radioButtonA.setEnabled(false);
        radioButtonB.setEnabled(false);
        radioButtonC.setEnabled(false);
        radioButtonD.setEnabled(false);

    }
    void play(Context context, int resource)
    {

        if (player != null)
        {
            player.release();
            player = null;
        }
        player = MediaPlayer.create(context, resource);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                player.release();
                player=null;
            }
        });
    }

    @Override
    public void setNotifyOnChange(boolean notifyOnChange) {
        super.setNotifyOnChange(notifyOnChange);
    }
}
