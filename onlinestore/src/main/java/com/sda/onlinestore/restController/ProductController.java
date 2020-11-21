package com.sda.onlinestore.restController;

import com.sda.onlinestore.dto.ProductDto;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/api/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductDto productDto){
        productService.addProduct(productDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/getProducts")
    public ResponseEntity getProducts(){
        List<ProductDto> productDtoList = productService.getProducts();
        return ResponseEntity.ok(productDtoList);
    }
}
