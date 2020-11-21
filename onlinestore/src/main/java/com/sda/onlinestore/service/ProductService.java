package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.repository.ProductRepository;
import com.sda.onlinestore.transformers.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTransformer productTransformer;

    public void addProduct(ProductDto productDto){
        Product product = productTransformer.transform(productDto);
        productRepository.save(product);
    }

    public List<ProductDto> getProducts(){

        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product product:products){
            ProductDto productDto = productTransformer.transformReversed(product);
            productDtoList.add(productDto);
        }
        return productDtoList;
    }
}
