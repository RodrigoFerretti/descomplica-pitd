package com.pitd.pitd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pitd.pitd.entity.Instrutor;
import com.pitd.pitd.service.InstrutorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Tag(name = "Instrutor")
@RequestMapping("/instrutor")
public class InstrutorController {
    @Autowired
    InstrutorService instrutorService;

    @GetMapping
    @Operation(operationId = "getInstrutores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200")
    })
    public ResponseEntity<List<Instrutor>> getAll() {
        List<Instrutor> instrutores = instrutorService.getAll();
        return new ResponseEntity<>(instrutores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(operationId = "getInstrutorById")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404")
    })
    public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
        Instrutor instrutor = instrutorService.getById(id);
        return new ResponseEntity<>(instrutor, HttpStatus.OK);
    }

    @PostMapping
    @Operation(operationId = "saveInstrutor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201"),
            @ApiResponse(responseCode = "409")
    })
    public ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
        Instrutor saved = instrutorService.saveInstrutor(instrutor);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

}
