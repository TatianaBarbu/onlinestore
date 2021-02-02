package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.enums.ProductType;

import javax.persistence.*;

public class ProductDto {

    private String description;
    private String thumbnail;
    private CategoryDto category;
    private int price;
    private Author author;

    public ProductDto(String description, String thumbnail, CategoryDto category, int price, Author author) {
        this.description = description;
        this.thumbnail = thumbnail;
        this.category = category;
        this.price = price;
        this.author = author;
    }

    public ProductDto() {
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

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
