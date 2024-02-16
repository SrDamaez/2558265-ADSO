package com.example.primeraplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity1 extends AppCompatActivity {

    Button btn_responder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        btn_responder=findViewById(R.id.btn_responder);

    }
}