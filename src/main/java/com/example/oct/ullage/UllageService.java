package com.example.oct.ullage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UllageService implements IUllageService{

    private final UllageRepository repository;

    public Ullage get(Long id) {
        return repository.findById(id).get();
    }
}
