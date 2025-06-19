package com.example.cau_hinh_hom_thu_dien_tu.repository;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> findAll();
    Email findById(int id);

}
