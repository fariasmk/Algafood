package com.maikon.algafood.infrastructure.repository;

import com.maikon.algafood.domain.model.Cozinha;
import com.maikon.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext //Injeta um Entity Manager
    private EntityManager manager; //Gerencia o contexto de persistência

    @Override
    public List<Cozinha> listar() {
        return manager.createQuery("from Cozinha", Cozinha.class)
                .getResultList();
    }
    @Override
    public Cozinha buscar(Long id) {

        return manager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha salvar(Cozinha cozinha) {

        return manager.merge(cozinha);
    }

    @Transactional
    @Override
    public void  remover (Long id) {
        Cozinha cozinha = buscar(id);

        if (cozinha ==null) {
            throw new EmptyResultDataAccessException(1);
        }

        manager.remove(cozinha);
    }
}























