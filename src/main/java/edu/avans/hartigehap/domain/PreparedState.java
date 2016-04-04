package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 17-Mar-16.
 */
public class PreparedState extends State {



    private PlannedState state;

    public PreparedState() {
        super(StateType.PREPARED);
    }

    public void setState(PlannedState state) {
        this.state = state;
    }



}
