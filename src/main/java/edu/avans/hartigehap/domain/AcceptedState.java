package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class AcceptedState {


    private String stateName = "Accepted";
    private boolean isCommentAllowed = true;
    private AcceptedState state;

    public boolean getCommentAllowed(){
        return isCommentAllowed;
    }
    public AcceptedState getState(){return state;}

}
