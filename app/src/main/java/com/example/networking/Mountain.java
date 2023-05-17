package com.example.networking;

public class Mountain {
    public String name;
    public String ID;
    public String company;
    public String location;
    public String category;
    public int size;
    public int cost;
    public String type;

    public Mountain(String ID, String name, String type, String company, String location,
                    String category, int size, int cost) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.company = company;
        this.location = location;
        this.category = category;
        this.size = size;
        this.cost = cost;
    }
}