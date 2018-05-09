package com.example.marina.scavengertriviahunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ScoreScreen extends AppCompatActivity {
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_screen);
        TextView current = findViewById(R.id.currentScore);
        TextView total = findViewById(R.id.totalScore);
        current.setText(student.getScore());
        total.setText(student.getNumberOfQuestions());
    }

    public void setStudent(Student student){
        this.student=student;
    }
}
