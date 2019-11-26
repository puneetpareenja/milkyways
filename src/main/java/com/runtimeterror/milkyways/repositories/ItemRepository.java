package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    public List<Item> findAllByNameContainingIgnoreCase(String name);
}
