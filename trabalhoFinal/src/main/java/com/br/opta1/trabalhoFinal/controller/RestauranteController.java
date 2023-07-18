package com.br.opta1.trabalhoFinal.controller;

import com.br.opta1.trabalhoFinal.domain.Cardapio;
import com.br.opta1.trabalhoFinal.domain.Pratos;
import com.br.opta1.trabalhoFinal.domain.Restaurante;
import com.br.opta1.trabalhoFinal.enums.TipoRestauranteEnum;
import com.br.opta1.trabalhoFinal.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cardapio")
public class RestauranteController {
    @Autowired
    private RestauranteService service;

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Restaurante>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/buscarPorId")
    public ResponseEntity<Restaurante> buscarPorId(@RequestParam String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<Restaurante> salvar(@RequestBody Restaurante restaurante) {
        return ResponseEntity.ok(service.salvar(restaurante));
    }

    @DeleteMapping(value = "/deletar", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletarPorCpfCnpj(@RequestParam String cpfCnpj) {
        return ResponseEntity.ok(service.deletarPorCpfCpnj(cpfCnpj));
    }

    @GetMapping("/desativar")
    public ResponseEntity<String> desativarPorCpjCpnj(@RequestParam String cpfCnpj) {
        return ResponseEntity.ok(service.desativarPorCpfCpnj(cpfCnpj));
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Restaurante>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarPorNome(nome));
    }

    @GetMapping("/buscarPorTipo")
    public ResponseEntity<List<Restaurante>> buscarPorTipo(@RequestParam TipoRestauranteEnum Tipo) {
        return ResponseEntity.ok(service.buscarPorTipo(Tipo));
    }

    @GetMapping("/login")
    public ResponseEntity<Restaurante> login(@RequestParam String cpfCnpj, @RequestParam String senha) {
        return ResponseEntity.ok(service.login(cpfCnpj, senha));
    }

    @GetMapping("/recuperar")
    public ResponseEntity<String> recuperarAcesso(@RequestParam String cpfCnpj, @RequestParam String senha) {
        return ResponseEntity.ok(service.recuperarAcesso(cpfCnpj, senha));
    }

    @GetMapping("/buscarCardapio")
    public ResponseEntity<Cardapio> buscarPorCardapio(@RequestParam String cpfCnpj) {
        return ResponseEntity.ok(service.buscarPorCardapio(cpfCnpj));
    }

    @PostMapping("/cadastrarPrato")
    public ResponseEntity<String> cadastrarPrato(@RequestParam String idRestaurante, @RequestBody Pratos prato) {
        return ResponseEntity.ok(service.cadastrarPrato(idRestaurante, prato));
    }
}
