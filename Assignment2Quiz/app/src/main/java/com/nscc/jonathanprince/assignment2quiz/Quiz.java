package com.nscc.jonathanprince.assignment2quiz;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Quiz {

    private ArrayList<String> answer;
    private ArrayList<String> question;
    private Map<String, String> map;
    int questionLimit = 10;//number of questions to create/allow.
    int score = 0;//a variable to keep track of scoring
    int questionCounter = 0; //variable to keep track of what question the user is on.

    //default constructor
    public Quiz(Context ctx) {

        answer = new ArrayList<String>();//declare my question and answer arrays.
        question = new ArrayList<String>();
        map = new HashMap<String, String>();

        createQuestions(answer, question, map, ctx);

    }

    private void createQuestions(ArrayList<String> answer, ArrayList<String> question, Map<String, String> map, Context ctx) {
        try {

            /*int i = this.getResources().getIdentifier
                    ("questions","raw", this.getPackageName());*/
            InputStream iStream = ctx.getResources().openRawResource(R.raw.quiz);//This seemed to be the magic line to get it to read the file.
            InputStreamReader iReader = new InputStreamReader(iStream);
            BufferedReader bReader = new BufferedReader(iReader); //

            String entry;
            int count=0;

            while ((entry = bReader.readLine()) != null) {


                String[] result = entry.split(";");//splits the line into two parts. file should only have two results per line.
                answer.add(result[0]);//not using full OOP here
                question.add(result[1]);

                map.put(answer.get(count), getQuestion(count));//sets the hashmap question and answer together
                count++;//adds to be the next question

            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        shuffleQ();

    }

    //mixes order of questions
    private void shuffleQ() {
        Collections.shuffle(question);
    }

    public void fourAnswers(){
        //hoping to take actual answer and the top 3 from the shuffled list, then assign them to buttons randomly.

        Collections.shuffle(answer);

    }


    //checks to see if the question matches what is in the hash map for an answer
    public boolean checkAnswer(String ans, String que) {


        return que.equals(map.get(ans));

    }

    public String getAnswer(int num) {
        return answer.get(num);
    }



    public String getQuestion(int num) {
        return question.get(num);
    }

    public void setQuestion(ArrayList<String> question) {
        this.question = question;
    }

    public int getQuestionLimit() {
        return questionLimit;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public void setQuestionCounter(int questionCounter) {
        this.questionCounter = questionCounter;
    }
}


