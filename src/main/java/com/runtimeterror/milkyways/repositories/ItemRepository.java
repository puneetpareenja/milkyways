package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    public List<Item> findAllByNameContainingIgnoreCase(String name);

    public List<Item> findAllByGlutenfreeIs(boolean type);

    public List<Item> findAllBySugarfreeIs(boolean type);

    public List<Item> findAllByDairyfreeIs(boolean type);

    public List<Item> findAllByVegetarianIs(boolean type);

    public List<Item> findAllByTypeIs(boolean type);

    public List<Item> findAllByStore_Storeid(long id);
}
