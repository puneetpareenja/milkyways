package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
