package com.example.marina.scavengertriviahunt;

import android.content.Context;
import android.util.JsonReader;
import android.util.JsonWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    FileOutputStream out;
    FileInputStream in;
    JsonWriter writer;
    JsonReader reader;

    public JsonUtils(Context context){
        try {
            out = context.openFileOutput("output.txt", 0);
            in = context.openFileInput("output.txt");
            reader = new JsonReader(new InputStreamReader(in));
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
            writer.close();
        }catch (Exception e){

        }
    }



    public Question[] readQuestionArray(){
        List<Question> quiz = new ArrayList<>();
        try {
            reader.beginArray();
            while(reader.hasNext()){
                quiz.add(readQuestion());
            }
            reader.endArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Question[] quizArray = new Question[quiz.size()];
        for(int i = 0 ; i < quiz.size(); i++){
            quizArray[i] = quiz.get(i);
        }
        return quizArray;
    }

    private Question readQuestion() {
        String clue = "", password="", question="", answer="";
        try {
            reader.beginObject();
            while(reader.hasNext()){
                String name = reader.nextName();
                if (name.equals("clue")) {
                    clue = reader.nextString();
                } else if (name.equals("password")) {
                    password = reader.nextString();
                } else if (name.equals("question")) {
                   question = reader.nextString();
                } else if (name.equals("answer")) {
                    answer = reader.nextString();
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Question(clue, password, question, answer);
    }
}
