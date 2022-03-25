package br.com.blecaute.store.controller;

import br.com.blecaute.store.dto.order.OrderCreateDTO;
import br.com.blecaute.store.dto.order.OrderUpdateDTO;
import br.com.blecaute.store.model.Order;
import br.com.blecaute.store.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Order> findAll() {
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user/{id}")
    public List<Order> findByUser(@PathVariable Long id) {
        return service.findByUserId(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Order create(@RequestBody OrderCreateDTO order) {
        return service.save(order);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody OrderUpdateDTO order) {
        return service.update(id, order);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
