package com.example.android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    int question1Answer = 0;
    boolean question3Answer1 = false;
    boolean question3Answer2 = false;
    boolean question3Answer3 = false;
    boolean question3Answer4 = false;
    int question4Answer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioQuestion1Answer1(View v){
        question1Answer = 1;
    }

    public void onRadioQuestion1Answer2(View v){
        question1Answer = 2;
    }

    public void onRadioQuestion1Answer3(View v){
        question1Answer = 3;
    }

    public void onRadioQuestion1Answer4(View v){
        question1Answer = 4;
    }

    public void onCheckQuestion3Answer1(View v){
        question3Answer1 = ((CheckBox) v).isChecked();
    }

    public void onCheckQuestion3Answer2(View v){
        question3Answer2 = ((CheckBox) v).isChecked();
    }

    public void onCheckQuestion3Answer3(View v){
        question3Answer3 = ((CheckBox) v).isChecked();
    }

    public void onCheckQuestion3Answer4(View v){
        question3Answer4 = ((CheckBox) v).isChecked();
    }

    public void onRadioQuestion4Answer1(View v){
        question4Answer = 1;
    }

    public void onRadioQuestion4Answer2(View v){
        question4Answer = 2;
    }

    public void onRadioQuestion4Answer3(View v){
        question4Answer = 3;
    }

    public void onRadioQuestion4Answer4(View v){
        question4Answer = 4;
    }

    public void gradeQuiz(View v) {
        AtomicInteger numberCorrect = new AtomicInteger();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        EditText simpleEditText = (EditText) findViewById(R.id.question_2_answer);
        String strValue = simpleEditText.getText().toString();

        if(strValue.equalsIgnoreCase("kentucky") ) numberCorrect.getAndIncrement();
        if(question1Answer == 1) numberCorrect.getAndIncrement();
        if(question3Answer1 &&
            question3Answer2 &&
            !question3Answer3 &&
            !question3Answer4) numberCorrect.getAndIncrement();
        if(question4Answer == 3) numberCorrect.getAndIncrement();

        CharSequence text = "Number Correct:  " + numberCorrect;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}