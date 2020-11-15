package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.entity.ProductType;

import javax.persistence.*;

public class ProductDTO {

    private String description;
    private String thumbnail;
    private Category category;
    private int price;
    private ProductType productType;
    private Author author;

    public ProductDTO(String description, String thumbnail, Category category, int price, ProductType productType, Author author) {
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.price = price;
        this.productType = productType;
        this.author = author;
    }

    public ProductDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
