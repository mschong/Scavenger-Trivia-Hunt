package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends AppCompatActivity {
    private Student student;
    public String password;
    private EditText p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        p = findViewById(R.id.passwordEdit);

    }

    public void setStudent(Student student){
        this.student=student;
    }

    public void submitClicked(View v){
        if(p.getText().equals(password)) {
            Intent i = new Intent(this, StudentQuiz.class);
            startActivity(i);
        } else{
            Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
        }
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
