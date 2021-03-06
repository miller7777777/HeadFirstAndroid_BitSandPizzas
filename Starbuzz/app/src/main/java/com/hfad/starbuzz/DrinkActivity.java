package com.hfad.starbuzz;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends Activity {

    public static final String EXTRA_DRINKNO = "drinkNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (int) getIntent().getExtras().get(EXTRA_DRINKNO);

        //Создание курсора

        try {
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID", "FAVORITE"},
                    "_id=?",
                    new String[]{Integer.toString(drinkNo)},
                    null, null, null);

            //Переход к первой записи в курсоре

            if (cursor.moveToFirst()) {
                //получение напитка из курсора
                String nameText = cursor.getString(0);
                String descriptionText = cursor.getString(1);
                int photoId = cursor.getInt(2);
                boolean isFavorite = (cursor.getInt(3) == 1);

                TextView name = (TextView) findViewById(R.id.name);

                if (name != null) {
                    name.setText(nameText);
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

                //Заполнение флажка любимого напитка
                CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
                if (favorite != null) {
                    favorite.setChecked(isFavorite);
                }

            }
            cursor.close();
            db.close();
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavalable", Toast.LENGTH_LONG);
            toast.show();
        }


    }

    //обновление базы данных по щелчку на флажке
    public void onFavoriteClicked(View view) {

        int drinkNo = (int) getIntent().getExtras().get("drinkNo");
        new UpdateDrinkTask().execute(drinkNo);

    }

    //Внутренний класс для обновления напитка.
    private class UpdateDrinkTask extends AsyncTask<Integer, Void, Boolean> {

        ContentValues drinkValues;

        @Override
        protected void onPreExecute() {
            CheckBox favorite = (CheckBox) findViewById(R.id.favorite);
            drinkValues = new ContentValues();
            drinkValues.put("FAVORITE", favorite.isChecked());

        }

        @Override
        protected Boolean doInBackground(Integer... drinks) {
            int drinkNo = drinks[0];
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(DrinkActivity.this);

            try {
                SQLiteDatabase db = starbuzzDatabaseHelper.getWritableDatabase();
                db.update("DRINK", drinkValues,
                        "_id = ?", new String[]{Integer.toString(drinkNo)});
                db.close();

                return true;
            } catch (SQLiteException e) {
                return false;
            }

        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (!success) {
                Toast toast = Toast.makeText(DrinkActivity.this, "Database unavailable", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
