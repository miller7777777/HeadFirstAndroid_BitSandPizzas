package com.hfad.starbuzz;


public class Food {

    private String name;
    private String description;
    private int imageResourceId;

    public static final Food[] foods = {
            new Food("Маргарита", "сыр Моццарелла, листья базилика, итальянские специи, соус", R.drawable.margarita),
            new Food("Карбонара", "сыр Моццарелла, сыр Пармезан, бекон, свежие шампиньоны, итальянские специи, сливочный соус", R.drawable.karbonara),
            new Food("Елизавета", "сыр Моццарелла, цукини, паприка, свежие помидоры, итальянские специи, соус", R.drawable.elisaveta)
    };

    public Food(String name, String description, int imageResourceId) {
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
