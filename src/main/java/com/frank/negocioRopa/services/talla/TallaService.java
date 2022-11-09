package com.frank.negocioRopa.services.talla;

import com.frank.negocioRopa.entities.Talla;
import com.frank.negocioRopa.services.BaseService;

import java.util.List;

public interface TallaService extends BaseService<Talla, Long> {

    Talla findByName(String name) throws Exception;

    List<Talla> findCoincidentByName(String name) throws Exception;

}
