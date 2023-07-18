package com.br.opta1.trabalhoFinal.service;

import com.br.opta1.trabalhoFinal.domain.Pratos;
import com.br.opta1.trabalhoFinal.exceptions.TrabalhoFinalException;
import com.br.opta1.trabalhoFinal.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratosService {
    @Autowired
    private PratoRepository repository;

    public List<Pratos> buscarPorNome(String nome) {
        List<Pratos> restaurantes = repository.findPratosByNome(nome);
        if (restaurantes.isEmpty()) {
            throw new TrabalhoFinalException("Erro ao procurar os Pratos com nome " + nome, HttpStatus.NOT_FOUND.value());
        } else {
            return restaurantes;
        }
    }
}
