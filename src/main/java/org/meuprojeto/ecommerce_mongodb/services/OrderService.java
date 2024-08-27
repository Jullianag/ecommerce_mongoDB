package org.meuprojeto.ecommerce_mongodb.services;

import org.meuprojeto.ecommerce_mongodb.models.dto.OrderDTO;
import org.meuprojeto.ecommerce_mongodb.models.entities.Order;
import org.meuprojeto.ecommerce_mongodb.repositories.OrderRepository;
import org.meuprojeto.ecommerce_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public OrderDTO findById(String id) {
        Order entity = getEntityById(id);
        return new OrderDTO(entity);
    }

    private Order getEntityById(String id) {
        Optional<Order> result = orderRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}
