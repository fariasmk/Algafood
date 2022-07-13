package com.maikon.algafood.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class RestauranteModel {

    private Long id;
    private String nome;
    private BigDecimal frete;
    private CozinhaModel cozinha;

    //    private String momeCozinha; não reconheceu
    private String cozinhaNome;
    private Long idCozinha;

}
