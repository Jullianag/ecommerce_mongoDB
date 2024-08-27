package org.meuprojeto.ecommerce_mongodb.controllers;

import org.meuprojeto.ecommerce_mongodb.models.dto.OrderDTO;
import org.meuprojeto.ecommerce_mongodb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable String id) {
        OrderDTO dto = orderService.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}
