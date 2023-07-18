package com.br.opta1.trabalhoFinal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Endereco {
    private String descricao;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private Integer codigoTipoEndereco;
    private String descricaoTipoEndereco;
    private Integer idTipoLogradouro;
    private Integer idLocalidade;
}
