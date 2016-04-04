package edu.avans.hartigehap.domain;

/**
 * Created by Edem on 01-Apr-16.
 */
public class PlannedState extends State {



    private PlannedState state;

    public PlannedState() {
        super(StateType.PLANNED);
    }


    public void setState(PlannedState state) {
        this.state = state;
    }



}
