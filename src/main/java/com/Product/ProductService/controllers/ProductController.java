package com.Product.ProductService.controllers;

//import com.Product.ProductService.dtos.ExceptionDto;
import com.Product.ProductService.dtos.GenericProductDto;
//import com.Product.ProductService.services.FakeStoreProductService;
import com.Product.ProductService.exceptions.NotFoundException;
import com.Product.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping()
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();

    }

    private ProductService productService;
    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
        return productService.getProductById(id);

    }

    public  void updateProductById(){

    }
    @PostMapping()
    public  GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);

    }

    @DeleteMapping("{id}")
    public GenericProductDto deleteProduct(@PathVariable("id") Long id){

        return productService.deleteProduct(id);
    }

//    This is specific to this controller
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
//         return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND,
//                 notFoundException.getMessage()), HttpStatus.NOT_FOUND);
//
//    }


}
