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
        final int numQuestions = 0;
        clue = findViewById(R.id.clueText);
        password = findViewById(R.id.passwordText);
        question = findViewById(R.id.questionText);
        answer = findViewById(R.id.answerText);
        Button btn = findViewById(R.id.addBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numQuestions != teacher.student.getNumberOfQuestions()){
                    teacher.student.addClue(clue.getText().toString());
                    teacher.student.addPassword(password.getText().toString());
                    teacher.student.addQuestion(question.getText().toString(), answer.getText().toString());
                    clue.setText("");                    clue.setText("");
                    password.setText("");
                    question.setText("");
                    answer.setText("");
                }else{
                    Toast.makeText(TeacherQuiz.this, "No more questions can be added.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
