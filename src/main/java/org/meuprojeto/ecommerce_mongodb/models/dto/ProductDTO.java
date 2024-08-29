package org.meuprojeto.ecommerce_mongodb.models.dto;

import org.meuprojeto.ecommerce_mongodb.models.embedded.Author;
import org.meuprojeto.ecommerce_mongodb.models.embedded.Product;

public class ProductDTO {

    private String name;
    private Double price;


    public ProductDTO(){
    }

    public ProductDTO(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public ProductDTO(Product product) {
        name = product.getName();
        price = product.getPrice();
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

}
