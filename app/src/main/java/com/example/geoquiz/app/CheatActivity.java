package com.example.geoquiz.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class CheatActivity extends ActionBarActivity{
    private static final String TAG = "CheatActivity";
    private static final String KEY = "CheatIndex";
    private Button mShowButton;
    private TextView mQuestionTextView;
    private boolean mAnswer;
    private int mQuestion;
    public static final String EXTRA_ANSWER = "com.example.geoquiz.app.answer";
    public static final String EXTRA_QUESTION = "com.example.geoquiz.app.question";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.geoquiz.app.answer_shown";

    public void makeToast(int id)
    {
        Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
    }

    private void setAnswerShownResult(boolean isAnswerShown)
    {
      Intent data = new Intent();
      data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setAnswerShownResult(false);
        mAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER,false);
        mQuestion = getIntent().getIntExtra(EXTRA_QUESTION,0);

        mShowButton = (Button)findViewById(R.id.buttonShow);
        mShowButton.setOnClickListener( new View.OnClickListener(){
            @Override

            public void onClick(View v){
                mQuestionTextView.setText(mQuestion);
                int messageResId = 0;
                if(mAnswer)
                    messageResId = R.string.true_toast;
                else
                    messageResId = R.string.false_toast;
                makeToast(messageResId);
                setAnswerShownResult(true);
            }
        });
        mQuestionTextView = (TextView)findViewById(R.id.questionTextView);
        mQuestionTextView.setText(mQuestion);
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause(){
        super.onStart();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onResume(){
        super.onStart();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onStop(){
        super.onStart();
        Log.d(TAG,"onStop() called");
    }

    @Override
    public void onDestroy(){
        super.onStart();
        Log.d(TAG,"onDestroy() called");
    }

}
