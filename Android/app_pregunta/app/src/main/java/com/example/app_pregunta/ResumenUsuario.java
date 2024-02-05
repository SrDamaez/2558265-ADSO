package com.example.app_pregunta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_pregunta.utils.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ResumenUsuario extends AppCompatActivity {
    Config dataConfig;
    String id_usuario;
    String nombre_usuario;
    TextView etq_usuario;
    LinearLayout layoutCuestionarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_usuario);

        dataConfig = new Config(getApplicationContext());

        etq_usuario = findViewById(R.id.etq_usuario);
        layoutCuestionarios = findViewById(R.id.layoutCuestionarios);

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        id_usuario = archivo.getString("id_usuario", null);
        nombre_usuario = archivo.getString("nombres", null);
        etq_usuario.setText(nombre_usuario);

        obtenerCuestionarios();
    }
    public void cerrarSesion(View vista){
        SharedPreferences sharedPreferences = getSharedPreferences("app_preguntas",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencion);
        finish();
    }

    public  void obtenerCuestionarios(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = dataConfig.getEndPoint("/Cuestionarios.php");

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("response: " + response);
                try {
                    System.out.println("servidor OK");
                    JSONObject jsonObject = new JSONObject(response);
                    cargarResumen(jsonObject.getJSONArray("resumen"));
                } catch (JSONException e) {
                    System.out.println("servidor POST responde con un ERROR");
                    System.out.println(e.getMessage());
                    Toast.makeText(getApplicationContext(), "Error en datos de servidor" + e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error:");
                System.out.println(error.getMessage());
            }
        }){
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_usuario", id_usuario);
                return params;
            }
        };
        queue.add(solicitud);

    }

    public void cargarResumen(JSONArray datos){
        try {
            for (int i = 0; i < datos.length(); i++) {
                JSONObject cuestionario = datos.getJSONObject(i);
                String fecha_inicio = cuestionario.getString("fecha_inicio");
                String fecha_fin = cuestionario.getString("fecha_fin");
                String cantidad_preguntas = cuestionario.getString("cant_preguntas");
                String cantidad_ok = cuestionario.getString("cant_ok");
                String cantidad_error = cuestionario.getString("cant_error");

                Button etiqueta = new Button(getApplicationContext());
                etiqueta.setTextColor(Color.BLACK);
                etiqueta.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
                etiqueta.setText("N "+(i+1)+"\n");
                etiqueta.append("Fecha Inicio: "+ fecha_inicio +"\n");
                etiqueta.append("Finalizado el: "+ fecha_fin +"\n");
                etiqueta.append("N° Preguntas: "+ cantidad_preguntas +"\n");
                etiqueta.append("N° OK: "+ cantidad_ok +"\n");
                etiqueta.append("N° ERROR: "+cantidad_error +"\n");
                etiqueta.setBackgroundResource(R.drawable.rounded_button);
                etiqueta.setPadding(30, 20, 0, 0);

                etiqueta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Llamar a cambiarActivity dentro del OnClickListener
                        cambiarActivity(id_usuario, nombre_usuario, fecha_inicio, fecha_fin, cantidad_preguntas, cantidad_ok, cantidad_error);
                    }
                });

                layoutCuestionarios.addView(etiqueta);
                TextView espacio = new TextView(getApplicationContext());
                espacio.setText("\n");
                layoutCuestionarios.addView(espacio);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void cambiarActivity(String id_usuario, String nombres, String fecha_ini, String fecha_fin, String cant_preguntas, String p_buenas, String p_malas){

        SharedPreferences archivo = getSharedPreferences("app_preguntas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = archivo.edit();
        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);
        editor.putString("fecha_inicio", fecha_ini);
        editor.putString("fecha_fin", fecha_fin);
        editor.putString("cantidad_preguntas", cant_preguntas);
        editor.putString("respuestas_ok", p_buenas);
        editor.putString("respuestas_error", p_malas);
        editor.apply();

        Intent intencion = new Intent(getApplicationContext(), Respuestas.class);
        startActivity(intencion);
        finish();
    }

}

