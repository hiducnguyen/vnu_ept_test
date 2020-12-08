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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    ArrayList<RadioButton> answerA = new ArrayList<>(),answerB= new ArrayList<>(),answerC= new ArrayList<>(),answerD= new ArrayList<>();
    RadioButton ra, rb, rc, rd;
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
        Toast.makeText(context,String.valueOf(position),Toast.LENGTH_LONG).show();

        TextView question = (TextView) row.findViewById(R.id.question1);
        ra = (RadioButton) row.findViewById(R.id.answerA);
        rb = (RadioButton) row.findViewById(R.id.answerB);
        rc = (RadioButton) row.findViewById(R.id.answerC);
        rd = (RadioButton) row.findViewById(R.id.answerD);
        img=(ImageView)row.findViewById(R.id.image1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                play(context,inforModels.get(position).getListeningInfor());
            }
        });

        question.setText(questionModels.get(position).getQuestion());
        answerA.set(position,ra);
        answerB.set(position,rb);
        answerC.set(position,rc);
        answerD.set(position,rd);

        answerA.get(position).setText(questionModels.get(position).getAnswerA());
        answerB.get(position).setText(questionModels.get(position).getAnswerB());
        answerC.get(position).setText(questionModels.get(position).getAnswerC());
        answerD.get(position).setText(questionModels.get(position).getAnswerD());

        if (listAnswer.get(position).equals("A"))
        {
            answerA.get(position).setChecked(true);
            answerA.get(position).setBackgroundColor(trueColor);
        }
        if (listAnswer.get(position).equals("B"))
        {
            answerB.get(position).setChecked(true);
            answerB.get(position).setBackgroundColor(trueColor);

        }
        if (listAnswer.get(position).equals("C"))
        {
            answerC.get(position).setChecked(true);
            answerC.get(position).setBackgroundColor(trueColor);

        }
        if (listAnswer.get(position).equals("D"))
        {
            answerD.get(position).setChecked(true);
            answerD.get(position).setBackgroundColor(trueColor);

        }

        answerA.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check(position,answerA.get(position),answerB.get(position),answerC.get(position),answerD.get(position));
                if (isChecked)  listAnswer.set(position,"A");
            }
        });

        answerB.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check(position,answerA.get(position),answerB.get(position),answerC.get(position),answerD.get(position));
                if (isChecked) listAnswer.set(position,"B");
            }
        });
        answerC.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check(position,answerA.get(position),answerB.get(position),answerC.get(position),answerD.get(position));
                if (isChecked) listAnswer.set(position,"C");
            }
        });
        answerD.get(position).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked
                check(position,answerA.get(position),answerB.get(position),answerC.get(position),answerD.get(position));
                if (isChecked) listAnswer.set(position,"D");
            }
        });


        answerA.get(position).setFocusable(false);
        answerB.get(position).setFocusable(false);
        answerC.get(position).setFocusable(false);
        answerD.get(position).setFocusable(false);
        return (row);
    }
    void check(int position, RadioButton radioButtonA, RadioButton radioButtonB, RadioButton radioButtonC, RadioButton radioButtonD)
    {
        radioButtonA.setEnabled(false);
        radioButtonB.setEnabled(false);
        radioButtonC.setEnabled(false);
        radioButtonD.setEnabled(false);
        switch (answers.get(position))
        {
            case "A": {radioButtonA.setBackgroundColor(trueColor); break;}
            case "B": {radioButtonB.setBackgroundColor(trueColor);break;}
            case "C": {radioButtonC.setBackgroundColor(trueColor);break;}
            case "D": {radioButtonD.setBackgroundColor(trueColor);break;}
        }
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

}
