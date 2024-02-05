package com.example.app_pregunta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Respuestas extends AppCompatActivity {

    TextView etq_nom;
    TextView fecha_ini;
    TextView fecha_fn;
    TextView cant_preguntas;
    TextView cant_correctas;
    TextView cant_incorrectas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);
        etq_nom = findViewById(R.id.etq_nom);
        fecha_ini = findViewById(R.id.fecha_ini);
        fecha_fn = findViewById(R.id.fecha_fn);
        cant_preguntas = findViewById(R.id.cant_preguntas);
        cant_correctas = findViewById(R.id.cant_correctas);
        cant_incorrectas = findViewById(R.id.cant_incorrectas);

        cambiar_et();
    }
    public void cambiar_et(){
        // Obtener datos de SharedPreferences
        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        String id_usuario = archivo.getString("id_usuario", null);
        String nombres = archivo.getString("nombres", null);
        String fecha_inicio = archivo.getString("fecha_inicio", null);
        String fecha_fin = archivo.getString("fecha_fin", null);
        String cantidad_preguntas = archivo.getString("cantidad_preguntas", null);
        String respuestas_ok = archivo.getString("respuestas_ok", null);
        String respuestas_error = archivo.getString("respuestas_error", null);

        System.out.println("El parcero se llama: " +nombres + fecha_inicio);
        etq_nom.setText(nombres);
        fecha_ini.setText(fecha_inicio);
        fecha_fn.setText(fecha_fin);
        cant_preguntas.setText(cantidad_preguntas);
        cant_correctas.setText(respuestas_ok);
        cant_incorrectas.setText(respuestas_error);

    }
}
