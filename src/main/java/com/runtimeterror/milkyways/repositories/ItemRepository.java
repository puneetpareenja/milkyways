package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
