package com.example.palworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import android.widget.Toast;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    String nombres;
    String urlBack;
    RequestQueue queue;
    RecyclerView recyclerPokemones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        listaNombres();
    }

    public void listaNombres() {
        String url = "https://pokeapi.co/api/v2/pokemon/";

        StringRequest solicitud = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("todo bien");
                        System.out.println("API Response" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray results = jsonObject.getJSONArray("results");
                            cargarNombre(results);
                        } catch (JSONException e) {
                            Log.e("JSON Parsing Error", e.getMessage());
                            Toast.makeText(MainActivity.this, "Error en datos del servidor", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("todo mal");
                        Log.e("Volley Error", error.toString());
                        Toast.makeText(MainActivity.this, "Error de conexión", Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(solicitud);
    }

    public void cargarNombre(JSONArray datos) {
        try {
            for (int i = 0; i < datos.length(); i++) {
                JSONObject pokemon = datos.getJSONObject(i);
                String nombre = pokemon.getString("name");
                String url = pokemon.getString("url");
                
                System.out.println("Nombre: " + nombre);
                System.out.println("Url: " + url);
            }
        } catch (JSONException e) {
            Log.e("JSON Parsing Error", e.getMessage());
        }
    }

}