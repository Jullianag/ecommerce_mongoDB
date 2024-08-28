package org.meuprojeto.ecommerce_mongodb.models.embedded;

import org.meuprojeto.ecommerce_mongodb.models.entities.User;

public class Author {

    private String name;

    public Author() {
    }

    public Author(String name) {

        this.name = name;
    }

    public Author(User entity) {
        name = entity.getName();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
