package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class SubmittedState extends State {

    private SubmittedState state;

    public SubmittedState() {
        super(StateType.SUBMITTED);
    }

    public void setState(SubmittedState state) {
        this.state = state;
    }

}
