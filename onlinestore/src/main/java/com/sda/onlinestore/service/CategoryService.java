package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.AuthorDto;
import com.sda.onlinestore.dto.CategoryDto;
import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.repository.AuthorRepository;
import com.sda.onlinestore.repository.CategoryRepository;
import com.sda.onlinestore.transformers.AuthorTransformer;
import com.sda.onlinestore.transformers.CategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryTransformer categoryTransformer;

    public void addCategory(CategoryDto categoryDto){
        Category category = categoryTransformer.transform(categoryDto);
        categoryRepository.save(category);
    }

    public List<CategoryDto> getCategories(){

        List<Category> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtosList = new ArrayList<>();
        for(Category category:categories){
            CategoryDto categoryDto = categoryTransformer.transformReversed(category);
            categoryDtosList.add(categoryDto);
        }
        return categoryDtosList;
    }
}
