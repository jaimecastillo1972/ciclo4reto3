package com.usa.divinacomedia.app.services;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> getAll(){
        return repository.getAll();
    }

    public Optional<Order> getOrder(Integer id){
        return repository.getOrder(id);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            Optional<Order> existsOrder = repository.getOrder(order.getId());
            if (existsOrder.isPresent()) { //si coloca .isEmpty debo cambiar 2x1
                return order; //cambio2xcambio1
            } else {
                return repository.save(order);//cambio1xcambio2

            }
        }
    }

    public Order update(Order order){
        Optional<Order> existsOrder=repository.getOrder(order.getId());
        if (existsOrder.isPresent()){
            if (order.getId()!=null){
                existsOrder.get().setId(order.getId());
            }
            if (order.getRegisterDay()!=null){
                existsOrder.get().setRegisterDay(order.getRegisterDay());
            }
            if (order.getStatus()!=null){
                existsOrder.get().setStatus(order.getStatus());
            }
            if (order.getSalesMan()!=null){
                existsOrder.get().setSalesMan(order.getSalesMan());
            }
            if (order.getProducts()!=null){
                existsOrder.get().setProducts(order.getProducts());
            }
            if (order.getQuantities()!=null){
                existsOrder.get().setQuantities(order.getQuantities());
            }
            return repository.save(existsOrder.get());
    }else {
            return order;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean=repository.getOrder(id).map(order->{
            repository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zona){
        return repository.findByZone(zona);
    }
}
