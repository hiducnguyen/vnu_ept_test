package com.example.onthivnu_ept;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
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

import java.util.ArrayList;

public class QuestionListenAdapterP1 extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;

    public ArrayList<String> getListAnswer() {
        return listAnswer;
    }

    private ArrayList<QuestionModel> questionModels;
    private ArrayList<InforModel>inforModels;
    Boolean is_done= false;
    ArrayList<RadioButton> answerA = new ArrayList<>(),answerB= new ArrayList<>(),answerC= new ArrayList<>(),answerD= new ArrayList<>();
    RadioButton ra, rb, rc, rd;
    int trueColor = R.color.colorRed;
    ImageView img;
    ArrayList<String> listAnswer;
    MediaPlayer player;

    public MediaPlayer getPlayer() {
        return player;
    }

    public QuestionListenAdapterP1(Context context, int resource, ArrayList<QuestionModel> questionModels, ArrayList<InforModel> inforModels)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.resource = resource;
        this.inforModels = inforModels;
        listAnswer=new ArrayList<>();
        for(int i=0;i<questionModels.size();i++)
        {
            answerA.add(ra);
            answerB.add(rb);
            answerC.add(rc);
            answerD.add(rd);
            listAnswer.add("N");
        }
    }
    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View row = inflater.inflate(R.layout.question_form_listening_p1, null,false);

        TextView question = (TextView) row.findViewById(R.id.question1);
        img = (ImageView) row.findViewById(R.id.image1);
        ra = (RadioButton) row.findViewById(R.id.answerA);
        rb = (RadioButton) row.findViewById(R.id.answerB);
        rc = (RadioButton) row.findViewById(R.id.answerC);
        rd = (RadioButton) row.findViewById(R.id.answerD);

        answerA.set(position,ra);
        answerB.set(position,rb);
        answerC.set(position,rc);
        answerD.set(position,rd);

        question.setText(questionModels.get(position).getQuestion());
        answerA.get(position).setText(questionModels.get(position).getAnswerA());
        answerB.get(position).setText(questionModels.get(position).getAnswerB());
        answerC.get(position).setText(questionModels.get(position).getAnswerC());
        answerD.get(position).setText(questionModels.get(position).getAnswerD());

        if (listAnswer.get(position).equals("A"))
        {
            answerA.get(position).setChecked(true);
            if (is_done) check(position);
        }
        if (listAnswer.get(position).equals("B"))
        {
            answerB.get(position).setChecked(true);
            if (is_done) check(position);
        }
        if (listAnswer.get(position).equals("C"))
        {
            answerC.get(position).setChecked(true);
            if (is_done) check(position);
        }
        if (listAnswer.get(position).equals("D"))
        {
            answerD.get(position).setChecked(true);
            if (is_done) check(position);
        }

        answerA.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                listAnswer.set(position,"A");
            }
        });

        answerB.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                listAnswer.set(position,"B");
            }
        });
        answerC.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                listAnswer.set(position,"C");
            }
        });
        answerD.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                listAnswer.set(position,"D"); }
        });

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,inforModels.get(position).getListeningInfor());
            }
        });

        img.setFocusable(false);
        answerA.get(position).setFocusable(false);
        answerB.get(position).setFocusable(false);
        answerC.get(position).setFocusable(false);
        answerD.get(position).setFocusable(false);

        return (row);
    }

    @SuppressLint("ResourceAsColor")
    public int check()
    {
        int result = 0;
        is_done= true;
        for (int i = 0; i < questionModels.size(); i++)
        {
            answerA.get(i).setEnabled(false);
            answerB.get(i).setEnabled(false);
            answerC.get(i).setEnabled(false);
            answerD.get(i).setEnabled(false);
            if (questionModels.get(i).getRightAnswer().equals(listAnswer.get(i))) result++;
            switch (questionModels.get(i).getRightAnswer())
            {
                case "A": {answerA.get(i).setBackgroundColor(trueColor);break;}
                case "B": {answerB.get(i).setBackgroundColor(trueColor);break;}
                case "C": {answerC.get(i).setBackgroundColor(trueColor);break;}
                case "D": {answerD.get(i).setBackgroundColor(trueColor);break;}
            }
        }

        return result;
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
    String finalResult(int position)
    {
        return listAnswer.get(position);
    }
    @SuppressLint("ResourceAsColor")
    void check(int position)
    {
        answerA.get(position).setEnabled(false);
        answerB.get(position).setEnabled(false);
        answerC.get(position).setEnabled(false);
        answerD.get(position).setEnabled(false);
        switch (questionModels.get(position).getRightAnswer())
        {
            case "A": {answerA.get(position).setBackgroundColor(trueColor);break;}
            case "B": {answerB.get(position).setBackgroundColor(trueColor);break;}
            case "C": {answerC.get(position).setBackgroundColor(trueColor);break;}
            case "D": {answerD.get(position).setBackgroundColor(trueColor);break;}
        }
    }
    Boolean is_filled()
    {
        int count = 0;
        for (int i = 0; i<questionModels.size();i++)
        {
            if (!listAnswer.get(i).equals("N")) count++;
        }
        if (count==questionModels.size()) return  true;
        return false;
    }
}