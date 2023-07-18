package com.br.opta1.trabalhoFinal.service;

import com.br.opta1.trabalhoFinal.domain.Cardapio;
import com.br.opta1.trabalhoFinal.domain.Pratos;
import com.br.opta1.trabalhoFinal.domain.Restaurante;
import com.br.opta1.trabalhoFinal.enums.TipoRestauranteEnum;
import com.br.opta1.trabalhoFinal.exceptions.TrabalhoFinalException;
import com.br.opta1.trabalhoFinal.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository repository;

    public List<Restaurante> buscarTodos() {
        List<Restaurante> restaurantes = repository.findAll();
        if (restaurantes.isEmpty()) {
            throw new TrabalhoFinalException("Erro ao procurar restaurantes", HttpStatus.NOT_FOUND.value());
        } else {
            return restaurantes;
        }
    }

    public Restaurante buscarPorId(String id) {
        Optional<Restaurante> restaurante = repository.findById(id);
        if (restaurante.isPresent()) {
            return restaurante.get();
        }
        throw new TrabalhoFinalException("Erro ao procurar restaurante, tente novamente", HttpStatus.NOT_FOUND.value());
    }

    public Restaurante salvar(Restaurante restaurante) {
        Optional<Restaurante> restauranteOptional = repository.findByCpfCnpj(restaurante.getCpfCnpj());
        try {
            if (restauranteOptional.isEmpty()) {
                restaurante.setDtCriacao(LocalDateTime.now());
                restaurante.setIsAtivo(true);
                return repository.save(restaurante);
            } else {
                throw new TrabalhoFinalException("Cpf ou Cnpj já cadastrado!\n Por favor, utilize outro ou recupere o antigo!", HttpStatus.NO_CONTENT.value());
            }
        } catch (Exception e) {
            throw new TrabalhoFinalException("Erro ao salvar restaurante, tente novamente", HttpStatus.NO_CONTENT.value());
        }
    }

    public String desativarPorCpfCpnj(String cpfCpnj) {
        Optional<Restaurante> restauranteOptional = repository.findByCpfCnpj(cpfCpnj);
        if (restauranteOptional.isPresent()) {
            Restaurante restaurante = restauranteOptional.get();
            restaurante.setIsAtivo(false);
            return "Desativado com sucesso!";
        }
        throw new TrabalhoFinalException("Erro ao desativar o restaurante", HttpStatus.NOT_FOUND.value());
    }

    public String deletarPorCpfCpnj(String cpfCpnj) {
        Optional<Restaurante> restauranteOptional = repository.findByCpfCnpj(cpfCpnj);
        if (restauranteOptional.isPresent()) {
            Restaurante restaurante = restauranteOptional.get();
            repository.delete(restaurante);
            return "Deletado com sucesso!";
        }
        throw new TrabalhoFinalException("Erro ao deletar restaurante", HttpStatus.NOT_FOUND.value());
    }

    public List<Restaurante> buscarPorNome(String nome) {
        List<Restaurante> restaurantes = repository.findByNome(nome);
        if (restaurantes.isEmpty()) {
            throw new TrabalhoFinalException("Erro ao procurar restaurantes", HttpStatus.NOT_FOUND.value());
        } else {
            return restaurantes;
        }
    }

    public List<Restaurante> buscarPorTipo(TipoRestauranteEnum tipo) {
        List<Restaurante> restaurantes = repository.findByTipoRestauranteEnum(tipo);
        if (restaurantes.isEmpty()) {
            throw new TrabalhoFinalException("Erro ao procurar restaurantes", HttpStatus.NOT_FOUND.value());
        } else {
            return restaurantes;
        }
    }

    public Restaurante login(String cpfCpnj, String senha) {
        Optional<Restaurante> restaurante = repository.findByCpfCnpjAndSenha(cpfCpnj, senha);
        return restaurante.orElse(null);
    }

    public String recuperarAcesso(String cpfCnpj, String senha) {
        Optional<Restaurante> restaurante = repository.findByCpfCnpjAndSenha(cpfCnpj, senha);
        if (restaurante.isPresent()) {
            Restaurante restauranteRecuperado = restaurante.get();
            restauranteRecuperado.setIsAtivo(true);
            return "Acesso recuperado com sucesso!";
        }
        throw new TrabalhoFinalException("Restaurante não encontrado!", HttpStatus.NOT_FOUND.value());
    }

    public Cardapio buscarPorCardapio(String cpfCnpj) {
        Optional<Restaurante> restaurante = repository.findByCpfCnpj(cpfCnpj);
        if (restaurante.isPresent()) {
            return restaurante.get().getCardapio();
        }
        throw new TrabalhoFinalException("Erro ao procurar o cardapio, tente novamente", HttpStatus.NOT_FOUND.value());
    }

    public String cadastrarPrato(String idRestaurante, Pratos prato) {
        Optional<Restaurante> restaurante = repository.findById(idRestaurante);
        if (restaurante.isPresent()) {
            Restaurante restaurante1 = restaurante.get();
            if(restaurante1.getCardapio() != null) {
                Cardapio cardapio = restaurante1.getCardapio();
                List<Pratos> pratosList = cardapio.getPratos();
                pratosList.add(prato);
                cardapio.setPratos(pratosList);
                restaurante1.setCardapio(cardapio);
                repository.save(restaurante1);
            }else {
                List<Pratos> pratosList = List.of(prato);
                Cardapio cardapio = new Cardapio();
                cardapio.setPratos(pratosList);
                restaurante1.setCardapio(cardapio);
                repository.save(restaurante1);
            }
            return "Prato cadastrado com sucesso!";
        }
        throw new TrabalhoFinalException("Erro ao procurar o restaurante, tente novamente", HttpStatus.NOT_FOUND.value());
    }
}
