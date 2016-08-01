package com.hfad.starbuzz;


public class Stores {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Stores[] store = {
            new Stores("Уно Моменто", "Прекрасное место в Павловске с замечательной пиццей", R.drawable.uno_momento),
            new Stores("Флора", "Прекрасное место в Пушкине, недалеко от Лицея", R.drawable.flora),
            new Stores("Грушенька", "Хорошее место в Павловске с неплохой кухней и отличной выпечкой", R.drawable.matveev)
    };

    public Stores(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
