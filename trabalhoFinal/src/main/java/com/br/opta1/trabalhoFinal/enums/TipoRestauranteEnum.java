package com.br.opta1.trabalhoFinal.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoRestauranteEnum {
    LANCHONETE("Lanchonete"),
    RESTAURANTE("Restaurante"),
    PIZZARIA("Pizzaria"),
    OUTROS("Outros");

    private final String tipo;
}
