package org.meuprojeto.ecommerce_mongodb.config;

import jakarta.annotation.PostConstruct;
import org.meuprojeto.ecommerce_mongodb.models.entities.User;
import org.meuprojeto.ecommerce_mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {

        userRepository.deleteAll();

        User sandra = new User(null, "Sandra Silva", "sandra@gmail.com");
        User robert = new User(null, "Robert Brown", "robert@gmail.com");

        userRepository.saveAll(Arrays.asList(sandra, robert));
    }
}
