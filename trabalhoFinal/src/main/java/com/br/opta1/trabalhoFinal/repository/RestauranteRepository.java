package com.br.opta1.trabalhoFinal.repository;

import com.br.opta1.trabalhoFinal.domain.Restaurante;
import com.br.opta1.trabalhoFinal.enums.TipoRestauranteEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, String> {
    Optional<Restaurante> findByCpfCnpj(String cpfCpnj);

    List<Restaurante> findByNome(String nome);

    List<Restaurante> findByTipoRestauranteEnum(TipoRestauranteEnum tipo);

    Optional<Restaurante> findByCpfCnpjAndSenha(String cpfCnpj, String senha);
}
