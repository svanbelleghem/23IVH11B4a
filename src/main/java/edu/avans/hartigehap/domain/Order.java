package edu.avans.hartigehap.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 
 * @author Erco
 */
@Entity
//@NamedQuery(name = "Order.findSubmittedOrders", query = "SELECT o FROM Order o "
//        + "WHERE o.orderState.StateType = edu.avans.hartigehap.domain.State.StateType.SUBMITTED "
//        + "AND o.bill.diningTable.restaurant = :restaurant "
//        + "ORDER BY o.submittedTime")
// to prevent collision with MySql reserved keyword
@Table(name = "ORDERS")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true, of = {"orderState", "orderItems"})
public class Order extends DomainObject {
    private static final long serialVersionUID = 1L;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    private State orderState;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date preparedTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date servedTime;

    @ManyToOne
    private Comment comment;

    // unidirectional one-to-many relationship.
    @OneToMany(cascade = javax.persistence.CascadeType.ALL)
    private Collection<OrderItem> orderItems = new ArrayList<OrderItem>();

    @ManyToOne()
    private Bill bill;

    public Order() {
        orderState = new CreatedState();
    }

    /* business logic */

    @Transient
    public boolean isSubmittedOrSuccessiveState() {
        return orderState.getStateType() != State.StateType.CREATED;
    }

    // transient annotation, because methods starting with are recognized by JPA
    // as properties
    @Transient
    public boolean isEmpty() {
        return orderItems.isEmpty();
    }

    public void addOrderItem(MenuItem menuItem) {
        Iterator<OrderItem> orderItemIterator = orderItems.iterator();
        boolean found = false;
        while (orderItemIterator.hasNext()) {
            OrderItem orderItem = orderItemIterator.next();
            if (orderItem.getMenuItem().equals(menuItem)) {
                orderItem.incrementQuantity();
                found = true;
                break;
            }
        }
        if (!found) {
            OrderItem orderItem = new OrderItem(menuItem, 1);
            orderItems.add(orderItem);
        }
    }

    public void deleteOrderItem(MenuItem menuItem) {
        Iterator<OrderItem> orderItemIterator = orderItems.iterator();
        boolean found = false;
        while (orderItemIterator.hasNext()) {
            OrderItem orderItem = orderItemIterator.next();
            if (orderItem.getMenuItem().equals(menuItem)) {
                found = true;
                if (orderItem.getQuantity() > 1) {
                    orderItem.decrementQuantity();
                } else {
                    // orderItem.getQuantity() == 1
                    orderItemIterator.remove();
                }
                break;
            }
        }
        if (!found) {
            // do nothing
        }
    }

    public void submit() throws StateException {
        if (isEmpty()) {
            throw new StateException("not allowed to submit an empty order");
        }

        // this can only happen by directly invoking HTTP requests, so not via
        // GUI
        if (orderState.getStateType() != State.StateType.CREATED) {
            throw new StateException("not allowed to submit an already submitted order");
        }
        submittedTime = new Date();
        orderState = new SubmittedState();



    }

    public void plan() throws StateException {

        // this can only happen by directly invoking HTTP requests, so not via
        // GUI
        if (orderState.getStateType() != State.StateType.SUBMITTED) {
            throw new StateException("not allowed to plan an order that is not in the submitted stateType");
        }

        plannedTime = new Date();
        orderState = new PlannedState();
    }

    public void prepared() throws StateException {

        // this can only happen by directly invoking HTTP requests, so not via
        // GUI
        if (orderState.getStateType() != State.StateType.PLANNED) {
            throw new StateException(
                    "not allowed to change order stateType to prepared, if it is not in the planned stateType");
        }

        preparedTime = new Date();
        orderState = new PreparedState();
    }

    public void served() throws StateException {

        // this can only happen by directly invoking HTTP requests, so not via
        // GUI
        if (orderState.getStateType() != State.StateType.PREPARED) {
            throw new StateException("not allowed to change order stateType to served, if it is not in the prepared stateType");
        }

        servedTime = new Date();
        orderState = new ServedState();
    }

    public State getOrderState(){
        return this.orderState;
    }

    @Transient
    public int getPrice() {
        int price = 0;
        Iterator<OrderItem> orderItemIterator = orderItems.iterator();
        while (orderItemIterator.hasNext()) {
            price += orderItemIterator.next().getPrice();
        }
        return price;
    }
}
