package com.frank.negocioRopa.services.marca;

import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.services.BaseService;

import java.util.List;

public interface MarcaService extends BaseService<Marca, Long> {

    Marca findByName(String name) throws Exception;

    List<Categoria> findMarcaAssosiatedWithCategoria(Long id) throws Exception;

}
