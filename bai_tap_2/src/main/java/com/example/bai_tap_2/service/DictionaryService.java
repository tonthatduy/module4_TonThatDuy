package com.example.bai_tap_2.service;

import com.example.bai_tap_2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findByKey(String string) {
        return dictionaryRepository.findByKey(string);
    }
}
