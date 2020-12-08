package com.example.onthivnu_ept;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class OnNgauNhien extends Activity {

    MediaPlayer player;


    ListView listListeningPart1, listListeningPart2, listListeningPart3, listListeningPart4,
            listReadingPart1, listReadingPart2, listReadingPart3, listReadingPart4;

    private int countListeningPart1;
    private int countListeningPart2;
    private int countListeningPart3;
    private int countListeningPart4;
    private int countReadingPart1;
    private int countReadingPart2;
    private int countReadingPart3;
    private int countReadingPart4;

    ArrayList<QuestionModel> arrayListListeningPart1;
    ArrayList<InforModel> arrayListListeningPart2;
    ArrayList<InforModel> arrayListListeningPart3;
    ArrayList<InforModel> arrayListListeningPart4;
    ArrayList<InforModel> arrayListReadingPart1;
    ArrayList<InforModel> arrayListReadingPart2;
    ArrayList<InforModel> arrayListReadingPart3;
    ArrayList<InforModel> arrayListReadingPart4;

    ArrayList<InforModel> arrayListListeningPart1Info = new ArrayList<>();
    ArrayList<QuestionModel> arrayListListeningPart2Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListListeningPart3Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListListeningPart4Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListReadingPart1Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListReadingPart2Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListReadingPart3Question = new ArrayList<>();
    ArrayList<QuestionModel> arrayListReadingPart4Question = new ArrayList<>();

    ArrayList<QuestionModel> arrayResultListListeningPart1 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListListeningPart2 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListListeningPart3 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListListeningPart4 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListReadingPart1 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListReadingPart2 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListReadingPart3 = new ArrayList<>();
    ArrayList<InforModel> arrayResultListReadingPart4 = new ArrayList<>();

    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    OnNgauNhienAdapter adapterListeningP1;
    OnNgauNhienAdapter2 adapterListeningP2, adapterListeningP3, adapterListeningP4,
            adapterReadingP1, adapterReadingP2, adapterReadingP3, adapterReadingP4;

    Context context;

    Button btnNext1, btnPrevious1;
    Button btnNext2, btnPrevious2;
    Button btnNext3, btnPrevious3;
    Button btnNext4, btnPrevious4;
    Button btnNext5, btnPrevious5;
    Button btnNext6, btnPrevious6;
    Button btnNext7, btnPrevious7;
    Button btnNext8, btnPrevious8;
    int sumQuestion;

    Button btnKT1, btnKT2, btnKT3, btnKT4, btnKT5, btnKT6, btnKT7, btnKT8;

    ImageView imgP2, imgP3, imgP4;
    TextView txtP4tn, txtP5tn, txtP6tn, txtP7tn, txtP8tn;

    int countResult = 0;
    ArrayList<String> listRightAnswer;

    ArrayList<String> listAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent myInten = getIntent();
        Bundle myBundle = myInten.getExtras();

        countListeningPart1 = myBundle.getInt("countListeningPart1");
        countListeningPart2 = myBundle.getInt("countListeningPart2");
        countListeningPart3 = myBundle.getInt("countListeningPart3");
        countListeningPart4 = myBundle.getInt("countListeningPart4");
        countReadingPart1 = myBundle.getInt("countReadingPart1");
        countReadingPart2 = myBundle.getInt("countReadingPart2");
        countReadingPart3 = myBundle.getInt("countReadingPart3");
        countReadingPart4 = myBundle.getInt("countReadingPart4");
        sumQuestion = countListeningPart1 + countListeningPart2 + countListeningPart3 +
                countListeningPart4 + countReadingPart1 + countReadingPart2 + countReadingPart3 + countReadingPart4;

        initDataOfLists();
        randomQuestion();

        if (countListeningPart1 > 0)
            doPart1();
        else if (countListeningPart2 > 0)
            doPart2();
        else if (countListeningPart3 > 0)
            doPart3();
        else if (countListeningPart4 > 0)
            doPart4();
        else if (countReadingPart1 > 0)
            doPart5();
        else if (countReadingPart2 > 0)
            doPart6();
        else if (countReadingPart3 > 0)
            doPart7();
        else if (countReadingPart4 > 0)
            doPart8();

    }

    private void doPart1() {

        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_listening_p1);
        context = OnNgauNhien.this;
        listListeningPart1 = (ListView) findViewById(R.id.list1);

        btnNext1 = (Button) findViewById(R.id.btnNextONN1);
        btnPrevious1 = (Button) findViewById(R.id.btnPreviousONN1);


        if (adapterListeningP1 == null)
            adapterListeningP1 = new OnNgauNhienAdapter(this, R.layout.question_form_listening_p1, arrayResultListListeningPart1, arrayListListeningPart1Info);

        listListeningPart1.setAdapter(adapterListeningP1);

        listListeningPart1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

            }
        });
        btnKT1 = (Button) findViewById(R.id.btnKT1);
        btnKT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (adapterListeningP1.getPlayer() != null) adapterListeningP1.player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        btnPrevious1.setEnabled(false);
        if (sumQuestion - countListeningPart1 == 0) {

            btnNext1.setEnabled(false);
        } else {

            btnNext1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player = adapterListeningP1.getPlayer();
                    if (countListeningPart2 > 0)
                        doPart2();
                    else if (countListeningPart3 > 0)
                        doPart3();
                    else if (countListeningPart4 > 0)
                        doPart4();
                    else if (countReadingPart1 > 0)
                        doPart5();
                    else if (countReadingPart2 > 0)
                        doPart6();
                    else if (countReadingPart3 > 0)
                        doPart7();
                    else if (countReadingPart4 > 0)
                        doPart8();
                }
            });
        }
    }

    private void doPart2() {
        if (player != null) player.stop();

        setContentView(R.layout.on_ngau_nhien_layout_listening_p2);
        context = OnNgauNhien.this;

        btnNext2 = (Button) findViewById(R.id.btnNextONN2);
        btnPrevious2 = (Button) findViewById(R.id.btnPreviousONN2);


        imgP2 = (ImageView) findViewById(R.id.imageONN2tn);
        listListeningPart2 = (ListView) findViewById(R.id.list2);

        if (adapterListeningP2 == null)
            adapterListeningP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart2Question);

        listListeningPart2.setAdapter(adapterListeningP2);
        imgP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(context, arrayResultListListeningPart2.get(0).getListeningInfor());
            }
        });

        btnKT2 = (Button) findViewById(R.id.btnKT2);
        btnKT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        if (sumQuestion - countListeningPart2 == 0) {
            btnNext2.setEnabled(false);
            btnPrevious2.setEnabled(false);
        } else {
            if (sumQuestion - countListeningPart1 - countListeningPart2 > 0) {
                btnNext2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countListeningPart3 > 0)
                            doPart3();
                        else if (countListeningPart4 > 0)
                            doPart4();
                        else if (countReadingPart1 > 0)
                            doPart5();
                        else if (countReadingPart2 > 0)
                            doPart6();
                        else if (countReadingPart3 > 0)
                            doPart7();
                        else if (countReadingPart4 > 0)
                            doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext2.setEnabled(false);
            }
            //
            if (countListeningPart1 > 0) {

                btnPrevious2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        doPart1();
                    }
                });
            } else {
                btnPrevious2.setEnabled(false);
            }
        }
    }

    private void doPart3() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_listening_p3);
        context = OnNgauNhien.this;

        btnNext3 = (Button) findViewById(R.id.btnNextONN3);
        btnPrevious3 = (Button) findViewById(R.id.btnPreviousONN3);
        imgP3 = (ImageView) findViewById(R.id.imageONN3tn);
        listListeningPart3 = (ListView) findViewById(R.id.list3);

        if (adapterListeningP3 == null)
            adapterListeningP3 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart3Question);

        listListeningPart3.setAdapter(adapterListeningP3);
        imgP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(context, arrayResultListListeningPart3.get(0).getListeningInfor());
            }
        });
        btnKT3 = (Button) findViewById(R.id.btnKT3);
        btnKT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });


        if (sumQuestion - countListeningPart3 == 0) {
            //btnKT
            btnNext3.setEnabled(false);
            btnPrevious3.setEnabled(false);
        } else {
            if (sumQuestion - countListeningPart1 - countListeningPart2 - countListeningPart3 > 0) {
                btnNext3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countListeningPart4 > 0)
                            doPart4();
                        else if (countReadingPart1 > 0)
                            doPart5();
                        else if (countReadingPart2 > 0)
                            doPart6();
                        else if (countReadingPart3 > 0)
                            doPart7();
                        else if (countReadingPart4 > 0)
                            doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext3.setEnabled(false);
            }
            //
            if (countListeningPart1 + countListeningPart2 > 0) {

                btnPrevious3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countListeningPart2 > 0)
                            doPart2();
                        else if (countListeningPart1 > 0)
                            doPart1();
                    }
                });
            } else {
                btnPrevious3.setEnabled(false);
            }
        }
    }

    private void doPart4() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_listening_p4);
        context = OnNgauNhien.this;

        btnNext4 = (Button) findViewById(R.id.btnNextONN4);
        btnPrevious4 = (Button) findViewById(R.id.btnPreviousONN4);
        imgP4 = (ImageView) findViewById(R.id.imageONN4tn);
        txtP4tn = (TextView) findViewById(R.id.txtONNP4tn);
        txtP4tn.setText(arrayResultListListeningPart4.get(0).getReadingInfor());
        listListeningPart4 = (ListView) findViewById(R.id.list4);

        if (adapterListeningP4 == null)
            adapterListeningP4 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart4Question);
        listListeningPart4.setAdapter(adapterListeningP4);

        imgP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play(context, arrayResultListListeningPart4.get(0).getListeningInfor());
            }
        });
        btnKT4 = (Button) findViewById(R.id.btnKT1);
        btnKT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        if (sumQuestion - countListeningPart4 == 0) {
            //btnKT
            btnNext4.setEnabled(false);
            btnPrevious4.setEnabled(false);
        } else {
            if (countReadingPart1 + countReadingPart2 + countReadingPart3 + countReadingPart4 > 0) {
                btnNext4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countReadingPart1 > 0)
                            doPart5();
                        else if (countReadingPart2 > 0)
                            doPart6();
                        else if (countReadingPart3 > 0)
                            doPart7();
                        else if (countReadingPart4 > 0)
                            doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext4.setEnabled(false);
            }
            //
            if (countListeningPart1 + countListeningPart2 + countListeningPart3 > 0) {

                btnPrevious4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countListeningPart3 > 0)
                            doPart3();
                        else if (countListeningPart2 > 0)
                            doPart2();
                        else if (countListeningPart1 > 0)
                            doPart1();
                    }
                });
            } else {
                btnPrevious4.setEnabled(false);
            }
        }
    }

    private void doPart5() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_reading);
        context = OnNgauNhien.this;

        btnNext5 = (Button) findViewById(R.id.btnNextONN5);
        btnPrevious5 = (Button) findViewById(R.id.btnPreviousONN5);
        txtP5tn = (TextView) findViewById(R.id.txtONNP5tn);
        txtP5tn.setText(arrayResultListReadingPart1.get(0).getReadingInfor());

        listReadingPart1 = (ListView) findViewById(R.id.list5);

        if (adapterReadingP1 == null)
            adapterReadingP1 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart1Question);
        listReadingPart1.setAdapter(adapterReadingP1);

        btnKT5 = (Button) findViewById(R.id.btnKT5);
        btnKT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        if (sumQuestion - countReadingPart1 == 0) {
            //btnKT
            btnNext5.setEnabled(false);
            btnPrevious5.setEnabled(false);
        } else {
            if (countReadingPart2 + countReadingPart3 + countReadingPart4 > 0) {
                btnNext5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countReadingPart2 > 0)
                            doPart6();
                        else if (countReadingPart3 > 0)
                            doPart7();
                        else if (countReadingPart4 > 0)
                            doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext5.setEnabled(false);
            }
            //
            if (countListeningPart1 + countListeningPart2 + countListeningPart3 + countListeningPart4 > 0) {

                btnPrevious5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countListeningPart4 > 0)
                            doPart4();
                        else if (countListeningPart3 > 0)
                            doPart3();
                        else if (countListeningPart2 > 0)
                            doPart2();
                        else if (countListeningPart1 > 0)
                            doPart1();
                    }
                });
            } else {
                btnPrevious5.setEnabled(false);
            }
        }
    }

    private void doPart6() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_reading_p2);
        context = OnNgauNhien.this;

        btnNext6 = (Button) findViewById(R.id.btnNextONN6);
        btnPrevious6 = (Button) findViewById(R.id.btnPreviousONN6);
        txtP6tn = (TextView) findViewById(R.id.txtONNP6tn);
        txtP6tn.setText(arrayResultListReadingPart2.get(0).getReadingInfor());

        listReadingPart2 = (ListView) findViewById(R.id.list6);

        if (adapterReadingP2 == null)
            adapterReadingP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart2Question);
        listReadingPart2.setAdapter(adapterReadingP2);

        btnKT6 = (Button) findViewById(R.id.btnKT6);
        btnKT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        if (sumQuestion - countReadingPart2 == 0) {
            //btnKT
            btnNext6.setEnabled(false);
            btnPrevious6.setEnabled(false);
        } else {
            if (countReadingPart3 + countReadingPart4 > 0) {
                btnNext6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (countReadingPart3 > 0)
                            doPart7();
                        else if (countReadingPart4 > 0)
                            doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext6.setEnabled(false);
            }
            //
            if (countListeningPart1 + countListeningPart2 + countListeningPart3 + countListeningPart4 + countReadingPart1 > 0) {

                btnPrevious6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (countReadingPart1 > 0)
                            doPart5();
                        else if (countListeningPart4 > 0)
                            doPart4();
                        else if (countListeningPart3 > 0)
                            doPart3();
                        else if (countListeningPart2 > 0)
                            doPart2();
                        else if (countListeningPart1 > 0)
                            doPart1();
                    }
                });
            } else {
                btnPrevious6.setEnabled(false);
            }
        }
    }

    private void doPart7() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_reading_p3);
        context = OnNgauNhien.this;

        btnNext7 = (Button) findViewById(R.id.btnNextONN7);
        btnPrevious7 = (Button) findViewById(R.id.btnPreviousONN7);
        txtP7tn = (TextView) findViewById(R.id.txtONNP7tn);
        txtP7tn.setText(arrayResultListReadingPart3.get(0).getReadingInfor());

        listReadingPart3 = (ListView) findViewById(R.id.list7);

        if (adapterReadingP3 == null)
            adapterReadingP3 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart3Question);
        listReadingPart3.setAdapter(adapterReadingP3);

        btnKT7 = (Button) findViewById(R.id.btnKT7);
        btnKT7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        if (sumQuestion - countReadingPart3 == 0) {
            //btnKT
            btnNext7.setEnabled(false);
            btnPrevious7.setEnabled(false);
        } else {
            if (countReadingPart4 > 0) {
                btnNext7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doPart8();
                    }
                });
            } else {
                //btnKt
                btnNext7.setEnabled(false);
            }
            //
            if (sumQuestion - countReadingPart3 - countReadingPart4 > 0) {

                btnPrevious7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (countReadingPart2 > 0)
                            doPart6();
                        else if (countReadingPart1 > 0)
                            doPart5();
                        else if (countListeningPart4 > 0)
                            doPart4();
                        else if (countListeningPart3 > 0)
                            doPart3();
                        else if (countListeningPart2 > 0)
                            doPart2();
                        else if (countListeningPart1 > 0)
                            doPart1();
                    }
                });
            } else {
                btnPrevious7.setEnabled(false);
            }
        }
    }

    private void doPart8() {
        if (player != null) player.stop();
        setContentView(R.layout.on_ngau_nhien_layout_reading_p4);
        context = OnNgauNhien.this;

        btnNext8 = (Button) findViewById(R.id.btnNextONN8);
        btnPrevious8 = (Button) findViewById(R.id.btnPreviousONN8);
        txtP8tn = (TextView) findViewById(R.id.txtONNP8tn);
        txtP8tn.setText(arrayResultListReadingPart4.get(0).getReadingInfor());

        listReadingPart4 = (ListView) findViewById(R.id.list8);

        if (adapterReadingP4 == null)
            adapterReadingP4 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart4Question);
        listReadingPart4.setAdapter(adapterReadingP4);
        btnKT8 = (Button) findViewById(R.id.btnKT8);
        btnKT8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (player != null) player.stop();
                checkAnswer();
                showDialogResult();
            }
        });

        btnNext8.setEnabled(false);

        if (sumQuestion - countReadingPart4 == 0) {
            btnPrevious8.setEnabled(false);
        } else {
            btnPrevious8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (countReadingPart3 > 0)
                        doPart7();
                    else if (countReadingPart2 > 0)
                        doPart6();
                    else if (countReadingPart1 > 0)
                        doPart5();
                    else if (countListeningPart4 > 0)
                        doPart4();
                    else if (countListeningPart3 > 0)
                        doPart3();
                    else if (countListeningPart2 > 0)
                        doPart2();
                    else if (countListeningPart1 > 0)
                        doPart1();
                }
            });
        }


    }

    private void checkAnswer() {
        listAnswer.clear();
        countResult = 0;

        if (countListeningPart1 > 0)
            listAnswer.addAll(adapterListeningP1.getListAnswer());
        if (countListeningPart2 > 0)
            listAnswer.addAll(adapterListeningP2.getListAnswer());
        if (countListeningPart3 > 0)
            listAnswer.addAll(adapterListeningP3.getListAnswer());
        if (countListeningPart4 > 0)
            listAnswer.addAll(adapterListeningP4.getListAnswer());
        if (countReadingPart1 > 0)
            listAnswer.addAll(adapterReadingP1.getListAnswer());
        if (countReadingPart2 > 0)
            listAnswer.addAll(adapterReadingP2.getListAnswer());
        if (countReadingPart3 > 0)
            listAnswer.addAll(adapterReadingP3.getListAnswer());
        if (countReadingPart4 > 0)
            listAnswer.addAll(adapterReadingP4.getListAnswer());


        String s1 = "", s2 = "";
        for (int i = 0; i < listAnswer.size(); i++)
            s1 = s1 + listAnswer.get(i);
        for (int i = 0; i < listRightAnswer.size(); i++)
            s2 = s2 + listRightAnswer.get(i);
        Toast.makeText(context, "List1" + s1 + "  List2" + s2, Toast.LENGTH_LONG).show();


        for (int i = 0; i < listAnswer.size(); i++) {
            if (listAnswer.get(i).equals(listRightAnswer.get(i))) {
                countResult = countResult + 1;
            }
        }


    }

    void showDialogResult() {
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(context);

        myBuilder.setMessage("Bạn có " + String.valueOf(countResult) + "/" + String.valueOf(sumQuestion) + " câu trả lời đúng")
                .setPositiveButton("Close", null)
                .show();
    }


    private void initDataOfLists() {
        arrayListListeningPart1 = new ArrayList<>(dataBaseHelper.findQuestionByPart(1, "Listening"));
        arrayListListeningPart2 = new ArrayList<>(dataBaseHelper.findInforByPart(2, "Listening"));
        arrayListListeningPart3 = new ArrayList<>(dataBaseHelper.findInforByPart(3, "Listening"));
        arrayListListeningPart4 = new ArrayList<>(dataBaseHelper.findInforByPart(4, "Listening"));

        arrayListReadingPart1 = new ArrayList<>();

        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(11, "Reading"));
        arrayListReadingPart1.addAll(dataBaseHelper.findInforByPart(12, "Reading"));
        arrayListReadingPart2 = new ArrayList<>(dataBaseHelper.findInforByPart(2, "Reading"));
        arrayListReadingPart3 = new ArrayList<>(dataBaseHelper.findInforByPart(3, "Reading"));
        arrayListReadingPart4 = new ArrayList<>(dataBaseHelper.findInforByPart(4, "Reading"));


        listRightAnswer = new ArrayList<>();
        listAnswer = new ArrayList<>();
        countResult = 0;


    }


    private void randomQuestion() {
        Random rand = new Random();
        InforModel im;
        int randomIdx;
        if (countListeningPart1 > 0) {
            for (int i = 0; i < countListeningPart1; i++) {
                int randomIndex = rand.nextInt(arrayListListeningPart1.size());
                QuestionModel ques = arrayListListeningPart1.get(randomIndex);
                arrayResultListListeningPart1.add(ques);

                listRightAnswer.add(ques.getRightAnswer());

                arrayListListeningPart1Info.add(dataBaseHelper.findInforById(ques.getIdInfor()));
                arrayListListeningPart1.remove(randomIndex);
            }

        }

        //
        if (countListeningPart2 > 0) {
            randomIdx = rand.nextInt(arrayListListeningPart2.size());
            im = arrayListListeningPart2.get(randomIdx);
            arrayResultListListeningPart2.add(im);
            arrayListListeningPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));


            for (int i = 0; i < arrayListListeningPart2Question.size() - countListeningPart2; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart2Question.size());
                arrayListListeningPart2Question.remove(randomIndex);
            }

            for (int i = 0; i < arrayListListeningPart2Question.size(); i++)
                listRightAnswer.add(arrayListListeningPart2Question.get(i).getRightAnswer());
        }
        //
        if (countListeningPart3 > 0) {

            randomIdx = rand.nextInt(arrayListListeningPart3.size());
            im = arrayListListeningPart3.get(randomIdx);
            arrayResultListListeningPart3.add(im);
            arrayListListeningPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart3Question.size() - countListeningPart3; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart3Question.size());
                arrayListListeningPart3Question.remove(randomIndex);

            }

            for (int i = 0; i < arrayListListeningPart3Question.size(); i++)
                listRightAnswer.add(arrayListListeningPart3Question.get(i).getRightAnswer());
        }
        //
        if (countListeningPart4 > 0) {

            randomIdx = rand.nextInt(arrayListListeningPart4.size());
            im = arrayListListeningPart4.get(randomIdx);
            arrayResultListListeningPart4.add(im);
            arrayListListeningPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListListeningPart4Question.size() - countListeningPart4; ) {
                int randomIndex = rand.nextInt(arrayListListeningPart4Question.size());
                arrayListListeningPart4Question.remove(randomIndex);

            }
            for (int i = 0; i < arrayListListeningPart4Question.size(); i++)
                listRightAnswer.add(arrayListListeningPart4Question.get(i).getRightAnswer());
        }

        if (countReadingPart1 > 0) {

            randomIdx = rand.nextInt(arrayListReadingPart1.size());
            im = arrayListReadingPart1.get(randomIdx);
            arrayResultListReadingPart1.add(im);
            arrayListReadingPart1Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart1Question.size() - countReadingPart1; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart1Question.size());
                arrayListReadingPart1Question.remove(randomIndex);

            }
            for (int i = 0; i < arrayListReadingPart1Question.size(); i++)
                listRightAnswer.add(arrayListReadingPart1Question.get(i).getRightAnswer());
        }
        if (countReadingPart2 > 0) {

            randomIdx = rand.nextInt(arrayListReadingPart2.size());
            im = arrayListReadingPart2.get(randomIdx);
            arrayResultListReadingPart2.add(im);
            arrayListReadingPart2Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart2Question.size() - countReadingPart2; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart2Question.size());
                arrayListReadingPart2Question.remove(randomIndex);

            }
            for (int i = 0; i < arrayListReadingPart2Question.size(); i++)
                listRightAnswer.add(arrayListReadingPart2Question.get(i).getRightAnswer());
        }

        if (countReadingPart3 > 0) {
            randomIdx = rand.nextInt(arrayListReadingPart3.size());
            im = arrayListReadingPart3.get(randomIdx);
            arrayResultListReadingPart3.add(im);
            arrayListReadingPart3Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart3Question.size() - countReadingPart3; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart3Question.size());
                arrayListReadingPart3Question.remove(randomIndex);

            }
            for (int i = 0; i < arrayListReadingPart3Question.size(); i++)
                listRightAnswer.add(arrayListReadingPart3Question.get(i).getRightAnswer());
        }
        if (countReadingPart4 > 0) {

            randomIdx = rand.nextInt(arrayListReadingPart4.size());
            im = arrayListReadingPart4.get(randomIdx);
            arrayResultListReadingPart4.add(im);
            arrayListReadingPart4Question.addAll(dataBaseHelper.findQuestionById(im.getId()));

            for (int i = 0; i < arrayListReadingPart4Question.size() - countReadingPart4; ) {
                int randomIndex = rand.nextInt(arrayListReadingPart4Question.size());
                arrayListReadingPart4Question.remove(randomIndex);

            }
            for (int i = 0; i < arrayListReadingPart4Question.size(); i++)
                listRightAnswer.add(arrayListReadingPart4Question.get(i).getRightAnswer());
        }
        if (countListeningPart1 > 0)
            adapterListeningP1 = new OnNgauNhienAdapter(this, R.layout.question_form_listening_p1, arrayResultListListeningPart1, arrayListListeningPart1Info);
        if (countListeningPart2 > 0)
            adapterListeningP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart2Question);
        if (countListeningPart3 > 0)
            adapterListeningP3 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart3Question);
        if (countListeningPart4 > 0)
            adapterListeningP4 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListListeningPart4Question);

        if (countReadingPart1 > 0)
            adapterReadingP1 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart1Question);
        if (countReadingPart2 > 0)
            adapterReadingP2 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart2Question);
        if (countReadingPart3 > 0)
            adapterReadingP3 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart3Question);
        if (countReadingPart4 > 0)
            adapterReadingP4 = new OnNgauNhienAdapter2(this, R.layout.question_form_02, arrayListReadingPart4Question);
    }

    void play(Context context, int resource) {

        if (player != null) {
            player.release();
            player = null;
        }
        player = MediaPlayer.create(context, resource);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                player.release();
                player = null;
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) player.stop();
    }


}