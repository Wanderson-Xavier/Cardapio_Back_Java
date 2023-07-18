package com.br.opta1.trabalhoFinal.controller;

import com.br.opta1.trabalhoFinal.domain.Pratos;
import com.br.opta1.trabalhoFinal.service.PratosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
public class PratosController {
    @Autowired
    private PratosService service;

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Pratos>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }
}
