package com.maikon.algafood.domain.repository;



import com.maikon.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    Restaurante salvar(Restaurante cozinha);
    void remover(Restaurante cozinha);

}
