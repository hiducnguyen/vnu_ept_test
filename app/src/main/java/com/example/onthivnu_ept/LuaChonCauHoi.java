package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LuaChonCauHoi extends Activity {
    EditText edtPart1, edtPart2, edtPart3, edtPart4, edtPart5, edtPart6, edtPart7,edtPart8;
    Button btnTT;
    private Context context;
    private Bundle myBundle;

    private DataBaseHelper dataBaseHelper=new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lua_chon_cau_hoi);
        context=this;

        setView();
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int maxCount1=dataBaseHelper.countIdByPart(1,"Listening");
                int maxCount2=6;
                int maxCount3=8;
                int maxCount4=6;
                int maxCountReading1=20;
                int maxCountReading2=6;
                int maxCountReading3=7;
                int maxCountReading4=7;


                int countListeningPart1=Integer.parseInt(edtPart1.getText().toString());
                int countListeningPart2=Integer.parseInt(edtPart2.getText().toString());
                int countListeningPart3=Integer.parseInt(edtPart3.getText().toString());
                int countListeningPart4=Integer.parseInt(edtPart4.getText().toString());
                int countReadingPart1=Integer.parseInt(edtPart5.getText().toString());
                int countReadingPart2=Integer.parseInt(edtPart6.getText().toString());
                int countReadingPart3=Integer.parseInt(edtPart7.getText().toString());
                int countReadingPart4=Integer.parseInt(edtPart8.getText().toString());

                boolean isValid=(countListeningPart1<=maxCount1)&&(countListeningPart2<=maxCount2)&&(countListeningPart3<=maxCount3)
                        &&(countListeningPart4<=maxCount4)&&(countReadingPart1<=maxCountReading1)&&(countReadingPart2<=maxCountReading2)
                        &&(countReadingPart3<=maxCountReading3)&&(countReadingPart4<=maxCountReading4)
                        &&((countListeningPart1>0)||(countListeningPart2>0)||(countListeningPart3>0)
                        ||(countListeningPart4>0)||(countReadingPart1>0)||(countReadingPart2>0)||(countReadingPart3>0)||(countReadingPart4>0));

                if(isValid)
                {
                    Intent myIntent = new Intent(LuaChonCauHoi.this,OnNgauNhien.class);
                    Bundle myBundle=new Bundle();
                    myBundle.putInt("countListeningPart1",countListeningPart1);
                    myBundle.putInt("countListeningPart2",countListeningPart2);
                    myBundle.putInt("countListeningPart3",countListeningPart3);
                    myBundle.putInt("countListeningPart4",countListeningPart4);
                    myBundle.putInt("countReadingPart1",countReadingPart1);
                    myBundle.putInt("countReadingPart2",countReadingPart2);
                    myBundle.putInt("countReadingPart3",countReadingPart3);
                    myBundle.putInt("countReadingPart4",countReadingPart4);

                    myIntent.putExtras(myBundle);
                    startActivities(new Intent[]{myIntent});
                }

            }
        });


    }

    private void setView()
    {
        edtPart1=(EditText)findViewById(R.id.edtPart1);
        edtPart2=(EditText)findViewById(R.id.edtPart2);
        edtPart3=(EditText)findViewById(R.id.edtPart3);
        edtPart4=(EditText)findViewById(R.id.edtPart4);
        edtPart5=(EditText)findViewById(R.id.edtPart5);
        edtPart6=(EditText)findViewById(R.id.edtPart6);
        edtPart7=(EditText)findViewById(R.id.edtPart7);
        edtPart8=(EditText)findViewById(R.id.edtPart8);
        btnTT=(Button)findViewById(R.id.btnTT);

    }


}