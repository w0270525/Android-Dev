package com.nscc.jonathanprince.assignment2quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Quiz {

    private ArrayList<String> answer;
    private ArrayList<String> question;
    private Map<String,String> map;

    //default constructor
    public Quiz(){

        setAnswer(new ArrayList<String>());//declare my question and answer arrays.
        question = new ArrayList<String>();
        map = new HashMap<String,String>();


    }

    public String getQuestion(int num){

        return question.get(num);
    }
    public String getAnswer(int num){

        return getAnswer().get(num);
    }

    //checks to see if the question matches what is in the hash map for an answer
    public boolean checkAnswer(String ans, String que){


        return que.equals(map.get(ans));

    }

    public ArrayList<String> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answer = answer;
    }
}
