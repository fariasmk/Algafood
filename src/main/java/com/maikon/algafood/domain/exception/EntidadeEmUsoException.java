package com.maikon.algafood.domain.exception;

import java.io.Serial;

public class EntidadeEmUsoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }

}
