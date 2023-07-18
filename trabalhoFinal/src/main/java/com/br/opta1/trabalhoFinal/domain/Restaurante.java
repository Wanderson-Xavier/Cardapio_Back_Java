package com.br.opta1.trabalhoFinal.domain;

import com.br.opta1.trabalhoFinal.enums.TipoRestauranteEnum;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document("Restaurante")
@EqualsAndHashCode(of = {"cpfCnpj", "id"})
public class Restaurante {
    private String id;
    private String nome;
    private String senha;
    private String cpfCnpj;
    private Cardapio cardapio;
    private List<Endereco> enderecos;
    private LocalDateTime dtCriacao;
    private TipoRestauranteEnum tipoRestauranteEnum;
    private Boolean isAtivo;
}
