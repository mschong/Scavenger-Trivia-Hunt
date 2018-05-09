package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class StudentClue extends AppCompatActivity {
    private Student student;
    private String password="";

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);
        Question question = student.getQuiz()[student.getQuestionNumber()];
        student.setQuestionNumber(student.getQuestionNumber()+1);
        TextView clueText = findViewById(R.id.clueText);
        final EditText passwordText = findViewById(R.id.passwordEdit);
        clueText.setText(question.getClue());
        password = question.getPassword();

        Button okBtn = findViewById(R.id.okButton);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passwordText.getText().toString().equals(password)){
                    Intent i = new Intent(StudentClue.this, StudentQuiz.class);
                    StudentQuiz sq = new StudentQuiz();
                    sq.setStudent(student);
                    startActivity(i);
                }else{
                    Toast.makeText(StudentClue.this, "Incorrect password", Toast.LENGTH_SHORT).show();
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
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
