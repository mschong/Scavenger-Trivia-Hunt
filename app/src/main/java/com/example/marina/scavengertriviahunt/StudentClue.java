package com.example.marina.scavengertriviahunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StudentClue extends AppCompatActivity {
    private Student student;
    public String clue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clue);
        TextView c = findViewById(R.id.clueText);
        c.setText(clue);

    }

    public void setStudent(Student student){
        this.student=student;
    }

    public void okClicked(View view){
        Intent i = new Intent(this, Password.class);
        startActivity(i);
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
