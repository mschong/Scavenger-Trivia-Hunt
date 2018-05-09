package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TeamsScreen extends AppCompatActivity {
    Student student;
    private int[] ids = new int[] {R.id.t1, R.id.t2,R.id.t3,R.id.t4,R.id.t5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_screen);
        for(int i = ids.length; i >= student.getNumberOfTeams() ; i--){
            View btn = findViewById(ids[i]);
            btn.setEnabled(false);
        }
    }

    public void okClicked(View view){
        Intent i = new Intent(TeamsScreen.this, StudentClue.class);
        startActivity(i);
    }

    public void setStudent(Student student){
        this.student = student;
    }
}
