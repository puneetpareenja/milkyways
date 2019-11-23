package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.CustomerAddress;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<CustomerAddress, Long> {
}
