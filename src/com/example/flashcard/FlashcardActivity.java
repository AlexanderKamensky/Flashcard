
package com.example.flashcard;



import com.example.flashcard.R;
import com.example.flashcard.R.id;
import com.example.flashcard.R.layout;
import com.example.flashcard.R.string;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FlashcardActivity extends Activity {
	private static final String TAG = "FlashCardActivity";
	private static final String KEY_INDEX = "index";
	
	private Button mFlipButton;
	private Button mNextButton;
	private Button mPrevButton;
	private TextView mQuestionTextView;
	
	private Boolean mIsFlipped;
	
	
	private Flip[] mFlashCards = new Flip[]{
			new Flip(R.string.question_oceans, R.string.answer_oceans),	
			new Flip(R.string.question_mideast, R.string.answer_mideast),
			new Flip(R.string.question_africa, R.string.answer_africa)
		};

	
	private int mCurrentIndex = 0;
	
	private void updateQuestion(){
		int question  = mFlashCards[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
		mIsFlipped = true;
	}
	
	private void goBack(){
		int question  = mFlashCards[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
		mIsFlipped = true;
	}
	
	private void FlipIt(){
		if(mIsFlipped){
			int Answer = mFlashCards[mCurrentIndex].getAnswer();
			mQuestionTextView.setText(Answer);
			mIsFlipped = false;
		}
		else{
			int Question = mFlashCards[mCurrentIndex].getQuestion();
			mQuestionTextView.setText(Question);
			mIsFlipped = true;
		}
		
	}

    @Override
    protected void onCreate(Bundle savedInstanceState){
    	Log.d(TAG, "onCreate(Bundle) called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        
        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);

        mFlipButton = (Button)findViewById(R.id.flip_button);
        mFlipButton.setOnClickListener(new View.OnClickListener()
        {	
			@Override
			public void onClick(View v) {
			FlipIt();
			}
				
        });
        
        mIsFlipped = true;
        


        
       mNextButton = (Button)findViewById(R.id.next_button);
       mNextButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + (mFlashCards.length + 1)) % mFlashCards.length;;
				updateQuestion();
				
			}
        });
      mPrevButton = (Button)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + (mFlashCards.length - 1)) % mFlashCards.length;
				updateQuestion();
				
			}
        });
    
       if(savedInstanceState != null){
    	   mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
       }
        updateQuestion();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
    	super.onSaveInstanceState(savedInstanceState);
    	Log.i(TAG, "onSaveInstanceState");
    	savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	Log.d(TAG, "onStart() called");
    }

    public void onPause(){
    	super.onPause();
    	Log.d(TAG, "onPause() called");
    }
    
    @Override
    public void onResume(){
    	super.onResume();
    	Log.d(TAG, "onResume() called");
    }
    
    @Override
    public void onStop(){
    	super.onStop();
    	Log.d(TAG, "onStop() called");
    }
    
    @Override
    public void onDestroy(){
    	super.onDestroy();
    	Log.d(TAG, "onDestroy() called");
    }



}