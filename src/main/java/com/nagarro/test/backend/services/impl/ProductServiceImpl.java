package com.nagarro.test.backend.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nagarro.test.backend.model.Product;
import com.nagarro.test.backend.repo.ProductRepository;
import com.nagarro.test.backend.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        // TODO Auto-generated method stub
        return new ArrayList<>(this.productRepository.findByStatusTrue());
    }

    @Override
    public Product getSingleProduct(Long pid) {
        // TODO Auto-generated method stub
        return this.productRepository.findById(pid).get();
    }

    @Override
    public Product editProduct(Product product) {
        // TODO Auto-generated method stub
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long pid) {
        // TODO Auto-generated method stub

        this.productRepository.deleteById(pid);;
        
    }

    @Override
    public List<Product> search(String str) {
        // TODO Auto-generated method stub
        return this.productRepository.findBySearch(str);
    }

    @Override
    public Long count() {
        // TODO Auto-generated method stub
        return this.productRepository.count();
    }

    @Override
    public Set<Product> getProducts() {
        // TODO Auto-generated method stub
        return new HashSet<>( this.productRepository.findAll());
    }

}
