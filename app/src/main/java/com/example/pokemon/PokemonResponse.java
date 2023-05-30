package com.example.pokemon;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class PokemonResponse {
    @SerializedName("results")
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}

