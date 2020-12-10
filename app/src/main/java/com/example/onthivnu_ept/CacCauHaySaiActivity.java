package com.example.onthivnu_ept;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.IDNA;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.GONE;

public class CacCauHaySaiActivity extends Activity {

    private DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    private ArrayList<QuestionModel> listFreqFalseQuestions;

    ImageButton imgBtnListen;
    TextView txtInstruction, txtReadingInfor, txtQuestion, txtFalseCount;
    ImageView imgInfor;
    RadioGroup radioGroopAnswer;
    RadioButton radioBtnA, radioBtnB, radioBtnC, radioBtnD;
    ScrollView scrollViewReading;
    Button btnDung, btnCauKhac, btnKiemTra;

    MediaPlayer player;

    int numOfQuestion, count;

    private Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        listFreqFalseQuestions = dataBaseHelper.findFrequentlyFalseQuestion();
        if (listFreqFalseQuestions.size() == 0){
            backToMenu("Bạn chưa làm bài tập nào/chưa trả lời sai câu hỏi nào");
        }
        setContentView(R.layout.activity_cac_cau_hay_sai);
        initView();

        numOfQuestion = listFreqFalseQuestions.size();
        count = 0;

        displayNewQuestion();

        myIntent = new Intent(this, MainActivity.class);
        btnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(myIntent);
            }
        });
        btnCauKhac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null){
                    player.release();
                    player = null;
                }
                if (count < numOfQuestion){
                    displayNewQuestion();
                }
                else{
                    backToMenu("Bạn đã ôn hết tất cả các câu từng trả lời sai.");
                }
            }
        });
    }

    public String btnIsChecked(){
        if (radioBtnA.isChecked() == true) return "A";
        if (radioBtnB.isChecked() == true) return "B";
        if (radioBtnC.isChecked() == true) return "C";
        if (radioBtnD.isChecked() == true) return "D";
        return "";
    }

    public void displayNewQuestion(){
        final QuestionModel q = listFreqFalseQuestions.get(count);
        final InforModel infor = dataBaseHelper.findInforById(q.getIdInfor());

        txtFalseCount.setText("Số lần sai: " + Integer.toString(q.getCountFalse()));

        displayInstruction(q);
        displayListeningInfor(q, infor);
        displayReadingInfor(q, infor);
        displayImageInfor(q, infor);


        txtQuestion.setText(q.getQuestion());

        resetRadioChoice();

        radioBtnA.setText(q.getAnswerA());
        radioBtnB.setText(q.getAnswerB());
        radioBtnC.setText(q.getAnswerC());
        radioBtnD.setText(q.getAnswerD());

        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnIsChecked().compareTo("") == 0){
                    Toast.makeText(CacCauHaySaiActivity.this, "Bạn chưa chọn đáp án!!!", Toast.LENGTH_LONG).show();
                }
                else{
                    String msg = new String();
                    if (btnIsChecked().compareTo(q.getRightAnswer()) == 0){
                        msg = "Bạn đã trả lời đúng";
                    }
                    else{
                        msg = "Trả lời sai!!! Đáp án đúng là: " + q.getRightAnswer();
                        dataBaseHelper.increaseCountFalse(q);
                    }

                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(CacCauHaySaiActivity.this);

                    myBuilder.setMessage(msg)
                            .setPositiveButton("Close", null)
                            .show();
                }
            }
        });

        count++;
    }

    public void displayInstruction(QuestionModel questionModel){
        String instruction = new String();
        if (questionModel.getType().compareTo("Reading") == 0) {
            instruction = "Read the passage carefully";
        }
        else {
            switch (questionModel.getPart()){
                case 1:
                    instruction = getString(R.string.in_part_1_you_will_hear_ten_conversations_between_two_people_after_the_second_listening_of_each_conversation_you_will_hear_a_question_and_there_are_four_possible_answers_provided_select_the_best_answer_to_each_question);
                    break;
                case 2:
                    instruction = getString(R.string.in_part_2_you_will_hear_a_conversation_after_the_second_listening_there_are_six_incomplete_sentences_and_four_possible_options_provided_for_each_gap_select_the_best_option_to_complete_the_sentence);
                    break;
                case 3:
                    instruction = getString(R.string.in_part_3_you_will_hear_a_talk_after_the_second_listening_there_are_eight_questions_select_the_best_answer_to_each_question);
                    break;
                case 4:
                    instruction = getString(R.string.in_part_4_you_will_hear_part_of_a_lecture_after_the_second_listening_there_is_a_summary_of_the_lecture_with_eight_gaps_select_the_best_option_for_each_gap_to_complete_the_summary);
                    break;
            }
        }
        txtInstruction.setText(instruction);
    }

    public void displayListeningInfor(QuestionModel questionModel, final InforModel inforModel){
       if (questionModel.getType().compareTo("Reading") == 0){
            imgBtnListen.setVisibility(View.GONE);
        }
        else{
            imgBtnListen.setVisibility(View.VISIBLE);
            imgBtnListen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (player != null){
                        player.release();
                        player = null;
                    }
                    player = MediaPlayer.create(CacCauHaySaiActivity.this, inforModel.getListeningInfor());
                    player.start();
                }
            });
        }
    }

    public void displayReadingInfor(QuestionModel questionModel, InforModel inforModel){
        if (questionModel.getType().compareTo("Listening") == 0 && questionModel.getPart() != 4){
            scrollViewReading.setVisibility(View.GONE);
            txtReadingInfor.setVisibility(View.GONE);
        }
        else
        {
            scrollViewReading.setVisibility(View.VISIBLE);
            txtReadingInfor.setVisibility(View.VISIBLE);
            txtReadingInfor.setText(inforModel.getReadingInfor());
        }
    }

    public void displayImageInfor(QuestionModel questionModel, InforModel inforModel){
        if (questionModel.getType().compareTo("Reading") == 0 && questionModel.getPart() == 4){
            imgInfor.setVisibility(View.VISIBLE);
            imgInfor.setImageResource(inforModel.getImgInfor());
        }
        else{
            imgInfor.setVisibility(View.GONE);
        }
    }

    public void resetRadioChoice(){
        radioBtnA.setChecked(false);
        radioBtnB.setChecked(false);
        radioBtnC.setChecked(false);
        radioBtnD.setChecked(false);
    }

    public void backToMenu(String msg){
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);

        myIntent = new Intent(this,MainActivity.class);

        myBuilder.setMessage(msg)
                .setPositiveButton("Back to Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(myIntent);
                    }
                })
                .show();
    }

    private void initView(){
        imgBtnListen = (ImageButton) findViewById(R.id.imgBtnListen);
        txtInstruction = (TextView) findViewById(R.id.txtInstruction);
        imgInfor = (ImageView) findViewById(R.id.imgInfor);
        txtReadingInfor = (TextView) findViewById(R.id.txtReadingInfor);
        txtQuestion = (TextView) findViewById(R.id.txtQuestion);
        txtFalseCount = (TextView) findViewById(R.id.txtFalseCount);
        radioGroopAnswer = (RadioGroup) findViewById(R.id.radioGroupAnswer);
        radioBtnA = (RadioButton) findViewById(R.id.radioBtnA);
        radioBtnB = (RadioButton) findViewById(R.id.radioBtnB);
        radioBtnC = (RadioButton) findViewById(R.id.radioBtnC);
        radioBtnD = (RadioButton) findViewById(R.id.radioBtnD);
        scrollViewReading = (ScrollView) findViewById(R.id.scrollViewReading);
        btnDung = (Button) findViewById(R.id.btnDung);
        btnCauKhac = (Button) findViewById(R.id.btnCauKhac);
        btnKiemTra = (Button) findViewById(R.id.btnKiemTra);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null){
            player.stop();
            player = null;
        }
    }
}