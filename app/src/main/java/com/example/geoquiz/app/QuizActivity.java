package com.example.geoquiz.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class QuizActivity extends ActionBarActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mQuestionTextView;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
      new TrueFalse(R.string.question_1,false),
      new TrueFalse(R.string.question_2,true),
      new TrueFalse(R.string.question_3,true)
    };
    private int mCurrentIndex = 0;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue)
    {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        int messageResId = 0;
        //System.out.println(""+userPressedTrue+ " " + answerIsTrue);
        if(userPressedTrue == answerIsTrue)
        {
            messageResId = R.string.true_toast;
        }
        else
        {
            messageResId = R.string.false_toast;
        }

        Toast.makeText(this, messageResId,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY,0);
        }
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button)findViewById(R.id.buttonTrue);
        mTrueButton.setOnClickListener( new View.OnClickListener(){
           @Override
           public void onClick(View v){
               checkAnswer(true);
           }
        });

        mFalseButton = (Button)findViewById(R.id.buttonFalse);
        mFalseButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });

        mNextButton = (Button)findViewById(R.id.buttonNext);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mPreviousButton = (Button)findViewById(R.id.buttonPrevious);
        mPreviousButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                if(mCurrentIndex==0) mCurrentIndex=mQuestionBank.length;
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mQuestionTextView = (TextView)findViewById(R.id.questionTextView);
        updateQuestion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
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

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG,"onSavedInstance");
        savedInstanceState.putInt(KEY,mCurrentIndex);
    }
}
