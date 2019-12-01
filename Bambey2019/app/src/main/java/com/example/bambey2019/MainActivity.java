package com.example.bambey2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText nom;
    TextView tvh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//rendre visible la layout
        btn1=findViewById(R.id.btn1);
        tvh=findViewById(R.id.tv2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"vous avez clique sur le bouton",Toast.LENGTH_LONG).show();
                tvh.setText("Hello Hello");
            }
        });
    }
}
