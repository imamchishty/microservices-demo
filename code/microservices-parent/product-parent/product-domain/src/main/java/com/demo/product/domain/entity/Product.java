package com.demo.product.domain.entity;

import javax.persistence.*;

/**
 * Product entity.
 *
 * @author imamchishty
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;

    private String manufacturer;

    private String name;

    @Column(name = "short_code", unique = true)
    private String shortCode;

    @Column(scale = 2)
    private double weight;

    @Column(scale = 2, name = "price_markup")
    private double priceMarkUp;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public double getPriceMarkUp() {
        return priceMarkUp;
    }

    public void setPriceMarkUp(double priceMarkUp) {
        this.priceMarkUp = priceMarkUp;
    }
}
