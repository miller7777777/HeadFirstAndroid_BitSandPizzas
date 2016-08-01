package com.hfad.starbuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StoresCategoryActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();

        ArrayAdapter<Stores> listAdapter = new ArrayAdapter<Stores>(
                this,
                android.R.layout.simple_list_item_1,
                Stores.store
        );

        listView.setAdapter(listAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(StoresCategoryActivity.this, StoresActivity.class);
        intent.putExtra(StoresActivity.EXTRA_STORENO, (int) id);
        startActivity(intent);
    }
}
