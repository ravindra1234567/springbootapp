package com.nagarro.test.backend.controller;



import com.nagarro.test.backend.model.Product;
import com.nagarro.test.backend.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // add product
    @PostMapping("/")
    public ResponseEntity<Product> add(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.createProduct(product));
    }

    // update product
    @PutMapping("/")
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return ResponseEntity.ok(this.productService.editProduct(product));
    }

    // get all active products
    @GetMapping("/")
    public ResponseEntity<?> products() {
        return ResponseEntity.ok(this.productService.getAllProduct());
    }

    // get all products
    @GetMapping("/admin")
    public ResponseEntity<?> allProducts() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    // get single product
    @GetMapping("/{pid}")
    public Product product(@PathVariable("pid") Long pid) {
        return this.productService.getSingleProduct(pid);
    }

    // delete product
    @DeleteMapping("/{pid}")
    public void delete(@PathVariable("pid") Long pid) {
        this.productService.deleteProduct(pid);
    }

    // search product 
    @GetMapping("/search/{str}")
    public ResponseEntity<?> search(@PathVariable("str") String str) {
        str = str.replaceAll(" ", "");
        return ResponseEntity.ok(this.productService.search(str));
    }
}
