package com.maikon.algafood.core.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.maikon.algafood.api.model.mixin.CidadeMixin;
import com.maikon.algafood.api.model.mixin.CozinhaMixin;
import com.maikon.algafood.domain.model.Cidade;
import com.maikon.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import java.io.Serial;

@Component
public class JacksonMixinModule extends SimpleModule {

    @Serial
    private static final long serialVersionUID = 1L;

    public JacksonMixinModule() {
        setMixInAnnotation(Cidade.class, CidadeMixin.class);
        setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
    }

}
