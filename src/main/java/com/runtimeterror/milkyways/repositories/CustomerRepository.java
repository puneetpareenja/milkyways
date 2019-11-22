package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Address;
import com.runtimeterror.milkyways.entities.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    public Customer findByEmail(String email);
}
