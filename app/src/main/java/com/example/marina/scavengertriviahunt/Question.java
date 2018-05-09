package com.example.marina.scavengertriviahunt;

import java.io.Serializable;

public class Question implements Serializable {
    private String clue;
    private String password;
    private String question;
    private String answer;

    public Question(String clue, String password, String question, String answer){
        this.clue=clue;
        this.password=password;
        this.question=question;
        this.answer=answer;
    }

    public void setClue(String clue){
        this.clue = clue;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setQuestion(String question){
        this.question=question;
    }
    public void setAnswer(String answer){
        this.answer=answer;
    }

    public String getClue(){
        return clue;
    }
    public String getPassword(){
        return password;
    }
    public String getQuestion(){
        return question;
    }
    public String getAnswer(){
        return answer;
    }

}
