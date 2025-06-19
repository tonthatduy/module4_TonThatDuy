package com.example.cau_hinh_hom_thu_dien_tu.service;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;

import java.util.List;

public interface IEmailService {
    List<Email> findAll();
    Email findById(int id);
}
