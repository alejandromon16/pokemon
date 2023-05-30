package com.example.pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @GET("pokemon/")
    Call<PokemonResponse> getPokemons(@Query("limit") int limit);
}
