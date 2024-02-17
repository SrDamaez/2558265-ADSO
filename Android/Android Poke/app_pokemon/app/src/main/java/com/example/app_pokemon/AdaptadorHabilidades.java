package com.example.app_pokemon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

public class AdaptadorHabilidades extends RecyclerView.Adapter<AdaptadorHabilidades.ViewHolder> {
    JSONArray listaHabilidades;

    public AdaptadorHabilidades(JSONArray listaHabilidades){
        this.listaHabilidades = listaHabilidades;
    }


    @NonNull
    @Override
    public AdaptadorHabilidades.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.habilidades_pokemon, parent, false);

        return new AdaptadorHabilidades.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorHabilidades.ViewHolder holder, int position) {
        try {
            JSONObject habilidad = listaHabilidades.getJSONObject(position);
            JSONObject detalleAbility = habilidad.getJSONObject("ability");
            String nombre_habilidad = detalleAbility.getString("name");
            holder.cargarHabilidad(nombre_habilidad);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listaHabilidades.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView etq_habilidad;
        Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etq_habilidad = itemView.findViewById(R.id.etq_habilidad);
            contexto = itemView.getContext();
        }

        public void cargarHabilidad(String habilidad){
            etq_habilidad.setText(habilidad);
        }
    }
}
