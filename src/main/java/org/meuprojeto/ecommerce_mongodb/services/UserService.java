package org.meuprojeto.ecommerce_mongodb.services;

import org.meuprojeto.ecommerce_mongodb.models.dto.UserDTO;
import org.meuprojeto.ecommerce_mongodb.models.entities.User;
import org.meuprojeto.ecommerce_mongodb.repositories.UserRepository;
import org.meuprojeto.ecommerce_mongodb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO findById(String id) {
        User entity = getEntityById(id);
        return new UserDTO(entity);
    }

    private User getEntityById(String id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }
}
