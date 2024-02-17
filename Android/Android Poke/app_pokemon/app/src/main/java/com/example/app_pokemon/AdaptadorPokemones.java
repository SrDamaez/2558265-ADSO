package com.example.app_pokemon;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class AdaptadorPokemones extends  RecyclerView.Adapter<AdaptadorPokemones.ViewHolder>{

    JSONArray listaPokemones;

    public AdaptadorPokemones(JSONArray listaPokemones){
        this.listaPokemones = listaPokemones;
    }

    @NonNull
    @Override
    public AdaptadorPokemones.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemones, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPokemones.ViewHolder holder, int position) {
        try {
            JSONObject temp = listaPokemones.getJSONObject(position);
            String nombre = temp.getString("name");
            String endpoint = temp.getString("url");
            holder.cargarPokemones(nombre,endpoint);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listaPokemones.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView etqNombrePoke;
        TextView etqNumPoke;
        ImageView btn_info_poke;
        Context contexto;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            etqNombrePoke = itemView.findViewById(R.id.etq_nombre_poke);
            etqNumPoke = itemView.findViewById(R.id.etq_num_poke);
            btn_info_poke = itemView.findViewById(R.id.btn_info_poke);
            contexto = itemView.getContext();

        }

        public void cargarPokemones(String nombre,String endpoint){
            etqNombrePoke.setText(nombre.toUpperCase());


            String id_poke = extraerNumeroPoke(endpoint);
            int id_pokemon = Integer.parseInt(id_poke);
            String numberPoke = (id_pokemon < 10) ? "000" + id_poke : (id_pokemon < 100) ? "00" + id_poke : (id_pokemon < 1000) ? "0" + id_poke : id_poke;
            etqNumPoke.setText(numberPoke);

            btn_info_poke.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(contexto, DetallePokemon.class);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("endpoint",endpoint);
                    contexto.startActivity(intent);

                }
            });



        }

        private String extraerNumeroPoke(String endpoint) {
            // Dividir la cadena por "/"
            String[] segments = endpoint.split("/");

            if (segments.length >= 3) {
                return segments[6];
            }
            return null;
        }



    }
}
