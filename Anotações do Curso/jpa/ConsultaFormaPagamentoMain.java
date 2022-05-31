package com.maikon.algafood.jpa;

import com.maikon.algafood.AlgafoodApiApplication;
import com.maikon.algafood.domain.model.FormaPagamento;
import com.maikon.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaFormaPagamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FormaPagamentoRepository formaPagamentoRepository = applicationContext.getBean(FormaPagamentoRepository.class);

        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.listar();

        for (FormaPagamento formaPagamento : todasFormasPagamentos) {
            System.out.println(formaPagamento.getDescricao());
        }
    }

}
