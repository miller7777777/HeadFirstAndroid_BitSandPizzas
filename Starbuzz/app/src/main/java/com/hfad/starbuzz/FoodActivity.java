package com.hfad.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {

    public static final String EXTRA_FOODNO = "foodNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        int foodNo = (int) getIntent().getExtras().get(EXTRA_FOODNO);

        Food foods = Food.foods[foodNo];

        ImageView photo = (ImageView) findViewById(R.id.food_photo);
        if (photo != null) {
            photo.setImageResource(foods.getImageResourceId());
            photo.setContentDescription(foods.getName());
        }

        TextView name = (TextView) findViewById(R.id.food_name);
        if (name != null) {
            name.setText(foods.getName());
        }

        TextView description = (TextView) findViewById(R.id.food_description);

        if (description != null) {
            description.setText(foods.getDescription());
        }


    }
}
