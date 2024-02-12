package com.example.palworld;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.w3c.dom.Text;
import java.util.List;
public class AdaptadorPokemon extends RecyclerView.Adapter<AdaptadorPokemon.ViewHolder> {
    List<Pokemon> listaPokemon;
    public AdaptadorPokemon(List<Pokemon> listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    @NonNull
    @Override
    public AdaptadorPokemon.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPokemon.ViewHolder holder, int position) {
        Pokemon temporal = listaPokemon.get(position);
        holder.cargarDatos(temporal);
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombrePokemon;
        TextView contador;
        ImageView btnDetalle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contador = itemView.findViewById(R.id.etqContador);
            nombrePokemon = itemView.findViewById(R.id.etqNombres);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);
        }
        public void cargarDatos(Pokemon pokemon){
            nombrePokemon.setText(pokemon.getNombre());
            contador.setText(pokemon.getContador());

        }
    }
}
