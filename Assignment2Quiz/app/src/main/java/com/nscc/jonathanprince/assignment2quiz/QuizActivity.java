package com.nscc.jonathanprince.assignment2quiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.*;


//class for main quiz portion of the app.
public class QuizActivity extends Activity {

//variables for the view


    TextView currentQuestion;//=(TextView)findViewById(R.id.currentQuestion);
    TextView questionNumber;//=(TextView)findViewById(R.id.questionNumber);
    TextView txtScore;
    Button btnA;//= (Button) findViewById(R.id.btnA);
    Button btnB;//=(Button)findViewById(R.id.btnB);
    Button btnC;//=(Button)findViewById(R.id.btnC);
    Button btnD;//=(Button)findViewById(R.id.btnD);
    Context ctx = this.getApplicationContext();
    Quiz quiz;
    String defaultName = "";//default name, should never come in like this.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        currentQuestion = (TextView) findViewById(R.id.currentQuestion);
        questionNumber = (TextView) findViewById(R.id.questionNumber);
        txtScore=(TextView)findViewById(R.id.txtScore);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            defaultName = extras.getString("NAME");//name entered on first screen.

            quiz = new Quiz(ctx);


        }//end if(extras!=null)
        else {//will send back to the first screen if they somehow have no name entered.
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }//end onCreate


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    //does all the work of setting up the next question for the screen
    private void nextQuestion() {


        quiz.setQuestionCounter();
        currentQuestion.setText(quiz.getQuestionCounter());
        if(quiz.getQuestionCounter()!=quiz.getQuestionLimit()){
            //update score
            txtScore.setText("Score: " + quiz.getScore()+ " out of " + quiz.getQuestionCounter());

            currentQuestion.setText(quiz.getQuestion(quiz.getQuestionCounter()));



        }else
        {

            //toast detailing the score and echoing the entered name.
            Toast.makeText(QuizActivity.this, "Your final score was: " +quiz.getScore()+
                    ", good job " +defaultName+"!",Toast.LENGTH_LONG).show();

            //send back to first page
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }



        //update question


        //update buttons
    }

    //onclick listener function inputs selected answer for a
    public void aButton(View v) {

        if (quiz.checkAnswer(btnA.getText().toString(),
                currentQuestion.getText().toString()))
        {
            quiz.addScore();
            nextQuestion();
        } else {
            nextQuestion();
        }


    }//end aButton listener

    //onclick listener function inputs selected answer for b
    public void bButton(View v) {
        if (quiz.checkAnswer(btnA.getText().toString(),
                currentQuestion.getText().toString()))
        {

            quiz.addScore();
            nextQuestion();
        } else {
            nextQuestion();
        }
    }//end bButton listener

    //onclick listener function inputs selected answer for c
    public void cButton(View v) {
        if (quiz.checkAnswer(btnA.getText().toString(),
                currentQuestion.getText().toString()))
        {
            quiz.addScore();
            nextQuestion();
        } else {
            nextQuestion();
        }
    }//end cButton listener

    //onclick listener function inputs selected answer for d
    public void dButton(View v) {
        if (quiz.checkAnswer(btnA.getText().toString(),
                currentQuestion.getText().toString()))
        {
            quiz.addScore();
            nextQuestion();
        } else {
            nextQuestion();
        }
    }//end dButton listener



}//end class
