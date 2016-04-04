package edu.avans.hartigehap.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.domain.*;
import edu.avans.hartigehap.domain.*;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, OrderRepositoryCustom {

    // Spring creates an implementation based one the method name
    // in this case all orders for which:
    // order.getOrderStatus() == orderStatus
    // AND
     //order.getBill().getDiningTable().getRestaurant() == restaurant
    List<Order> findByOrderStatusAndBillDiningTableRestaurant(State.StateType orderStatus, Restaurant restaurant,
            Sort sort);

}
