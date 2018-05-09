package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    JsonUtils jsonUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jsonUtils = new JsonUtils(this);

    }

    public void teacherClicked(View view){
        Intent i = new Intent(this, TeacherQuiz.class);
        startActivity(i);
    }

    public void studentClicked(View view){
        Student student = new Student();
        student.setQuiz(jsonUtils.readQuestionArray());
        if(student.getTotalQuestions()==0){
            Toast.makeText(this, "No quiz available", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(this, StudentClue.class);
            i.putExtra("Student", student);
            startActivity(i);
        }
    }



}
