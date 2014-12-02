package com.example.jonathan.finalproject;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class MovieList extends Activity {

    private ListView movieList;
    private Context context;
    private DatabaseAdapter DBHelper =new DatabaseAdapter(context);
    private SQLiteDatabase db;

    //gets the name of the movie file prepopulated in the strings folder.
    Resources res = getResources();
    String[] moviefiles = res.getStringArray(R.array.moviefiles);
    String[] movietitles=res.getStringArray(R.array.movietitles);
    String[] moviepicture =res.getStringArray(R.array.picturefiles);
    String[] moviedescription = res.getStringArray(R.array.moviedescriptions);


    private final static int NUMBER_OF_MOVIES = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
            DatabaseAdapter DB;


            createNewDatabase();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_movie_list, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_movie_list, container, false);
            return rootView;
        }
    }
    //creates new database and loops through array of available movies.
    private void createNewDatabase() {
        Context ctx= getApplicationContext();
        DatabaseAdapter db=new DatabaseAdapter(ctx);
        db.open();
        //loop through items

        for (int i=0; i < NUMBER_OF_MOVIES -1; i++) {
            //insertVideo(String video,String title, String description, String rating, String picture)
            db.insertVideo(moviefiles[i], movietitles[i], moviedescription[i], 0, moviepicture[i]);
        }



    }
}
