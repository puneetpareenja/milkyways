package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Store;
import org.springframework.data.repository.CrudRepository;

import com.runtimeterror.milkyways.entities.Item;
import java.util.List;

public interface StoreRepository extends CrudRepository<Store, Long> {

}
