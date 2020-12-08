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
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ViewUtils;

import java.util.ArrayList;
import java.util.List;

public class OnNgauNhienAdapter extends ArrayAdapter<QuestionModel>
{
    private Context context;
    private int resource;
    private ArrayList<QuestionModel> questionModels;
    private ArrayList<InforModel> inforModels;
    RadioButton answerA,answerB,answerC,answerD;
    ImageView img;

    MediaPlayer player;

    private ArrayList<String> listAnswer=new ArrayList<>() ;

    public MediaPlayer getPlayer() {
        return player;
    }

    public OnNgauNhienAdapter(Context context, int resource, ArrayList<QuestionModel> questionModels, ArrayList<InforModel> inforModels)
    {
        super(context, resource, questionModels);
        this.context = context;
        this.questionModels = questionModels;
        this.inforModels = inforModels;
        this.resource = resource;


        this.resource = resource;
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

        View row = inflater.inflate(R.layout.question_form_listening_p1, parent,false);

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

                if (isChecked)  listAnswer.set(position,"A");
            }
        });

        answerB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // set Yes values in ArrayList if RadioButton is checked

                if (isChecked) {
                    listAnswer.set(position,"B");}

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
        return (row);
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

    public ArrayList<String> getListAnswer() {
        return listAnswer;
    }
}
