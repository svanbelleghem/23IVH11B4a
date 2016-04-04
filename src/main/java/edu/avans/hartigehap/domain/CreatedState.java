package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class CreatedState extends State {

    private CreatedState state;

    public CreatedState() {
        super(StateType.CREATED);
    }

    public void setState(CreatedState state) {
        this.state = state;
    }

}
