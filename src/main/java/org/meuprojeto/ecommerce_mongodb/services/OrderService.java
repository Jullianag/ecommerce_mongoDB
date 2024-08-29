package org.meuprojeto.ecommerce_mongodb.services;

import org.meuprojeto.ecommerce_mongodb.models.dto.OrderDTO;
import org.meuprojeto.ecommerce_mongodb.models.dto.ProductDTO;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Product;
import org.meuprojeto.ecommerce_mongodb.models.entities.Order;
import org.meuprojeto.ecommerce_mongodb.repositories.OrderRepository;
import org.meuprojeto.ecommerce_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public OrderDTO findById(String id) {
        Order entity = getEntityById(id);
        return new OrderDTO(entity);
    }

    public List<OrderDTO> searchProducts(String text) {
        List<Order> result = orderRepository.searchProduct(text);
        return result.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    private Order getEntityById(String id) {
        Optional<Order> result = orderRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}
