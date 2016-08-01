package com.hfad.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(TopLevelActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if(position == 1){
                    Intent intent = new Intent(TopLevelActivity.this, FoodCategoryActivity.class);
                    startActivity(intent);

                }else if(position == 2){
                    Intent intent = new Intent(TopLevelActivity.this, StoresCategoryActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView mListView = (ListView) findViewById(R.id.list_options);

        if (mListView != null) {
            mListView.setOnItemClickListener(mOnItemClickListener);
        }

    }


}
