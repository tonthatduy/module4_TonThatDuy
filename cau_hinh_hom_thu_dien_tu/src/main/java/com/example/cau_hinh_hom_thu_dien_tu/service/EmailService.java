package com.example.cau_hinh_hom_thu_dien_tu.service;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;
import com.example.cau_hinh_hom_thu_dien_tu.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService implements IEmailService {
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public List<Email> findAll() {
        return emailRepository.findAll();
    }

    @Override
    public Email findById(int id) {
        return emailRepository.findById(id);
    }
}
