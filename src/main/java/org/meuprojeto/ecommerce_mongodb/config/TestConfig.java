package org.meuprojeto.ecommerce_mongodb.config;

import jakarta.annotation.PostConstruct;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Author;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Product;
import org.meuprojeto.ecommerce_mongodb.models.entities.Order;
import org.meuprojeto.ecommerce_mongodb.models.entities.User;
import org.meuprojeto.ecommerce_mongodb.repositories.OrderRepository;
import org.meuprojeto.ecommerce_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostConstruct
    public void init() {

        userRepository.deleteAll();
        orderRepository.deleteAll();

        User sandra = new User(null, "Sandra Silva", "sandra@gmail.com");
        User robert = new User(null, "Robert Brown", "robert@gmail.com");

        userRepository.saveAll(Arrays.asList(sandra, robert));

        Order order1 = new Order(null, Instant.parse("2024-02-13T11:15:01Z"), new Author(sandra));
        Order order2 = new Order(null, Instant.parse("2024-03-23T09:40:08Z"), new Author(robert));

        Product product1 = new Product("Computador", 4000.0);
        Product product2 = new Product("Celular", 2000.0);
        Product product3 = new Product("Playstation 5", 5000.0);

        order1.getProducts().addAll(Arrays.asList(product1, product2, product3));
        order2.getProducts().add(product3);

        orderRepository.saveAll(Arrays.asList(order1, order2));

        sandra.getOrders().add(order1);
        robert.getOrders().add(order2);
        userRepository.saveAll(Arrays.asList(sandra, robert));

    }
}
