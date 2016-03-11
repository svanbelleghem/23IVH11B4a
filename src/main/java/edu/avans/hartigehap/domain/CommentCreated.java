package edu.avans.hartigehap.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Edem on 11-Mar-16.
 */
@Entity
@Table(name = "Comments")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class CommentCreated {
    private State state;
    private String comment;
    private Boolean commentAllowed;


    public void setComment(String comment){
        this.comment = comment;
    }

    public String getComment(){

        return comment;

    }

    public State getState(){

        return state;

    }

    public void setState(State state){

        this.state = state;
    }

    public Boolean getNextComment(){

        state.getNext();

        if(state.name.equals("Created") || state.name.equals("Accepted")){
            commentAllowed = true;
        }

        else{
            commentAllowed = false;
        }

        return commentAllowed;

    }
}
