package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class ThiThu extends Activity {

    MediaPlayer player;
    ListView list1, list2, list3, list4, list5, list6, list7, list8;
    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);

    OnNgauNhienAdapter adapterListeningP1;
    OnNgauNhienAdapter2 adapterListeningP2,adapterListeningP3,adapterListeningP4,
            adapterReadingP1,adapterReadingP2,adapterReadingP3,adapterReadingP4;

    Context context;

    Button btnNext1,btnPrevious1;
    Button btnNext2,btnPrevious2;
    Button btnNext3,btnPrevious3;
    Button btnNext4,btnPrevious4;
    Button btnNext5,btnPrevious5;
    Button btnNext6,btnPrevious6;
    Button btnNext7,btnPrevious7;
    Button btnNext8,btnPrevious8;

    private int countPart1;
    private int countPart2;
    private int countPart3;
    private int countPart4;
    private int countPart5;
    private int countPart6;
    private int countPart7;
    private int countPart8;

    ArrayList<QuestionModel>arrayListListeningPart1;
    ArrayList<InforModel>arrayListListeningPart2;
    ArrayList<InforModel>arrayListListeningPart3;
    ArrayList<InforModel>arrayListListeningPart4;
    ArrayList<InforModel>arrayListReadingPart1;
    ArrayList<InforModel>arrayListReadingPart2;
    ArrayList<InforModel>arrayListReadingPart3;
    ArrayList<InforModel>arrayListReadingPart4;

    ArrayList<InforModel>arrayListListeningPart1Info=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart2Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart3Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListListeningPart4Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart1Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart2Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart3Question=new ArrayList<>();
    ArrayList<QuestionModel>arrayListReadingPart4Question=new ArrayList<>();

    ArrayList<QuestionModel>arrayResultListListeningPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart2=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart3=new ArrayList<>();
    ArrayList<InforModel>arrayResultListListeningPart4=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart1=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart2=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart3=new ArrayList<>();
    ArrayList<InforModel>arrayResultListReadingPart4=new ArrayList<>();

    Button  btnKTTT;
    ImageView imgP2,imgP3,imgP4;
    TextView txtP4tn,txtP5tn,txtP6tn,txtP7tn,txtP8tn;

    int countResult=0;

    ArrayList<String> listRightAnswer;

    ArrayList<String>listAnswer;

    CountDownTimer myTimer;

    TextView timer;
    boolean isTimerFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataOfLists();
        randomQuestion();
        myTimer=new CountDownTimer(6000000,1000) {
            @Override
            public void onTick(long l) {
                NumberFormat f = new DecimalFormat("00");
                long hour = (l / 3600000) % 24;
                long min = (l / 60000) % 60;
                long sec = (l / 1000) % 60;

                timer.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
            }

            @Override
            public void onFinish() {
                checkAnswer();
                showDialogTimeFinish();
            }
        }.start();


        doPart1();


    }
    private void doPart1() {

        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p1);
        context = ThiThu.this;
        list1 = (ListView) findViewById(R.id.listTT1);

        timer=(TextView)findViewById(R.id.timerP1);


        btnNext1 = (Button) findViewById(R.id.btnNextTT1);
        btnPrevious1 = (Button) findViewById(R.id.btnPreviousTT1);

        if(adapterListeningP1==null)
            adapterListeningP1 = new OnNgauNhienAdapter(this, R.layout.question_form_listening_p1, arrayResultListListeningPart1, arrayListListeningPart1Info);

        list1.setAdapter(adapterListeningP1);

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

            }
        });

        btnPrevious1.setEnabled(false);

        btnNext1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) { player = adapterListeningP1.getPlayer();doPart2();
                }
            });

    }
    private void doPart2()
    {
        if (player!=null) player.stop();

        setContentView(R.layout.thi_thu_layout_p2);
        context = ThiThu.this;

        btnNext2 = (Button) findViewById(R.id.btnNextTT2);
        btnPrevious2 = (Button) findViewById(R.id.btnPreviousTT2);

        timer=(TextView)findViewById(R.id.timerP2) ;


        imgP2 = (ImageView) findViewById(R.id.imageTT2tn);
        list2=(ListView) findViewById(R.id.listTT2);

        if(adapterListeningP2==null)
            adapterListeningP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart2Question);

        list2.setAdapter(adapterListeningP2);
        imgP2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,arrayResultListListeningPart2.get(0).getListeningInfor());
            }
        });

        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart3();
            }
        });
        btnPrevious2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { doPart1();
                    }
                });

    }
    private void doPart3()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p3);
        context = ThiThu.this;

        btnNext3 = (Button) findViewById(R.id.btnNextTT3);
        btnPrevious3 = (Button) findViewById(R.id.btnPreviousTT3);
        imgP3 = (ImageView) findViewById(R.id.imageTT3tn);
        list3=(ListView) findViewById(R.id.listTT3);

        timer=(TextView)findViewById(R.id.timerP3) ;

        if(adapterListeningP3==null)
            adapterListeningP3 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListListeningPart3Question);

        list3.setAdapter(adapterListeningP3);
        imgP3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,arrayResultListListeningPart3.get(0).getListeningInfor());
            }
        });


        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doPart4(); }
                });
        btnPrevious3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { doPart2();
            }
        });

    }
    private void doPart4()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p4);
        context = ThiThu.this;

        btnNext4 = (Button) findViewById(R.id.btnNextTT4);
        btnPrevious4 = (Button) findViewById(R.id.btnPreviousTT4);
        imgP4 = (ImageView) findViewById(R.id.imageTT4tn);
        txtP4tn=(TextView)findViewById(R.id.txtTTP4tn);
        txtP4tn.setText(arrayResultListListeningPart4.get(0).getReadingInfor());
        list4=(ListView) findViewById(R.id.listTT4);

        timer=(TextView)findViewById(R.id.timerP4) ;

        if(adapterListeningP4==null)
            adapterListeningP4 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListListeningPart4Question);
        list4.setAdapter(adapterListeningP4);

        imgP4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                play(context,arrayResultListListeningPart4.get(0).getListeningInfor());
            }
        });

        btnNext4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart5();

                    }
                });

        btnPrevious4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart3();
                    }
                });

    }
    private void doPart5()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p5);
        context = ThiThu.this;

        btnNext5 = (Button) findViewById(R.id.btnNextTT5);
        btnPrevious5 = (Button) findViewById(R.id.btnPreviousTT5);
        txtP5tn=(TextView)findViewById(R.id.txtTTP5tn);
        txtP5tn.setText(arrayResultListReadingPart1.get(0).getReadingInfor());

        timer=(TextView)findViewById(R.id.timerP5) ;

        list5=(ListView) findViewById(R.id.listTT5);

        if(adapterReadingP1==null)
            adapterReadingP1 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart1Question);
        list5.setAdapter(adapterReadingP1);

        btnNext5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart6();

                    }
                });

        btnPrevious5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart4();
                    }
                });

    }
    private void doPart6()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p6);
        context = ThiThu.this;

        btnNext6 = (Button) findViewById(R.id.btnNextTT6);
        btnPrevious6 = (Button) findViewById(R.id.btnPreviousTT6);
        txtP6tn=(TextView)findViewById(R.id.txtTTP6tn);
        txtP6tn.setText(arrayResultListReadingPart2.get(0).getReadingInfor());

        timer=(TextView)findViewById(R.id.timerP6) ;

        list6=(ListView) findViewById(R.id.listTT6);

        if(adapterReadingP2==null)
            adapterReadingP2 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart2Question);
        list6.setAdapter(adapterReadingP2);

        btnNext6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart7();

                    }
                });

        btnPrevious6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { doPart5();
                    }
                });

    }
    private void doPart7()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p7);
        context = ThiThu.this;

        btnNext7 = (Button) findViewById(R.id.btnNextTT7);
        btnPrevious7 = (Button) findViewById(R.id.btnPreviousTT7);
        txtP7tn=(TextView)findViewById(R.id.txtTTP7tn);
        txtP7tn.setText(arrayResultListReadingPart3.get(0).getReadingInfor());

        timer=(TextView)findViewById(R.id.timerP7);

        list7=(ListView) findViewById(R.id.listTT7);

        if(adapterReadingP3==null)
            adapterReadingP3 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart3Question);
        list7.setAdapter(adapterReadingP3);

        btnNext7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart8();
                    }
                });

        btnPrevious7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { doPart6();
                    }
                });


    }
    private void doPart8()
    {
        if (player!=null) player.stop();
        setContentView(R.layout.thi_thu_layout_p8);
        context = ThiThu.this;

        btnNext8 = (Button) findViewById(R.id.btnNextTT8);
        btnPrevious8 = (Button) findViewById(R.id.btnPreviousTT8);
        txtP8tn=(TextView)findViewById(R.id.txtTTP8tn);
        txtP8tn.setText(arrayResultListReadingPart4.get(0).getReadingInfor());

        timer=(TextView)findViewById(R.id.timerP8);

        list8=(ListView) findViewById(R.id.listTT8);

        if(adapterReadingP4==null)
            adapterReadingP4 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart4Question);
        list8.setAdapter(adapterReadingP4);
        btnKTTT=(Button)findViewById(R.id.btnKTTT);
        if(!isTimerFinish) {
            btnKTTT.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (player != null) player.stop();
                    checkAnswer();
                    showDialogResult();
                }
            });
        }
        else
            btnKTTT.setEnabled(false);

        btnNext8.setEnabled(false);

        btnPrevious8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        doPart7();
                }
            });

    }

    private void initDataOfLists()
    {

        isTimerFinish=false;

        countPart1=10;
        countPart2=6;
        countPart3=8;
        countPart4=6;
        countPart5=20;
        countPart6=6;
        countPart7=7;
        countPart8=7;

        arrayListListeningPart1=new ArrayList<>(dataBaseHelper.findQuestionByPart(1,"Listening"));
        arrayListListeningPart2=new ArrayList<>(dataBaseHelper.findInforByPart(2,"Listening"));
        arrayListListeningPart3=new ArrayList<>(dataBaseHelper.findInforByPart(3,"Listening"));
        arrayListListeningPart4=new ArrayList<>(dataBaseHelper.findInforByPart(4,"Listening"));

        arrayListReadingPart1=new ArrayList<>();

        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(11,"Reading"));
        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(12,"Reading"));
        arrayListReadingPart2=new ArrayList<>(dataBaseHelper.findInforByPart(2,"Reading"));
        arrayListReadingPart3=new ArrayList<>(dataBaseHelper.findInforByPart(3,"Reading"));
        arrayListReadingPart4=new ArrayList<>(dataBaseHelper.findInforByPart(4,"Reading"));


        listRightAnswer=new ArrayList<>();
        listAnswer=new ArrayList<>();
        countResult=0;




    }
    private void randomQuestion()
    {
        Random rand=new Random();
        InforModel im;
        int randomIdx;

            for (int i = 0; i < countPart1; i++) {
                int randomIndex = rand.nextInt(arrayListListeningPart1.size());
                QuestionModel ques = arrayListListeningPart1.get(randomIndex);
                arrayResultListListeningPart1.add(ques);

                listRightAnswer.add(ques.getRightAnswer());

                arrayListListeningPart1Info.add(dataBaseHelper.findInforById(ques.getIdInfor()));
                arrayListListeningPart1.remove(randomIndex);
            }


        //

            randomIdx = rand.nextInt(arrayListListeningPart2.size());
            im = arrayListListeningPart2.get(randomIdx);
            arrayResultListListeningPart2.add(im);
            arrayListListeningPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));


            for (int i = 0; i < arrayListListeningPart2Question.size() - countPart2; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart2Question.size());
                arrayListListeningPart2Question.remove(randomIndex);
            }

            for(int i=0;i<arrayListListeningPart2Question.size();i++)
                listRightAnswer.add(arrayListListeningPart2Question.get(i).getRightAnswer());

        //


            randomIdx = rand.nextInt(arrayListListeningPart3.size());
            im = arrayListListeningPart3.get(randomIdx);
            arrayResultListListeningPart3.add(im);
            arrayListListeningPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart3Question.size() - countPart3; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart3Question.size());
                arrayListListeningPart3Question.remove(randomIndex);

            }

            for(int i=0;i<arrayListListeningPart3Question.size();i++)
                listRightAnswer.add(arrayListListeningPart3Question.get(i).getRightAnswer());

        //


            randomIdx = rand.nextInt(arrayListListeningPart4.size());
            im = arrayListListeningPart4.get(randomIdx);
            arrayResultListListeningPart4.add(im);
            arrayListListeningPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart4Question.size() - countPart4; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart4Question.size());
                arrayListListeningPart4Question.remove(randomIndex);

            }
            for(int i=0;i<arrayListListeningPart4Question.size();i++)
                listRightAnswer.add(arrayListListeningPart4Question.get(i).getRightAnswer());




            randomIdx = rand.nextInt(arrayListReadingPart1.size());
            im = arrayListReadingPart1.get(randomIdx);
            arrayResultListReadingPart1.add(im);
            arrayListReadingPart1Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart1Question.size() - countPart5; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart1Question.size());
                arrayListReadingPart1Question.remove(randomIndex);

            }
            for(int i=0;i<arrayListReadingPart1Question.size();i++)
                listRightAnswer.add(arrayListReadingPart1Question.get(i).getRightAnswer());



            randomIdx = rand.nextInt(arrayListReadingPart2.size());
            im = arrayListReadingPart2.get(randomIdx);
            arrayResultListReadingPart2.add(im);
            arrayListReadingPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart2Question.size() - countPart6; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart2Question.size());
                arrayListReadingPart2Question.remove(randomIndex);

            }
            for(int i=0;i<arrayListReadingPart2Question.size();i++)
                listRightAnswer.add(arrayListReadingPart2Question.get(i).getRightAnswer());



            randomIdx = rand.nextInt(arrayListReadingPart3.size());
            im = arrayListReadingPart3.get(randomIdx);
            arrayResultListReadingPart3.add(im);
            arrayListReadingPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart3Question.size() - countPart7; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart3Question.size());
                arrayListReadingPart3Question.remove(randomIndex);

            }
            for(int i=0;i<arrayListReadingPart3Question.size();i++)
                listRightAnswer.add(arrayListReadingPart3Question.get(i).getRightAnswer());



            randomIdx = rand.nextInt(arrayListReadingPart4.size());
            im = arrayListReadingPart4.get(randomIdx);
            arrayResultListReadingPart4.add(im);
            arrayListReadingPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart4Question.size() - countPart8; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart4Question.size());
                arrayListReadingPart4Question.remove(randomIndex);

            }
            for(int i=0;i<arrayListReadingPart4Question.size();i++)
                listRightAnswer.add(arrayListReadingPart4Question.get(i).getRightAnswer());


        adapterListeningP1 = new OnNgauNhienAdapter(this, R.layout.question_form_listening_p1, arrayResultListListeningPart1, arrayListListeningPart1Info);
        adapterListeningP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart2Question);
        adapterListeningP3 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart3Question);
        adapterListeningP4 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart4Question);
        adapterReadingP1 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart1Question);
        adapterReadingP2 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart2Question);
        adapterReadingP3 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart3Question);
        adapterReadingP4 = new OnNgauNhienAdapter2(this,R.layout.question_form_02,arrayListReadingPart4Question);

    }
    private void checkAnswer()
    {
        listAnswer.clear();
        countResult=0;

        listAnswer.addAll(adapterListeningP1.getListAnswer());
        listAnswer.addAll(adapterListeningP2.getListAnswer());
        listAnswer.addAll(adapterListeningP3.getListAnswer());
        listAnswer.addAll(adapterListeningP4.getListAnswer());
        listAnswer.addAll(adapterReadingP1.getListAnswer());
        listAnswer.addAll(adapterReadingP2.getListAnswer());
        listAnswer.addAll(adapterReadingP3.getListAnswer());
        listAnswer.addAll(adapterReadingP4.getListAnswer());


        for(int i=0;i<listAnswer.size();i++)
        {
            if(listAnswer.get(i).equals(listRightAnswer.get(i)))
            {
                countResult=countResult+1;
            }
        }


    }
    void showDialogResult()
    {
        myTimer.cancel();
        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("HOÀN THÀNH");
        b.setMessage("Bạn có "+String.valueOf(countResult)+"/70" +" câu trả lời đúng");
        b.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog al = b.create();
        al.show();
        isTimerFinish=true;

    }
    void showDialogTimeFinish()
    {

        AlertDialog.Builder b = new AlertDialog.Builder(this);

        b.setTitle("HẾT GIỜ");
        b.setMessage("Bạn đã hết thời gian, bạn có "+String.valueOf(countResult)+"/70" +" câu trả lời đúng");
        b.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });

        AlertDialog al = b.create();
        al.show();

        isTimerFinish=true;

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
    protected void onPause() {
        super.onPause();
        if (player!=null) player.stop();
    }

    private static void setViewAndChildrenEnabled(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                setViewAndChildrenEnabled(child, enabled);
            }
        }
    }

}