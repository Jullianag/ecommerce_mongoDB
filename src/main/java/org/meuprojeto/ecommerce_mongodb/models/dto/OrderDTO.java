package org.meuprojeto.ecommerce_mongodb.models.dto;

import org.meuprojeto.ecommerce_mongodb.models.embedded.Author;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Product;
import org.meuprojeto.ecommerce_mongodb.models.entities.Order;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private String id;
    private Instant moment;

    private Author client;

    private List<Product> products = new ArrayList<>();

    public OrderDTO() {
    }

    public OrderDTO(String id, Instant moment, Author client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public OrderDTO(Order order) {
        id = order.getId();
        moment = order.getMoment();
        client = order.getClient();
        products.addAll(order.getProducts());
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
