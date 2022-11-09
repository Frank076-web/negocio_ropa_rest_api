package com.frank.negocioRopa.services.marca;

import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.services.BaseService;

public interface MarcaService extends BaseService<Marca, Long> {

    Marca findByName(String name) throws Exception;

}
