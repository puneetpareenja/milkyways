package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
