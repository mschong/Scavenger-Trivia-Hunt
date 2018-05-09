package com.example.marina.scavengertriviahunt;

import android.content.Context;
import android.util.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class JsonUtils {
    FileOutputStream out;
    InputStream in;
    JsonWriter writer;

    public JsonUtils(Context context){
        try {
            out = context.openFileOutput("output.txt", Context.MODE_PRIVATE);
            writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.setIndent(" ");
            writer.beginArray();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void writeQuestion(Question question){
        try {
            writer.beginObject();
            writer.name("clue").value(question.getClue());
            writer.name("password").value(question.getPassword());
            writer.name("question").value(question.getQuestion());
            writer.name("answer").value(question.getAnswer());
            writer.endObject();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void closeJson(){
        try {
            writer.endArray();
            out.close();
        }catch (Exception e){

        }
    }
}
