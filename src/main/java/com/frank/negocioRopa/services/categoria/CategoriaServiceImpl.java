package com.frank.negocioRopa.services.categoria;

import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.repositories.CategoriaRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    CategoriaRepository repository;

}
