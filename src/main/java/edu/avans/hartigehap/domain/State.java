package edu.avans.hartigehap.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by Edem on 18-Mar-16.
 */
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true, of = {"stateType"})
@Table(name = "STATE")
public class State extends DomainObject implements Serializable {

    public enum StateType{

        ACCEPTED("Accepted", true),
        CREATED("Created", true),
        SUBMITTED("Submitted", false),
        PLANNED("Planned", true ),
        SERVED("Served",false ),
        PREPARED("Prepared", false );

        private String name;
        private boolean mayComment;

        StateType(String name, boolean mayComment) {
            this.name = name;
            this.mayComment = mayComment;
        }


        public boolean isCommentable() {
            return mayComment;
        }
    }

    @Transient
    private StateType stateType;

    public State(StateType stateType) {
        this.stateType = stateType;
    }

    @Transient
    public boolean isCommentable(){
        return stateType.mayComment;
    }
}
