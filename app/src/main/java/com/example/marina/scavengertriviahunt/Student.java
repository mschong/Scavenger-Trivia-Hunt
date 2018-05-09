package com.example.marina.scavengertriviahunt;


import java.io.Serializable;

public class Student implements Serializable{
    private Question[] quiz;
    private int score=0, questionNumber =0, totalQuestions = 0;

    public Student(){

    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setQuiz(Question[] quiz) {
        this.quiz = quiz;
        this.totalQuestions = quiz.length;
    }

    public int getScore() {
        return score;
    }

    public Question[] getQuiz(){
        return quiz;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }
}
