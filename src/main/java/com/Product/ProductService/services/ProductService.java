package com.Product.ProductService.services;

import com.Product.ProductService.dtos.GenericProductDto;
import com.Product.ProductService.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProduct(Long id);
}
