package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherSetup extends AppCompatActivity {
    Teacher teacher;
    Student student;
    int numberTeams, numberQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_setup);
        teacher = new Teacher();

        final EditText teams = findViewById(R.id.numberTeams);
        final EditText questions = findViewById(R.id.numberQuestions);
        Button btn = findViewById(R.id.submitBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    numberTeams = Integer.parseInt(teams.getText().toString());
                    numberQuestions = Integer.parseInt(questions.getText().toString());
                    teacher.student.setNumberOfQuestions(numberQuestions);
                    teacher.student.setNumberOfTeams(numberTeams);
                    Intent i = new Intent(TeacherSetup.this, TeacherQuiz.class);
                    startActivity(i);

            }
        });
    }
    public Teacher getTeacher(){
        return this.teacher;
    }

    public Student getStudent() {
        return student;
    }
}
