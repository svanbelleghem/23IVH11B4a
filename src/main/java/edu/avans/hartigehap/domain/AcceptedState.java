package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class AcceptedState extends State {

    private AcceptedState state;

    public AcceptedState() {
        super(StateType.ACCEPTED);
    } // Je kunt toch al doen getStateType

    public void setState(AcceptedState state) {
        this.state = state;
    }
}
