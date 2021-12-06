package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
}
