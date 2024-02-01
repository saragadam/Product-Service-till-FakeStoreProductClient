package com.Product.ProductService.dtos;


//import com.Product.ProductService.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double Price;

//    public void setId(Object id) {
//    }
//
//    public void setTitle(Object title) {
//    }
//
//    public void setImage(Object o) {
//    }
//
//    public void setCategory(Object category) {
//    }
//
//    public void setDescription(Object description) {
//    }
//
//    public void setPrice(Object price) {
//    }
}
