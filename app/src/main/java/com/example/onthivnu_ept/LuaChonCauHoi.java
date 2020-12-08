package com.example.onthivnu_ept;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LuaChonCauHoi extends Activity {
    EditText edtPart1, edtPart2, edtPart3, edtPart4, edtPart5, edtPart6, edtPart7, edtPart8;
    Button btnTT;
    private Context context;

    int maxCount1, maxCount2, maxCount3, maxCount4,
            maxCountReading1, maxCountReading2, maxCountReading3, maxCountReading4,
            countListeningPart1, countListeningPart2, countListeningPart3, countListeningPart4,
            countReadingPart1, countReadingPart2, countReadingPart3, countReadingPart4;
    private DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lua_chon_cau_hoi);
        context = this;

        setView();
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maxCount1 = dataBaseHelper.countIdByPart(1, "Listening");
                maxCount2 = 6;
                maxCount3 = 8;
                maxCount4 = 6;
                maxCountReading1 = 20;
                maxCountReading2 = 6;
                maxCountReading3 = 7;
                maxCountReading4 = 7;


                countListeningPart1 = Integer.parseInt(edtPart1.getText().toString());
                countListeningPart2 = Integer.parseInt(edtPart2.getText().toString());
                countListeningPart3 = Integer.parseInt(edtPart3.getText().toString());
                countListeningPart4 = Integer.parseInt(edtPart4.getText().toString());
                countReadingPart1 = Integer.parseInt(edtPart5.getText().toString());
                countReadingPart2 = Integer.parseInt(edtPart6.getText().toString());
                countReadingPart3 = Integer.parseInt(edtPart7.getText().toString());
                countReadingPart4 = Integer.parseInt(edtPart8.getText().toString());


                boolean isValid = (countListeningPart1 <= maxCount1) && (countListeningPart2 <= maxCount2) && (countListeningPart3 <= maxCount3)
                        && (countListeningPart4 <= maxCount4) && (countReadingPart1 <= maxCountReading1) && (countReadingPart2 <= maxCountReading2)
                        && (countReadingPart3 <= maxCountReading3) && (countReadingPart4 <= maxCountReading4)
                        && (countListeningPart1 + countListeningPart2 + countListeningPart3 + countListeningPart4
                        + countReadingPart1 + countReadingPart2 + countReadingPart3 + countReadingPart4 > 0);
                if (isValid) {
                    Intent myIntent = new Intent(LuaChonCauHoi.this, OnNgauNhien.class);
                    Bundle myBundle = new Bundle();
                    myBundle.putInt("countListeningPart1", countListeningPart1);
                    myBundle.putInt("countListeningPart2", countListeningPart2);
                    myBundle.putInt("countListeningPart3", countListeningPart3);
                    myBundle.putInt("countListeningPart4", countListeningPart4);
                    myBundle.putInt("countReadingPart1", countReadingPart1);
                    myBundle.putInt("countReadingPart2", countReadingPart2);
                    myBundle.putInt("countReadingPart3", countReadingPart3);
                    myBundle.putInt("countReadingPart4", countReadingPart4);

                    myIntent.putExtras(myBundle);
                    startActivities(new Intent[]{myIntent});
                } else ShowDialogTryAgain();

            }
        });


    }

    private void setView() {
        edtPart1 = (EditText) findViewById(R.id.edtPart1);
        edtPart2 = (EditText) findViewById(R.id.edtPart2);
        edtPart3 = (EditText) findViewById(R.id.edtPart3);
        edtPart4 = (EditText) findViewById(R.id.edtPart4);
        edtPart5 = (EditText) findViewById(R.id.edtPart5);
        edtPart6 = (EditText) findViewById(R.id.edtPart6);
        edtPart7 = (EditText) findViewById(R.id.edtPart7);
        edtPart8 = (EditText) findViewById(R.id.edtPart8);
        btnTT = (Button) findViewById(R.id.btnTT);

    }

    public void ShowDialogTryAgain() {
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
        String str = "";

        if (!((countListeningPart1 <= maxCount1) && (countListeningPart1 > 0)))
            str += "Số lượng câu hỏi Listening Part 1: 1-" + String.valueOf(maxCount1) + "\n";
        if (!((countListeningPart2 <= maxCount2) && (countListeningPart2 > 0)))
            str += "Số lượng câu hỏi Listening Part 2: 1-" + String.valueOf(maxCount2) + "\n";
        if (!((countListeningPart3 <= maxCount3) && (countListeningPart3 > 0)))
            str += "Số lượng câu hỏi Listening Part 3: 1-" + String.valueOf(maxCount3) + "\n";
        if (!((countListeningPart4 <= maxCount4) && (countListeningPart4 > 0)))
            str += "Số lượng câu hỏi Listening Part 4: 1-" + String.valueOf(maxCount4) + "\n";
        if (!((countReadingPart1 <= maxCountReading1) && (countReadingPart1 > 0)))
            str += "Số lượng câu hỏi Reading Part 1: 1-" + String.valueOf(maxCountReading1) + "\n";
        if (!((countReadingPart2 <= maxCountReading2) && (countReadingPart2 > 0)))
            str += "Số lượng câu hỏi Reading Part 2: 1-" + String.valueOf(maxCountReading2) + "\n";
        if (!((countReadingPart3 <= maxCountReading3) && (countReadingPart3 > 0)))
            str += "Số lượng câu hỏi Reading Part 3: 1-" + String.valueOf(maxCountReading3) + "\n";
        if (!((countReadingPart4 <= maxCountReading4) && (countReadingPart4 > 0)))
            str += "Số lượng câu hỏi Reading Part 4: 1-" + String.valueOf(maxCountReading4);

        myBuilder.setMessage(str)
                .setPositiveButton("Close", null)
                .show();
    }

}