package com.frank.negocioRopa.controllers.proveedor;

import com.frank.negocioRopa.controllers.BaseController;
import com.frank.negocioRopa.entities.Proveedor;
import org.springframework.http.ResponseEntity;

public interface ProveedorController extends BaseController<Proveedor, Long> {

    ResponseEntity<?> getProveedoresCoincidentByName(String name);

}
