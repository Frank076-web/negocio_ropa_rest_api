package com.frank.negocioRopa.controllers.marca;

import com.frank.negocioRopa.controllers.BaseController;
import com.frank.negocioRopa.entities.Marca;
import org.springframework.http.ResponseEntity;

public interface MarcaController extends BaseController<Marca, Long> {

    ResponseEntity<?> getMarcasCoincidentByName(String name);

}
