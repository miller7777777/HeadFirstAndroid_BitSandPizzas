package com.hfad.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StoresActivity extends AppCompatActivity {

    public static final String EXTRA_STORENO = "storeNo" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int storeNo = (int) getIntent().getExtras().get(EXTRA_STORENO);

        Stores store = Stores.store[storeNo];

        ImageView photo = (ImageView) findViewById(R.id.photo);

        if (photo != null) {
            photo.setImageResource(store.getImageResourceId());
            photo.setContentDescription(store.getName());
        }

        TextView name = (TextView) findViewById(R.id.name);

        if (name != null) {
            name.setText(store.getName());
        }

        TextView description = (TextView) findViewById(R.id.description);

        if (description != null) {
            description.setText(store.getDescription());
        }


    }
}
