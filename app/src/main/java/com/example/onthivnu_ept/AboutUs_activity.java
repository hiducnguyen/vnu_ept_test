package com.example.onthivnu_ept;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class AboutUs_activity extends Activity implements View.OnClickListener
{
    Button btnOK;
    Intent About_Us_Intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_activity);
        About_Us_Intent = new Intent(this,MainActivity.class);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        int id= v.getId();
        switch (id)
        {
            case R.id.btnOK:
                this.finish();
                About_Us_Intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivities(new Intent[]{About_Us_Intent});
                break;
        }
    }
}