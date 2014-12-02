package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class PlayMovie extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_movie);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_movie, menu);
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
}
//Hi folks,
//
//Here is an easy way (not the only way) to grab the movie files from raw if you were still having trouble:
//
//        String video = currentMovie.getTrailer();
//
//        int id = this.getResources().getIdentifier(video, "raw", this.getPackageName());
//
//        String videoPath = "android.resource://" + getPackageName() + "/" + id;
//
//        playerObj.setVideoURI(Uri.parse(videoPath));
//
//        Hope that helps
//
//        David R