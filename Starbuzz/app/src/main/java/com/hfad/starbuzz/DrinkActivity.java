package com.hfad.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (int) getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];

        ImageView photo = (ImageView) findViewById(R.id.photo);

        if (photo != null) {
            photo.setImageResource(drink.getImageResourceId());
            photo.setContentDescription(drink.getName());
        }

        TextView name = (TextView) findViewById(R.id.name);
        if (name != null) {
            name.setText(drink.getName());
        }

        TextView description = (TextView) findViewById(R.id.description);

        if (description != null) {
            description.setText(drink.getDescription());
        }

    }
}
