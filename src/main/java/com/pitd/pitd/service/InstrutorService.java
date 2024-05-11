package com.pitd.pitd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitd.pitd.entity.Instrutor;
import com.pitd.pitd.repository.InstrutorRepository;

@Service
public class InstrutorService {
    @Autowired
    InstrutorRepository instrutorRepository;

    public List<Instrutor> getAll() {
        return instrutorRepository.findAll();
    }

    public Instrutor getById(Integer id) {
        return instrutorRepository.findById(id).orElse(null);
    }

    public Instrutor saveInstrutor(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }
}
