package com.frank.negocioRopa.services.talla;

import com.frank.negocioRopa.entities.Talla;
import com.frank.negocioRopa.services.BaseService;

public interface TallaService extends BaseService<Talla, Long> {

    Talla findByName(String name) throws Exception;

}
