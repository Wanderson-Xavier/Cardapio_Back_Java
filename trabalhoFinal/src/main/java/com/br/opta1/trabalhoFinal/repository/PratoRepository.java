package com.br.opta1.trabalhoFinal.repository;

import com.br.opta1.trabalhoFinal.domain.Pratos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends MongoRepository<Pratos, String> {
    List<Pratos> findPratosByNome(String nome);
}
