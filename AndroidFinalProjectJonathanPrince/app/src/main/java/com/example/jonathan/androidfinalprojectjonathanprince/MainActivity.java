package com.example.jonathan.androidfinalprojectjonathanprince;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends Activity {
    static boolean db_loaded = false;
    private final static int MOVIES_TO_LOAD=4;

    private ListView movieList;



    //gets the name of the movie file prepopulated in the strings folder.
    Resources res = getResources();
    String[] moviefiles = res.getStringArray(R.array.moviefiles);
    String[] movietitles=res.getStringArray(R.array.movietitles);
    String[] moviepicture =res.getStringArray(R.array.picturefiles);
    String[] moviedescription = res.getStringArray(R.array.moviedescriptions);




    Context ctx;
    public DatabaseAdapter dba=new DatabaseAdapter(ctx);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!db_loaded){

            //creates the info in the database(intentionally one less than total for project req.)
            for(int i=0; i< MOVIES_TO_LOAD-1; i++){
                //public long insertVideo(String video,String title, String description, String picture)
                try {
                    dba.insertVideo(moviefiles[i], movietitles[i], moviedescription[i], moviepicture[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int[] moviepic.


            }

            db_loaded=true;
        }
        CustomList adapter = new CustomList(MainActivity.this, movietitles, moviepicture);
        movieList=(ListView)findViewById(R.id.movieList);
        movieList.setAdapter(adapter);
        movieList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


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
}
