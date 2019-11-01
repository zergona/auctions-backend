package com.auction.backend.data.dtos;

import com.auction.backend.data.models.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Data
@NoArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;

    public CategoryDto(Category category){
        id = category.getId();
        name = category.getName();
    }
}
