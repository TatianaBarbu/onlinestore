package com.sda.onlinestore.restController;

import com.sda.onlinestore.dto.AuthorDto;
import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.service.AuthorService;
import com.sda.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/api/addCategory")
    public ResponseEntity addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(categoryDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/api/getCategories")
    public ResponseEntity getCategories(){
        List<CategoryDto> categoryDtoList = categoryService.getCategories();
        return ResponseEntity.ok(categoryDtoList);
    }
}
