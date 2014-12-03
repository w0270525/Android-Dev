package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;


public class AddMovie extends Activity {
    Spinner movieSpinner;
    Spinner pictureSpinner;
    EditText movieTitleEdit;
    EditText enterMovieDescription;

    int movieId = -1;
    Context ctx;
    public DatabaseAdapter dba=new DatabaseAdapter(ctx);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);






        if (movieId != -1) {

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_movie, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //method to add items into database
    public void addMovieBtnClick(View view) {


        dba.open();
        //String video,String title, String description, String picture
        try {
            dba.insertVideo(movieSpinner.getItemAtPosition(movieSpinner.getSelectedItemPosition()).toString(),
                    movieTitleEdit.getText().toString(), enterMovieDescription.getText().toString(),
                    pictureSpinner.getItemAtPosition(pictureSpinner.getSelectedItemPosition()).toString());
        } catch (Exception e) {
            System.out.println("error inserting video on button click");
            e.printStackTrace();
        }


    }

    public void delButtonOnClick(View view) {
        if (movieId != -1)
        {

            dba.open();

            try {
                dba.deleteVideo(movieId);
            } catch (Exception e) {
                System.out.println("del failed.");
            }

            dba.close();
        }
        else
        {
            //TODO clear entries entered in form.

        }

    }
}
