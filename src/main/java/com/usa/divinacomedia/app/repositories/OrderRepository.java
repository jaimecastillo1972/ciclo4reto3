package com.usa.divinacomedia.app.repositories;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.repositories.Crud.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository repository;

    public List<Order> getAll(){
        return (List<Order>) repository.findAll();
    }

    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }

    public Order save(Order order){
        return repository.save(order);
    }

    public void update(Order order) {
        repository.save(order);
    }

    public void delete(Order order){
        repository.delete(order);
    }

    public Optional<Order> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }

    public List<Order> findByZone(String zona) {
        return repository.findByZone(zona);
    }
}
