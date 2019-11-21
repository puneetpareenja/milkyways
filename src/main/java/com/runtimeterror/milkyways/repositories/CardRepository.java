package com.runtimeterror.milkyways.repositories;

import com.runtimeterror.milkyways.entities.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
