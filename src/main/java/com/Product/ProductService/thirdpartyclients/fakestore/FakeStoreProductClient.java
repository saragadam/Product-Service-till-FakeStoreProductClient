package com.Product.ProductService.thirdpartyclients.fakestore;

import com.Product.ProductService.dtos.GenericProductDto;
import com.Product.ProductService.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import com.Product.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductClient {
    private String productUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductUrl = "https://fakestoreapi.com/products/";

    private String requestProductUrl = "https://fakestoreapi.com/products/";

    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                productUrl,
                FakeStoreProductDto.class,
                id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if(fakeStoreProductDto==null){
            throw new NotFoundException("product with id: " + id + " not found");
        }



        return  fakeStoreProductDto;
    }

    public FakeStoreProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity
                (createProductUrl,
                        product,
                        FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();



        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate
                .getForEntity(requestProductUrl,FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();



        return Arrays.asList(fakeStoreProductDtos);
    }


    public FakeStoreProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.
                exchange(productUrl, HttpMethod.DELETE,null,FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();



        return  fakeStoreProductDto;


    }

}
