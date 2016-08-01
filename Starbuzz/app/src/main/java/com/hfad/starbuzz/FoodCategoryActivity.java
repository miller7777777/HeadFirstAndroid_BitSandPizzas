package com.hfad.starbuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listFoods = getListView();

        ArrayAdapter<Food> listAdapter = new ArrayAdapter<Food>(
                this,
                android.R.layout.simple_list_item_1,
                Food.foods
        );

        listFoods.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(FoodCategoryActivity.this, FoodActivity.class);
        intent.putExtra(FoodActivity.EXTRA_FOODNO, (int) id);
        startActivity(intent);
    }
}
