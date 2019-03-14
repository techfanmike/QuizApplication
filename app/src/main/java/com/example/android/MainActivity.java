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

    // define variables. Most hold the state of the answers
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

    // this group of callbacks handles question 1 answers
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

    // this group of callbacks handles question 3 checkboxes
    // need to read the checkbox state to set the boolean
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

    // this group of callbacks handles question 4 answers
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
        int numberCorrect = 0;
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        EditText simpleEditText = (EditText) findViewById(R.id.question_2_answer);
        CharSequence text;

        // get the edit box answer, and trim whitespace.  Autocomplete
        // likes to add a trailing space
        String strValue = simpleEditText.getText().toString();
        String strValueTrimmed = strValue.trim();

        // check each question, and increment number correct for each correct.
        if(strValueTrimmed.equalsIgnoreCase(getResources().getString(R.string.string_question_2_answer)) ) numberCorrect++;
        if(question1Answer == 1) numberCorrect++;
        if(question3Answer1 &&
            question3Answer2 &&
            !question3Answer3 &&
            !question3Answer4) numberCorrect++;
        if(question4Answer == 3) numberCorrect++;

        // build a toast string and display the toast
        if(numberCorrect == 4)
        {
            text = "Perfect Score - Number Correct:  " + numberCorrect;
        }
        else
        {
            text = "Number Correct:  " + numberCorrect;;
        }
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}