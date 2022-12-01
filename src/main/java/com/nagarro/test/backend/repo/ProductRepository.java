package com.nagarro.test.backend.repo;

import java.util.List;

import javax.persistence.Entity;

import com.nagarro.test.backend.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT p from Product p Where INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 or INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 or INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 or INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 or INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 or INSTR(Concat(p.name,p.brand,p.content,p.productCode),:search)>0 ")
    public List<Product> findBySearch(@Param("search") String search);

    // @Query("select p from Product where p.status = 'true' ")
    // public List<Product> findByStatus();
    @Query
    public List<Product> findByStatusTrue();
}
