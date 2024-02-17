package com.example.app_pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetallePokemon extends AppCompatActivity {
    String name;
    String endpoint;
    TextView etq_name;
    TextView etq_altura;
    TextView etq_peso;
    List<String> listaImgPoke;
    RecyclerView recyclerPokemonImg;
    RecyclerView recyclerPokemonSkills;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);
        Bundle datos = getIntent().getExtras();
        endpoint = datos.getString("endpoint");
        name = datos.getString("nombre");

        recyclerPokemonImg = findViewById(R.id.recyclerPokemonImg);
        recyclerPokemonSkills = findViewById(R.id.recyclerPokemonSkills);

        etq_name = findViewById(R.id.etq_name);
        etq_altura = findViewById(R.id.etq_altura);
        etq_peso = findViewById(R.id.etq_peso);

        etq_name.setText(name);

        listaImgPoke = new ArrayList<>();

        getDatosPokemon(endpoint);
    }

    public void getDatosPokemon(String endpoint){
        System.out.println("Iniciando consumo de un pokemon");

        String url = endpoint;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println("El servidor CODE 200");
                    etq_peso.setText(response.getString("weight"));
                    etq_altura.setText(response.getString("height"));
                    JSONObject sprites = response.getJSONObject("sprites");
                    JSONObject other = sprites.getJSONObject("other");

                    JSONObject showdown = other.getJSONObject("showdown");
                    String front_default = showdown.getString("front_default");

                    String front_shiny = showdown.getString("front_shiny");
                    String back_default = showdown.getString("back_default");
                    String back_shiny = showdown.getString("back_shiny");

                    listaImgPoke.add(front_default);
                    listaImgPoke.add(front_shiny);
                    listaImgPoke.add(back_default);
                    listaImgPoke.add(back_shiny);
                    cargarImg(listaImgPoke);

                    // Cargar habilidades
                    JSONArray abilities = response.getJSONArray("abilities");
                    //JSONObject ability = abilities.getJSONObject(1);
                    //JSONObject detalleAbility = ability.getJSONObject("ability");
                    //String nombreAbility = detalleAbility.getString("name");
                    //System.out.println(nombreAbility);
                    cargarHabilidades(abilities);


                    //loadingGif.setVisibility(View.GONE);
                } catch (Exception e) {
                    System.out.println("El servidor GET responde con un error:");
                    System.out.println(e.getMessage());
                    //loadingGif.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor GET responde con un error:");
                System.out.println(error.getMessage());
                //loadingGif.setVisibility(View.GONE);
            }
        });

        queue.add(solicitud);
    }

    public void cargarImg(List<String> lista){
        recyclerPokemonImg.removeAllViews();
        recyclerPokemonImg.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL, false) );
        AdaptadorImg adaptador = new AdaptadorImg(lista);
        recyclerPokemonImg.setAdapter(adaptador);
    }

    public void cargarHabilidades(JSONArray listaHabilidades){
        recyclerPokemonSkills.removeAllViews();
        recyclerPokemonSkills.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        AdaptadorHabilidades adaptadorHabilidades = new AdaptadorHabilidades(listaHabilidades);
        recyclerPokemonSkills.setAdapter(adaptadorHabilidades);
    }

}