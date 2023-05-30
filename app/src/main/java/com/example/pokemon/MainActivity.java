package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter adapter;
    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        pokemonList = new ArrayList<>();
        adapter = new PokemonAdapter(pokemonList);

        recyclerView.setAdapter(adapter);

        PokeApiService service = ApiClient.getClient().create(PokeApiService.class);

        // Get a list of 20 Pokemon
        Call<PokemonResponse> pokemonListCall = service.getPokemons(20);
        pokemonListCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    pokemonList = response.body().getResults();
                    adapter.updatePokemonList(pokemonList);
                } else {
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                // handle network errors
            }
        });
    }
}
