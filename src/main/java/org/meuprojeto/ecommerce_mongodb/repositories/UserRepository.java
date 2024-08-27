package org.meuprojeto.ecommerce_mongodb.repositories;

import org.meuprojeto.ecommerce_mongodb.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
