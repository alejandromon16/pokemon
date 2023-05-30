package com.example.pokemon;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    private String name;

    @SerializedName("weight")
    private int weight;

    @SerializedName("id")
    private int id;

    @SerializedName("height")
    private String height;
    // ... define other fields you're interested in

    // Create getters and setters for these fields

    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
    public int getWeight() {
        return weight;
    }

    public String getHeight(){
        return height;
    }
}
