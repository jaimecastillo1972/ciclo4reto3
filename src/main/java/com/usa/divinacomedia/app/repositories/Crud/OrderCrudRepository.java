package com.usa.divinacomedia.app.repositories.Crud;

import com.usa.divinacomedia.app.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(String zone);

    @Query("{'salesMan.id':?0}")
    List<Order> findBySalesManId(final Integer id);

    //Retorna las ordenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
