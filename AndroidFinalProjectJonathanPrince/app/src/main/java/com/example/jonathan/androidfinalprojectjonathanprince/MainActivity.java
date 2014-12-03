package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;


public class MainActivity extends Activity {

    static boolean db_loaded = false;//to allow the db to only be loaded once.
    private final static int MOVIES_TO_LOAD=4;

    int moviestolist=MOVIES_TO_LOAD;
    private ListView movieList;

    int movieId;



    String[] moviefiles;
    String[] movietitles;
    String[] moviepicture;
    String[] moviedescription;




    Context ctx;
    public DatabaseAdapter dba=new DatabaseAdapter(ctx);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] moviepic=new Integer[moviestolist];

        //gets the name of the movie file pre-populated in the strings folder.
        Resources res = getResources();
        moviefiles = res.getStringArray(R.array.moviefiles);
        movietitles=res.getStringArray(R.array.movietitles);
        moviepicture =res.getStringArray(R.array.picturefiles);
        moviedescription = res.getStringArray(R.array.moviedescriptions);

        if (!db_loaded) {


            //creates the info in the database(intentionally one less than total for project req.)
            for (int i = 0; i < MOVIES_TO_LOAD - 1; i++) {
                //public long insertVideo(String video,String title, String description, String picture)
                try {
                    dba.insertVideo(moviefiles[i], movietitles[i], moviedescription[i], moviepicture[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }


                moviepic[i]= getResId(moviepicture[i], Drawable.class);
            }

            db_loaded = true;

        }



        CustomList adapter = new CustomList(MainActivity.this, movietitles, moviepic);
        movieList = (ListView) findViewById(R.id.movieList);
        movieList.setAdapter(adapter);
        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Intent intent =new Intent(ctx, AddMovie.class);
                intent.putExtra("movieId",movieId);

                try {
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();

                }



            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //http://stackoverflow.com/questions/4427608/android-getting-resource-id-from-string
    public static int getResId(String variableName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
