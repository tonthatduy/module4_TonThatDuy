package com.example.quan_ly_san_pham.repository;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);


    void remove(int id);
    List<Product> searchByName(String keyword);
}
