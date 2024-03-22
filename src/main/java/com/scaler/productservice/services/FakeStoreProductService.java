package com.scaler.productservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.productservice.dtos.FakeStoreProductDto;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
       Product product = new Product();
       product.setId(fakeStoreProductDto.getId());
       product.setTitle(fakeStoreProductDto.getTitle());
       product.setDescription(fakeStoreProductDto.getDescription());
       product.setImage(fakeStoreProductDto.getImage());
       product.setPrice(fakeStoreProductDto.getPrice());
       product.setRating(fakeStoreProductDto.getRating());
       Category category = new Category();
       category.setTitle(fakeStoreProductDto.getCategory());
       product.setCategory(category);
       return product;
    }

    @Override
    public Product getProductById(Long id) {
        //call the fake store API to get the product with given ID here.
      FakeStoreProductDto fakeStoreProductDto =  restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
       //convert fakeStoreProductDto to product object
        if(fakeStoreProductDto ==  null){
            return null;
        }
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        var products = new ArrayList<Product>();
        var fakeStoreProductDtos =  restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
       for(FakeStoreProductDto fakeStoreProductDto :fakeStoreProductDtos){
           products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
       }
        return products;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
