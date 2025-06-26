package com.example.validate_form.service;

import com.example.validate_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void add(User user);
}
