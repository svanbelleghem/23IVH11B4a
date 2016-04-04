package edu.avans.hartigehap.domain;

import javax.xml.stream.events.StartElement;

/**
 * Created by Edem on 17-Mar-16.
 */
public class ServedState extends State{

    private ServedState state;

    public ServedState() {
        super(StateType.SERVED);
    }

    public void setState(ServedState state) {
        this.state = state;
    }

}
