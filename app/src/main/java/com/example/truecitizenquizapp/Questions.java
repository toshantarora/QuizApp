package com.example.truecitizenquizapp;

public class Questions
{
    private int answerResId;
    private boolean answerTrue;



    public Questions(int answerResId, boolean answerTrue)
    {
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }
    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
