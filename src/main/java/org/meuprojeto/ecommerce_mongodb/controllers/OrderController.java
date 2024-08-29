package org.meuprojeto.ecommerce_mongodb.controllers;

import org.meuprojeto.ecommerce_mongodb.models.dto.OrderDTO;
import org.meuprojeto.ecommerce_mongodb.models.dto.ProductDTO;
import org.meuprojeto.ecommerce_mongodb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/findproducts")
    public ResponseEntity<List<OrderDTO>> findProducts(@RequestParam(value = "text", defaultValue = "")
                                                       String text) {
        List<OrderDTO> list = orderService.searchProducts(text);
        return ResponseEntity.ok(list);
    }

}
