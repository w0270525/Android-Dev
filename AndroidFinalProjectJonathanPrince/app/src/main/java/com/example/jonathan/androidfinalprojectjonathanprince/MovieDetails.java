package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MovieDetails extends Activity {
    ImageView pictureView;
    TextView titleText;
    TextView descriptionText;
    RatingBar ratingBar;

    private int movieId = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        //=(RatingBar)findViewById(R.id.movieRating);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_details, menu);
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

    //Action performed when the rating bar is clicked (updates rating in database)
    public void setMovieRating(View view) {

        int rating = ratingBar.getNumStars();
        Context ctx= getApplicationContext();

        DatabaseAdapter db = new DatabaseAdapter(ctx);

        try {
            db.open();
            db.updateRating(movieId, rating, ctx);
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //Action performed when play button is pressed in movie details(goes to PlayMovie)
    public void playBtn(View view) {


        Intent intent =new Intent(this, PlayMovie.class);
        intent.putExtra("movieId",movieId);

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Error starting movie.", Toast.LENGTH_SHORT).show();
        }


    }

    public void editBtn(View view) {
        Intent intent =new Intent(this, AddMovie.class);
        intent.putExtra("movieId",movieId);

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Error editing movie.", Toast.LENGTH_SHORT).show();
        }

    }
}
//EditText editText = (EditText) findViewById(R.id.editName);
//String message = editText.getText().toString();
//
//if (!message.matches("")) {
//        Intent intent = new Intent(this, QuizActivity.class);
//
//        intent.putExtra("NAME", message);
//        Toast.makeText(MainActivity.this, "Welcome, " + editText.getText() + ", good luck.", Toast.LENGTH_SHORT).show();
//        startActivity(intent);
//        } else {
//        Toast.makeText(MainActivity.this, "Please enter a name for record keeping purposes.", Toast.LENGTH_SHORT).show();
//        }
//        }
