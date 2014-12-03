package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

import java.net.URI;


public class PlayMovie extends Activity {

    VideoView videoView;
    String videoIn;
    String movieId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_movie);

        //sets video in to the movie that needs to be played from the previous screen.
        videoView=(VideoView)findViewById(R.id.videoView);
        Bundle extras = getIntent().getExtras();
        videoIn= extras.getString("video");
        movieId=extras.getString("movieId");


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

    //goes back to the previous screen.
    public void goBackOnClick(View view) {

        Intent intent = new Intent(this, MovieDetails.class);
        intent.putExtra("movieId", movieId);

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();

        }


    }

    //starts playing the video when pressed
    public void playOnClick(View view) {

        String video = videoIn;
        videoView.findViewById(R.id.videoView);
        int id = this.getResources().getIdentifier(video, "raw", this.getPackageName());

        String videoPath = "android.resource://" + getPackageName() + "/" + id;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();

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

//VideoView videoView;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main);
//        videoView = (VideoView)findViewById(R.id.VideoView);
//        videoView.setVideoPath("/sdcard/blonde_secretary.3gp");
//        videoView.start();
//    }