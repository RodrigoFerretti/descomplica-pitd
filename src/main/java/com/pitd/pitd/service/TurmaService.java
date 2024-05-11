package com.pitd.pitd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pitd.pitd.entity.Turma;
import com.pitd.pitd.repository.TurmaRepository;

@Service
public class TurmaService {
    @Autowired
    TurmaRepository turmaRepository;

    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }

    public Turma getById(Integer id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public Turma saveTurma(Turma turma) {
        return turmaRepository.save(turma);
    }
}
