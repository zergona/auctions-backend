package com.auction.backend.services;

import com.auction.backend.data.dtos.BidDto;
import com.auction.backend.data.dtos.CategoryDto;
import com.auction.backend.data.dtos.UserDto;
import com.auction.backend.data.models.Bid;
import com.auction.backend.data.models.Category;
import com.auction.backend.data.models.User;
import com.auction.backend.repositories.BidRepository;
import com.auction.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public ResponseEntity<Bid> findAll() {
        Iterable<Category> all = categoryRepository.findAll();
        return new ResponseEntity(all, HttpStatus.OK);
    }

    public ResponseEntity<Bid> findById(@PathVariable UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return new ResponseEntity(new CategoryDto(category.get()), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Bid> postNewCategory(@RequestBody CategoryDto categoryDto) {
        categoryRepository.save(new Category());
        return new ResponseEntity(HttpStatus.OK);
    }

    public ResponseEntity<Category> updateCategory(UUID id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).get();
        if (category != null) {
            category.setName(categoryDto.getName());
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Bid> deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
