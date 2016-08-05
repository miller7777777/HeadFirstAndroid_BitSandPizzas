package com.hfad.starbuzz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (int) getIntent().getExtras().get(EXTRA_DRINKNO);

        //Создание курсора

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id=?",
                    new String[]{Integer.toString(drinkNo)},
                    null, null, null);

            //Переход к первой записи в курсоре

            if (cursor.moveToFirst()) {
                //получение напитка из курсора
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);

                TextView name = (TextView) findViewById(R.id.name);

                if (name != null) {
                    name.setText(descriptionText);
                }

                TextView description = (TextView) findViewById(R.id.description);
                if (description != null) {
                    description.setText(descriptionText);
                }

                ImageView photo = (ImageView) findViewById(R.id.photo);
                if (photo != null) {
                    photo.setImageResource(photoId);
                    photo.setContentDescription(nameText);
                }

            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavalable", Toast.LENGTH_LONG);
            toast.show();
        }


    }
}
