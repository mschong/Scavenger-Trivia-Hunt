package com.example.marina.scavengertriviahunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherQuiz extends AppCompatActivity {
    private Teacher teacher;
    EditText clue, password, question, answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_quiz);


    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
