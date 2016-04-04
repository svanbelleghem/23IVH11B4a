package edu.avans.hartigehap.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import edu.avans.hartigehap.domain.DiningTable;
import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.Restaurant;
import edu.avans.hartigehap.domain.State;
import org.apache.tools.ant.taskdefs.condition.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// this impl class must be in the same package as the interfaces
// you could call this a spring limitation
@Component
public class OrderRepositoryImpl implements OrderRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    // this is a custom method for which Spring cannot create an implementation
    // so we need to make our own repository implementation!
    public List<Order> findSubmittedOrdersForRestaurant(Restaurant restaurant) {
        //return em.createNamedQuery("Order.findSubmittedOrders", Order.class).setParameter("restaurant", restaurant)
         //       .getResultList();

        return new ArrayList<>();
    }

}
