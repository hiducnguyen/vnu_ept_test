package com.example.onthivnu_ept;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class OnNgauNhien extends Activity {


    ListView listListeningPart1, listListeningPart2, listListeningPart3, listListeningPart4, listReadingPart1, listReadingPart2;
    DataBaseHelper dataBaseHelper;

    Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_ngau_nhien);
        btn=(Button)findViewById(R.id.btnKT);
        Intent myInten=getIntent();
        Bundle myBundle=myInten.getExtras();
        int countListeningPart1=myBundle.getInt("countListeningPart1");
        int countListeningPart2=myBundle.getInt("countListeningPart2");
        int countListeningPart3=myBundle.getInt("countListeningPart3");
        int countListeningPart4=myBundle.getInt("countListeningPart4");
        int countReadingPart1=myBundle.getInt("countReadingPart1");
        int countReadingPart2=myBundle.getInt("countReadingPart2");
        btn.setText(String.valueOf(countListeningPart1+countListeningPart2));
    }


    private void setView()
    {
        listListeningPart1=(ListView)findViewById(R.id.lListeningPart1);
        listListeningPart2=(ListView)findViewById(R.id.lListeningPart2);
        listListeningPart3=(ListView)findViewById(R.id.lListeningPart3);
        listListeningPart4=(ListView)findViewById(R.id.lListeningPart4);
        listReadingPart1=(ListView)findViewById(R.id.lReadingPart1);
        listReadingPart2=(ListView)findViewById(R.id.lReadingPart2);

    }

}