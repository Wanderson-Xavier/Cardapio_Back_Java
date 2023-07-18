package com.br.opta1.trabalhoFinal.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Pratos {
    private String nome;
    private String ingredientes;
    private Double valor;
}
