package org.meuprojeto.ecommerce_mongodb.models.entities;

import org.meuprojeto.ecommerce_mongodb.models.embedded.Author;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private Instant moment;

    private Author client;

    private List<Product> products = new ArrayList<>();

    public Order() {
    }

    public Order(String id, Instant moment, Author client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Author getClient() {
        return client;
    }

    public void setClient(Author client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }
}
