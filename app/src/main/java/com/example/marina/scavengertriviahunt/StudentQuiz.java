package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class StudentQuiz extends AppCompatActivity {
    private Student student;
    private String answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent i = getIntent();
        student = (Student)i.getSerializableExtra("Student");
        Question question = student.getQuiz()[student.getQuestionNumber()];
        TextView q = findViewById(R.id.questionText);
        final EditText answerText = findViewById(R.id.answerText);
        q.setText(question.getQuestion());
        answer = question.getAnswer();
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!answerText.getText().toString().equals(answer)){
                    Toast.makeText(StudentQuiz.this, "Incorrect answer", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(StudentQuiz.this, "Correct!", Toast.LENGTH_SHORT).show();
                    student.setScore(student.getScore()+1);
                    student.setQuestionNumber(student.getQuestionNumber()+1);
                    if(student.getQuestionNumber()!=student.getTotalQuestions()){
                        Intent i = new Intent(StudentQuiz.this, StudentClue.class);
                        i.putExtra("Student",student);
                        startActivity(i);
                    } else{
                        Intent i = new Intent(StudentQuiz.this, ScoreScreen.class);
                        i.putExtra("Student",student);
                        startActivity(i);
                    }
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.homeButton) {
            // do something here
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        else if(id == R.id.scoreButton){
            Intent i = new Intent(this, ScoreScreen.class);
            i.putExtra("Student", student);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
