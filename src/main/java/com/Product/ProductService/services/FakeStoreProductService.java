package com.Product.ProductService.services;
import com.Product.ProductService.thirdpartyclients.fakestore.FakeStoreProductClient;
import com.Product.ProductService.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import com.Product.ProductService.dtos.GenericProductDto;
import com.Product.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {
   private FakeStoreProductClient fakeStoreProductClient;
    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient = fakeStoreProductClient;
    }
    public GenericProductDto convertFakeStoreToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());

        return  genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

        return  convertFakeStoreToGenericProductDto(fakeStoreProductClient.getProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto product){

        return convertFakeStoreToGenericProductDto(fakeStoreProductClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {


        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos){
            GenericProductDto genericProductDto = convertFakeStoreToGenericProductDto(fakeStoreProductDto);
            genericProductDtos.add(genericProductDto);
        }


        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {




        return convertFakeStoreToGenericProductDto(fakeStoreProductClient.deleteProduct(id));


    }
}
