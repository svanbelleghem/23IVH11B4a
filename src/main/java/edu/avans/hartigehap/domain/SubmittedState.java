package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class SubmittedState {



    private String stateName = "Submitted";
    private boolean isCommentAllowed = false;
    private SubmittedState state;

    public boolean getCommentAllowed(){

        return isCommentAllowed;
    }

    public SubmittedState getState(){
        return state;
    }

}
