package com.example.app_pokemon;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class AdaptadorImg extends  RecyclerView.Adapter<AdaptadorImg.ViewHolder>{

    List<String> listaImg;

    public AdaptadorImg(List<String> listaImg){
        this.listaImg = listaImg;
    }

    @NonNull
    @Override
    public AdaptadorImg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_pokemon, parent, false);

        return new AdaptadorImg.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorImg.ViewHolder holder, int position) {
        String temp = listaImg.get(position);
        holder.consumoImagen(temp);
    }

    @Override
    public int getItemCount() {
        return listaImg.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_pokemon;
        Context contexto;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            image_pokemon = itemView.findViewById(R.id.image_pokemon);
            contexto = itemView.getContext();

        }

        public void consumoImagen(String ruta){
            //RequestQueue queue = Volley.newRequestQueue(contexto);
            //String url =  ruta;
            //ImageRequest solicitud = new ImageRequest(url, new Response.Listener<Bitmap>() { @Override public void onResponse(Bitmap bitmap) { image_pokemon.setImageBitmap(bitmap);} }, 0, 0, null, new Response.ErrorListener() { @Override public void onErrorResponse(VolleyError error) { } });
            //queue.add(solicitud);

            Glide.with(contexto)
                    .asGif()
                    .load(ruta)
                    .into(new ImageViewTarget<GifDrawable>(image_pokemon) {
                        @Override
                        protected void setResource(GifDrawable resource) {
                            if (resource != null){
                                image_pokemon.setImageDrawable(resource);
                                resource.start(); // Inicia la animación del GIF
                            }else{
                                System.out.println("resource es nulo");
                            }
                        }
                    });

        }

    }

}
