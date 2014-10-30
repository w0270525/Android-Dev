package com.nscc.jonathanprince.assignment2quiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.*;

//brought in from FileIO demo
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//for SD card. not used
//import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.BufferedReader;


//brought in from hashmap
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

//class for main quiz portion of the app.
public class QuizActivity extends Activity {


//variables for running the game
    int questionLimit=10;//number of questions to create/allow.
    int score=0;//a variable to keep track of scoring
    int questionCounter=0; //variable to keep track of what question the user is on.

//variables for the view
    TextView txtCurrentQuestion=(TextView)findViewById(R.id.txtCurrentQuestion);
    TextView txtQuestionNumber=(TextView)findViewById(R.id.questionNumber);
    Button btnA= (Button) findViewById(R.id.btnA);
    Button btnB=(Button)findViewById(R.id.btnB);
    Button btnC=(Button)findViewById(R.id.btnC);
    Button btnD=(Button)findViewById(R.id.btnD);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ArrayList<String> answer = new ArrayList<String>();//declare my question and answer arrays.
        ArrayList<String> question = new ArrayList<String>();
        Map<String,String> map = new HashMap<String,String>();

        //check for name value and send by intent to QuizActivity

        String defaultName="";//default name, should never come in like this.
        Bundle extras= getIntent().getExtras();
        if(extras!=null)
        {
            defaultName = extras.getString("NAME");//name entered on first screen.


            String entry="";
            try {
                Context ctx = this.getApplicationContext();
                int i = this.getResources().getIdentifier
                        ("questions","raw", this.getPackageName());
                InputStream iStream = ctx.getResources().openRawResource(R.raw.quiz );
                InputStreamReader iReader = new InputStreamReader(iStream);
                BufferedReader bReader = new BufferedReader(iReader); //



                while (( entry = bReader.readLine()) != null) {



                    String[] result=entry.split(";");//splits the line into two parts
                    answer.add(result[0]);
                    question.add(result[1]);
                    map.put(answer.get(questionCounter), question.get(questionCounter));//sets the hashmap question and answer together
                    questionCounter++;//adds to be the next question


                }


                }catch(IOException ioe){
                ioe.printStackTrace();
            }

            //randomizes the question order after it's been created and mapped.
            long seed = System.nanoTime();
            Collections.shuffle(question, new Random(seed));

            for (int i=0;i<questionLimit;i++) {
                nextQuestion();

            }

/*  TODO hashmap example. remove before finalizing.
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
        }//end if(extras!=null)
    }//end onCreate


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

    //does all the work of setting up the next question for the screen
    private void nextQuestion(){


        //update score


        //update question


        //update buttons
    }

    public void answerButton(View v)
    {


        //check answer for match in hash


        //call for next question

    }

}
