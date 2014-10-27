package com.nscc.jonathanprince.assignment2quiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.*;

//brought in from FileIO demo
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;
import net.learn2develop.Files.String;

//brought in from hashmap
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


public class QuizActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //check for name value and send by intent to QuizActivity

        String defaultName="";
        Bundle extras= getIntent().getExtras();
        if(extras!=null)
        {
            defaultName = extras.getString("NAME");


/* hashmap example. remove before finalizing.
            Map<String,String> map = new HashMap<String,String>();//create HM obj
            map.put("Color1", "Red");
            map.put("Color2", "Blue");
            map.put("Color3", "Green");
            map.put("Color4", "White");

            Iterator<String> myIterator = map.values().iterator();//create iterator obj
            Context context = getApplicationContext();

            while(myIterator.hasNext())//display colors using toast
            {
                //Toast.makeText(getBaseContext(),myIterator.next(),Toast.LENGTH_SHORT).show();

                CharSequence  text = myIterator.next();//set up string
                int duration = Toast.LENGTH_LONG;//set up the timing
                Toast toast = Toast.makeText(context, text, duration);//create Toast obj
                toast.show();//call method of toast obj to display toast
            }

            map.get("Color1");//to take a key to the hash and get a value back

*/
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
