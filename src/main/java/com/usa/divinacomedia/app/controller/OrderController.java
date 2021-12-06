package com.usa.divinacomedia.app.controller;

import com.usa.divinacomedia.app.model.Order;
import com.usa.divinacomedia.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/all")
    public List<Order> getOrders(){
        return service.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return service.save(order);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
}
