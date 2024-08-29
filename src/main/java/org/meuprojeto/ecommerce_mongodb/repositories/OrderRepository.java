package org.meuprojeto.ecommerce_mongodb.repositories;

import org.meuprojeto.ecommerce_mongodb.models.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    // List<Order> findByClientContainingIgnoreCase(String text);

    @Query("{ 'products.name': { $regex: ?0, $options: 'i' } }")
    List<Order> searchProduct(String text);


}
