package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    TeacherSetup ts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void teacherClicked(View view){
        Intent i = new Intent(this, TeacherSetup.class);
        startActivity(i);
    }

    public void studentClicked(View view){
        TeamsScreen teams = new TeamsScreen();
        StudentClue clue = new StudentClue();
        StudentQuiz quiz = new StudentQuiz();
        Password password = new Password();
        ScoreScreen sc  = new ScoreScreen();
        sc.setStudent(ts.getTeacher().getStudent());
        clue.setStudent(ts.getTeacher().getStudent());
        quiz.setStudent(ts.getTeacher().getStudent());
        password.setStudent(ts.getTeacher().getStudent());
        teams.setStudent(ts.getTeacher().getStudent());
        Intent i = new Intent(this,TeamsScreen.class);
        startActivity(i);
    }
}
