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
public class SubcategoryDto {
    private UUID id;
    private String name;
    private UUID categoryId;

    public SubcategoryDto(Subcategory subcategory){
        id = category.getId();
        name = category.getName();
        categoryId = category.getCategoryId;
    }
}
