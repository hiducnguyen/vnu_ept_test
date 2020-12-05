package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LuaChonCauHoi extends AppCompatActivity {
    EditText edtPart1, edtPart2, edtPart3, edtPart4, edtPart5, edtPart6;
    Button btnTT;
    private Context context;
    private Bundle myBundle;

    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lua_chon_cau_hoi);
        context=this;

        setView();
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(LuaChonCauHoi.this,OnNgauNhien.class);
                startActivities(new Intent[]{myIntent});


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
        btnTT=(Button)findViewById(R.id.btnTT);

    }
}