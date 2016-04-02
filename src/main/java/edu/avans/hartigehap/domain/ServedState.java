package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class ServedState {



    private String stateName = "Served";
    private boolean isCommentAllowed = false;
    private ServedState state;

    public boolean getCommentAllowed(){
        return isCommentAllowed;
    }
    public ServedState getState(){return state;}

}
