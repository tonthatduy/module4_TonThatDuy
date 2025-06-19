package com.example.cau_hinh_hom_thu_dien_tu.repository;

import com.example.cau_hinh_hom_thu_dien_tu.model.Email;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {
    private static List<Email> emailList = new ArrayList<>();

    static {
        emailList.add(new Email(1, "English", 10, true, "DuyBeo"));
        emailList.add(new Email(2, "Vietnamese", 10, true, "DuyyBeo"));
        emailList.add(new Email(3, "Japanese", 20, false, "DuiBeo"));
        emailList.add(new Email(4, "Chinese", 15, true, "DiiBeo"));
    }

    @Override
    public List<Email> findAll() {
        return emailList;
    }

    @Override
    public Email findById(int id) {
        for (int i = 0; i < emailList.size(); i++) {
            if (emailList.get(i).getId() == id) {
                return emailList.get(i);
            }
        }
        return null;
    }
}
