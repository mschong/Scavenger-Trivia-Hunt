package com.example.marina.scavengertriviahunt;

import java.util.HashMap;

public class Student {
    private int score;
    private int numberOfQuestions;
    private HashMap<String,String> questions = new HashMap<>();
    private String[] passwords = new String[numberOfQuestions];
    private int numberOfPasswords=0, numberOfClues=0;
    private int numberOfTeams;
    private String[] clues = new String[numberOfQuestions];

    public Student(){
    }

    public void setNumberOfTeams(int numberOfTeams){
        this.numberOfTeams=numberOfTeams;
    }

    public void setScore(int score){
        this.score = score;
    }
    public void setNumberOfQuestions(int numberOfQuestions){
        this.numberOfQuestions=numberOfQuestions;
    }

    public int getNumberOfQuestions(){
        return numberOfQuestions;
    }

    public int getScore(){
        return score;
    }

    public int getNumberOfTeams(){
        return numberOfTeams;
    }

    public HashMap<String, String> getQuestions() {
        return questions;
    }

    public String[] getPasswords() {
        return passwords;
    }

    public void addPassword(String password){
        if(numberOfPasswords!=numberOfQuestions) {
            passwords[numberOfQuestions] = password;
            numberOfPasswords++;
        }
    }

    public void addQuestion(String question, String answer){
        questions.put(question,answer);
    }

    public void addClue(String clue){
        if(numberOfClues!=numberOfQuestions) {
            clues[numberOfClues] = clue;
            numberOfClues++;
        }
    }
}
