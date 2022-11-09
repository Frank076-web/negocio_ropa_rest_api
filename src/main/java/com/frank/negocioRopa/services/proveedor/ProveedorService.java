package com.frank.negocioRopa.services.proveedor;

import com.frank.negocioRopa.entities.Proveedor;
import com.frank.negocioRopa.services.BaseService;

import java.util.List;

public interface ProveedorService extends BaseService<Proveedor, Long> {

    Proveedor findByName(String name) throws Exception;

    List<Proveedor> findCoincidentByName(String name) throws Exception;

}
