package com.example.pruebarecycle;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdaptadorPersonas extends RecyclerView.Adapter<AdaptadorPersonas.ViewHolder> {

    List<Persona> listaPersonas;
    public AdaptadorPersonas(List<Persona> listaPersonas){
        this.listaPersonas = listaPersonas;
    }

    @NonNull
    @Override
    public AdaptadorPersonas.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonas.ViewHolder holder, int position) {
        Persona temporal = listaPersonas.get(position);
        holder.cargarDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPersona;
        TextView etqNombres;
        TextView etqEdad;
        TextView etqGenero;
        TextView etqTelefono;
        TextView etqEmail;
        TextView etqEstado;
        FloatingActionButton btnBuscar;
        Context contexto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPersona = itemView.findViewById(R.id.imgPersona);
            etqNombres = itemView.findViewById(R.id.etqNombres);
            etqEdad = itemView.findViewById(R.id.etqEdad);
            etqGenero = itemView.findViewById(R.id.etqGenero);
            etqTelefono = itemView.findViewById(R.id.etqTelefono);
            etqEmail = itemView.findViewById(R.id.etqEmail);
            etqEstado = itemView.findViewById(R.id.etqEstado);
            btnBuscar = itemView.findViewById(R.id.btnBuscar);
            contexto = itemView.getContext();
        }

        public void cargarDatos(Persona persona){
            etqNombres.setText(persona.getNombres());
            etqGenero.setText(persona.getGenero());
            etqEdad.setText(persona.getEdad());
            etqTelefono.setText(persona.getTelefono());
            etqEmail.setText(persona.getEmail());
            etqEstado.setText(persona.getEstado());

            if(persona.getEstado().equalsIgnoreCase("ACTIVO")){
                etqEstado.setTextColor(Color.GREEN);
            }else {
                etqEstado.setTextColor(Color.RED);
            }

            if (persona.getGenero().equalsIgnoreCase("MASCULINO")){
                imgPersona.setImageResource(R.mipmap.ic_masculino);
            }else {
                imgPersona.setImageResource(R.mipmap.ic_femenino);
            }

            btnBuscar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nombres = persona.getNombres();
                    String edad = persona.getEdad();
                    String genero = persona.getGenero();
                    String telefono = persona.getTelefono();
                    String email = persona.getEmail();
                    String estado = persona.getEstado();

                    Intent intencion = new Intent(contexto, DetallePersona.class);
                    intencion.putExtra("nombres", nombres);
                    intencion.putExtra("edad", edad);
                    intencion.putExtra("genero", genero);
                    intencion.putExtra("telefono", telefono);
                    intencion.putExtra("email", email);
                    intencion.putExtra("estado", estado);
                    contexto.startActivity(intencion);
                }
            });
        }
    }
}