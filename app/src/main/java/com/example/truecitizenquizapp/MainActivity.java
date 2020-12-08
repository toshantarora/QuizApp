package com.example.truecitizenquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
 private Button falseButton;
 private Button trueButton;
 private TextView questionTextView;
    private ImageButton nextButton;
    private ImageButton prevButton;

 private int currentQuestionIndex = 0;
 private Questions[] questionsBank = new Questions[]
         {
                 new Questions(R.string.question_Amendment,false),
                 new Questions(R.string.question_constitution, true),
                 new Questions(R.string.question_declaration,true),
                 new Questions(R.string.question_independence_rights,true),
                 new Questions(R.string.question_religion,true),
                 new Questions(R.string.question_government,true),
                 new Questions(R.string.question_government_feds,false),
                 new Questions(R.string.question_government_senators,true),

         };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Questions questions = new Questions(R.string.question_declaration,true);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        nextButton =findViewById(R.id.next_button);
        questionTextView =findViewById(R.id.answer_text_view);
        prevButton = findViewById(R.id.prev_button);

       falseButton.setOnClickListener(this);//register to our buttons to listens to clicks events
       trueButton.setOnClickListener(this);
       nextButton.setOnClickListener(this);
       prevButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.false_button:

               checkAnswer(false);
break;
            case  R.id.true_button:
                checkAnswer(true);
break;
            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex+1)% questionsBank.length;
               /* Log.d("current","onclick" +currentQuestionIndex);
                questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());*/
                updateQuestion();
                break;
            case R.id.prev_button:
                if(currentQuestionIndex>0) {
                    currentQuestionIndex = (currentQuestionIndex - 1) % questionsBank.length;
                    updateQuestion();
                }
        }

    }

    private void updateQuestion()
    {
        Log.d("current","onclick" +currentQuestionIndex);
        questionTextView.setText(questionsBank[currentQuestionIndex].getAnswerResId());
    }
    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questionsBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId = 0;
        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }
        Toast.makeText(MainActivity.this,toastMessageId,Toast.LENGTH_SHORT).show();

}

    private void show() {
    }
}
