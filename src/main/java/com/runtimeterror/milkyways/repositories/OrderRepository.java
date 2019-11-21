package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Sales;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Sales, Long> {
}
