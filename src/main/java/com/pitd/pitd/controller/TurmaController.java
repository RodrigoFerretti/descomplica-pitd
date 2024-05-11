package com.pitd.pitd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitd.pitd.entity.Turma;
import com.pitd.pitd.service.TurmaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Turma")
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    TurmaService turmaService;

    @GetMapping
    @Operation(operationId = "getTurmas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<List<Turma>> getAll() {
        List<Turma> turmas = turmaService.getAll();
        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(operationId = "getTurmaById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Turma> getById(@PathVariable Integer id) {
        Turma turma = turmaService.getById(id);
        return new ResponseEntity<>(turma, HttpStatus.OK);
    }

    @PostMapping
    @Operation(operationId = "saveTurma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<Turma> saveInstrutor(@RequestBody Turma turma) {
        Turma saved = turmaService.saveTurma(turma);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
