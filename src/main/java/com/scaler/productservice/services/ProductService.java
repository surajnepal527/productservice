package com.scaler.productservice.services;

import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
     Product getProductById(Long id);
     List<Product> getAllProducts();
     Product updateProduct();
     Product replaceProduct();
     Product createProduct();
     void deleteProduct();

}
