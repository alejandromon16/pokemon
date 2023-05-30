package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetail extends AppCompatActivity {

    TextView tvName, tvHeight, tvWeight, tvAbilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        tvName = findViewById(R.id.tvName);
        tvHeight = findViewById(R.id.tvHeight);
        tvWeight = findViewById(R.id.tvWeight);

        Intent intent = getIntent();
        int pokemonId = intent.getIntExtra("POKEMON_ID", 0);

        PokeApiService service = ApiClient.getClient().create(PokeApiService.class);

        // Get a single Pokemon by ID
        Call<Pokemon> pokemonCall = service.getPokemon(pokemonId);
        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon pokemon = response.body();

                    // Log the response
                    Log.d("PokemonDetail", "Response: " + response.body().toString());

                    // Update your UI with the details of the Pokemon
                    tvName.setText(pokemon.getName());
                    tvHeight.setText("Height: " + pokemon.getHeight());
                    tvWeight.setText("Weight: " + pokemon.getWeight());

                    // assuming pokemon.getAbilities() returns a List<String>
                    // String abilities = String.join(", ", pokemon.getAbilities());
                    // tvAbilities.setText("Abilities: " + abilities);
                } else {
                    // handle request errors depending on status code
                    Log.e("PokemonDetail", "Response not successful. Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                // handle network errors
            }


        });
    }
}
