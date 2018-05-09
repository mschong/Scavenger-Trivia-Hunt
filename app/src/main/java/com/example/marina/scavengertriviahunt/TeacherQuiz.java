package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TeacherQuiz extends AppCompatActivity{
    private Question quizQuestion;
    EditText clue, password, question, answer;
    private JsonUtils jsonUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_quiz);
        clue = findViewById(R.id.clueText);
        password = findViewById(R.id.passwordText);
        question = findViewById(R.id.questionText);
        answer = findViewById(R.id.answerText);
        Button addBtn = findViewById(R.id.addBtn);
        jsonUtils = new JsonUtils(this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clueText="", passwordText="", questionText="", answerText="";
                if(clue.getText()==null && password.getText()==null && question.getText()==null && answer.getText()==null){
                    Toast.makeText(TeacherQuiz.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    clueText = clue.getText().toString();
                    passwordText = password.getText().toString();
                    questionText = question.getText().toString();
                    answerText = answer.getText().toString();
                }

                quizQuestion = new Question(clueText,passwordText,questionText,answerText);
                jsonUtils.writeQuestion(quizQuestion);
                clue.setText("");
                password.setText("");
                question.setText("");
                answer.setText("");

            }
        });

        Button doneBtn = findViewById(R.id.doneBtn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonUtils.closeJson();
                finish();
            }
        });


    }


}
