package com.frank.negocioRopa.services.categoria;

import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.services.BaseService;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria, Long> {

    Categoria findByName(String name) throws Exception;

    List<Marca> findMarcasAssosiatedWithCategoria(Long id) throws Exception;

}
