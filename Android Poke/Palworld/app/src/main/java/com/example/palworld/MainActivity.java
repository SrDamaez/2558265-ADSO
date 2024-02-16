package com.example.palworld;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
    String urlNext;
    RequestQueue queue;
    Button btnBack;
    Button btnNext;
    int contador = 1;

    RecyclerView recyclerPokemones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        if (contador == 1){
            btnBack.setEnabled(false);
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(urlBack != null){
                    contador-=20;
                    listaNombres(urlBack);
                }
                if (contador == 1){
                    btnBack.setEnabled(false);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(urlNext != null){
                    contador+=20;
                    listaNombres(urlNext);
                }
                if (urlBack != null){
                    btnBack.setEnabled(true);
                }


            }
        });

        listaNombres("https://pokeapi.co/api/v2/pokemon/");
    }


    public void listaNombres(String url) {
        StringRequest solicitud = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println("todo bien");
                    System.out.println("API Response" + response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray results = jsonObject.getJSONArray("results");
                        urlBack = jsonObject.getString("previous");
                        urlNext = jsonObject.getString("next");
                        btnBack.setVisibility(urlBack != null ? View.VISIBLE : View.INVISIBLE);
                        btnNext.setVisibility(urlNext != null ? View.VISIBLE : View.INVISIBLE);

                        cargarNombre(results);
                    } catch (JSONException e) {
                        Log.e("JSON Parsing Error", Objects.requireNonNull(e.getMessage()));
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
        List<Pokemon> listaDePokemones = new ArrayList<>();
        String ceros = "0000";
        try {
            for (int i = 0; i < datos.length(); i++) {
                JSONObject pokemon = datos.getJSONObject(i);
                nombres = pokemon.getString("name");
                String endpoint = pokemon.getString("url");
                int sumaContador = i + contador;
                if (sumaContador <= 9){
                    ceros = "000";
                } else if (sumaContador>=10 && sumaContador <=99) {
                    ceros = "00";
                } else if (sumaContador>=100 && sumaContador <=999) {
                    ceros = "0";
                } else if (sumaContador>999){
                    ceros ="";
                }
                listaDePokemones.add(new Pokemon(String.valueOf(ceros+sumaContador),nombres));
                configRecycler(listaDePokemones);
            }
        } catch (JSONException e) {
            Log.e("JSON Parsing Error", e.getMessage());
        }
    }

    public void consumoHabilidades(String url){
        StringRequest solicitud = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println("todo bien");
                    System.out.println("API Response" + response);
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        String peso  = jsonObject.getString("weight");
                        System.out.println("peso: "+peso);
                    } catch (JSONException e) {
                        Log.e("JSON Parsing Error", Objects.requireNonNull(e.getMessage()));
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

    public void configRecycler(List<Pokemon> listaPokemon){
        recyclerPokemones = findViewById(R.id.recyclerPokemones);
        AdaptadorPokemon adaptador = new AdaptadorPokemon(listaPokemon);
        recyclerPokemones.setAdapter(adaptador);
        recyclerPokemones.setLayoutManager(new LinearLayoutManager(this));
    }

}