package com.example.demo_quan_ly_san_pham.repository;

import com.example.demo_quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void saveOrUpdate(Product product);

    Product findById(int id);


    void remove(int id);
    List<Product> searchByName(String keyword);
}
