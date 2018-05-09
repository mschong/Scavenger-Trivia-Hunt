package com.example.marina.scavengertriviahunt;


public class Student {
    private Question[] quiz;
    private int score=0, questionNumber =0;

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


}
