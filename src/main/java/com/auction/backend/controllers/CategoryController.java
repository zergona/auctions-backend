package com.auction.backend.controllers;

import com.auction.backend.data.dtos.CategoryDto;
import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.services.CategoryService;
import com.auction.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable UUID id) {
        return categoryService.findById(id);
    }

    @GetMapping
    public ResponseEntity getAll() {
        return categoryService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CategoryDto categoryDto) {
        return categoryService.postNewCategory(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        return categoryService.deleteCategory(id);
    }
}
