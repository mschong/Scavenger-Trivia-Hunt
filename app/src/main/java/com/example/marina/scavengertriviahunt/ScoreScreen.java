package com.example.marina.scavengertriviahunt;

import android.content.Intent;
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
        TextView currentScore = findViewById(R.id.currentScore);
        TextView totalScore = findViewById(R.id.totalScore);
        Intent i = getIntent();
        student = (Student) i.getSerializableExtra("Student");

        currentScore.setText(String.valueOf(student.getScore()));
        totalScore.setText(String.valueOf(student.getTotalQuestions()));

    }

}
