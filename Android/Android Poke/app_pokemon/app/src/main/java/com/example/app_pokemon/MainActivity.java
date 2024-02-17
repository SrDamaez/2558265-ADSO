package com.example.app_pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerPokemones;
    Button btn_siguiente;
    Button btn_atras;
    ImageView loadingGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPokemones = findViewById(R.id.recyclerPokemones);
        btn_siguiente = findViewById(R.id.siguiente);
        btn_atras = findViewById(R.id.anterior);
        loadingGif = findViewById(R.id.loadingGif);

        consumoPOKEAPI();
    }

    public void consumoPOKEAPI(String endpoint ) {
        //loadingGif.setVisibility(View.VISIBLE);
        System.out.println("Iniciando consumo");

        String url = (endpoint != null) ? endpoint : "https://pokeapi.co/api/v2/pokemon";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println("OK");
                    JSONArray allPokems = response.getJSONArray("results");
                    cargarPokemones(allPokems);

                    String next = response.getString("next");
                    String previous = response.getString("previous");
                    if (next == null){
                        btn_siguiente.setEnabled(false);
                    }else{
                        btn_siguiente.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                consumoPOKEAPI(next);
                            }
                        });
                    }

                    if (previous == null){
                        btn_atras.setEnabled(false);
                    }else{
                        btn_atras.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                consumoPOKEAPI(previous);
                            }
                        });
                    }
                    //loadingGif.setVisibility(View.GONE);
                } catch (Exception e) {
                    System.out.println("error:");
                    System.out.println(e.getMessage());
                    //loadingGif.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error:");
                System.out.println(error.getMessage());
                //loadingGif.setVisibility(View.GONE);
            }
        });

        queue.add(solicitud);
    }

    public void consumoPOKEAPI() {
        consumoPOKEAPI(null);
    }


    public void cargarPokemones(JSONArray arrayPokemones){
        recyclerPokemones.removeAllViews();
        recyclerPokemones.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdaptadorPokemones adaptador = new AdaptadorPokemones(arrayPokemones);
        recyclerPokemones.setAdapter(adaptador);
    }





}