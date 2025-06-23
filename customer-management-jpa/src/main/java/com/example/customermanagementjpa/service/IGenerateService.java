package com.example.customermanagementjpa.service;

import java.util.List;

public interface IGernerateService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Long id);

    void remove(Long id);
}
