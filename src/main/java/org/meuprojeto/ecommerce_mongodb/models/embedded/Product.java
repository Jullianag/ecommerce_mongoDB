package org.meuprojeto.ecommerce_mongodb.models.embedded;

import org.springframework.data.annotation.Id;

public class Product {

    private String name;
    private Double price;

    private Author client;

    public Product() {
    }

    public Product(String name, Double price, Author client) {
        this.name = name;
        this.price = price;
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Author getClient() {
        return client;
    }

    public void setClient(Author client) {
        this.client = client;
    }
}
