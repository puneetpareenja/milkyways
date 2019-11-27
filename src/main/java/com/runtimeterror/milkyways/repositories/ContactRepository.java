package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Contact;
import com.runtimeterror.milkyways.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long> {

}
