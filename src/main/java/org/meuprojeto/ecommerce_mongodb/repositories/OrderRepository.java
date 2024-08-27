package org.meuprojeto.ecommerce_mongodb.repositories;

import org.meuprojeto.ecommerce_mongodb.models.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
