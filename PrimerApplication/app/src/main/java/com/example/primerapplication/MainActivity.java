package com.example.primerapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText campo_id;
    EditText campo_nombres;
    EditText campo_email;
    Button btn_registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo_id = findViewById(R.id.campo_id);
        campo_nombres = findViewById(R.id.campo_nombres);
        campo_email = findViewById(R.id.campo_email);
        btn_registrar = findViewById(R.id.btn_registrar);
    }

    public void  registrarPersona(view vista){
        String id = campo_id.getText().toString();
        String nombre = campo_nombres.getText().toString();
        String email = campo_email.getText().toString();
    }
}