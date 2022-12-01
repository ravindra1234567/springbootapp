package com.nagarro.test.backend.services;

import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Product;


public interface ProductService {
    
    // create product
    public Product createProduct(Product product);
    
    // update product
    public Product editProduct(Product product);

    // get all active  product
    public List<Product> getAllProduct();

    // get all products
    public Set<Product> getProducts();

    // get single product
    public Product getSingleProduct(Long pid);

    // search product
    public List<Product> search(String str); 

    // delete product 
    public void deleteProduct(Long pid);

    // total product 
    public Long count();

    
}
