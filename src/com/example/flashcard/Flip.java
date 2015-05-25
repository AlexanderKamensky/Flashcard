package com.example.flashcard;

public class Flip {
	private int mQuestion;
	private int mAnswer;
	
	
	
	public Flip(int question, int answer){
		mQuestion = question;
		mAnswer = answer;
	}
	public int getQuestion(){
		return mQuestion;
	}
	public void setQuestion(int Question){
		mQuestion = Question;
	}
	public int getAnswer(){
		return mAnswer;
	}
	public void setAnswer(int answer){
		mAnswer = answer;
	}
}
