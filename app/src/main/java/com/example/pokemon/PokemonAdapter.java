package com.example.pokemon;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.tvPokemonName.setText(pokemon.getName());

        Log.d("PokemonAdapter", "Pokemon ID: " + pokemon.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PokemonDetail.class);
                intent.putExtra("POKEMON_ID", pokemon.getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void updatePokemonList(List<Pokemon> updatedList) {
        Log.d("list", String.valueOf(updatedList.get(1)));
        this.pokemonList = updatedList;
        notifyDataSetChanged();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tvPokemonName;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPokemonName = itemView.findViewById(R.id.tvPokemonName);
        }
    }
}

