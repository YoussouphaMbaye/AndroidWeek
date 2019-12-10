package com.example.wintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnCall;
    Button btnSms;
    Button btnSend;
    Button btnNew;
    Button btnWeb;
    Button btnMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall =findViewById(R.id.button);
        btnSms =findViewById(R.id.button2);
        btnSend=findViewById(R.id.button3);
        btnNew=findViewById(R.id.button5);
        btnWeb=findViewById(R.id.button6);
        btnMap=findViewById(R.id.button4);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Intent.ACTION_DIAL);
                myIntent.setData(Uri.parse("tel: 771904226"));
                startActivity(myIntent);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Intent.ACTION_SENDTO);
                myIntent.setData(Uri.parse("smsto:"+Uri.encode("771904226")));
                myIntent.putExtra("sms_body","Hello");
                startActivity(myIntent);
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
                myIntent.putExtra(Intent.EXTRA_TEXT,"join cs639");
                startActivity(Intent.createChooser(myIntent,"Share the love"));
            }
        });
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(getApplicationContext(),NavActivity.class);
                startActivity(myIntent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com"));
                startActivity(myIntent);
            }
        });
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geoUri=String.format("geo:38.89933,-77.036476");
                Uri geo=Uri.parse(geoUri);
                Intent myIntent=new Intent(Intent.ACTION_VIEW,geo);
                startActivity(myIntent);
            }
        });
    }
}
