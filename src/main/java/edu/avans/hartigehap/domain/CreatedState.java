package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class CreatedState {



    private String stateName = "Created";
    private boolean isCommentAllowed = true;
    private CreatedState state;

    public boolean getCommentAllowed(){
        return isCommentAllowed;
    }
    public CreatedState getState(){return state;}

}
