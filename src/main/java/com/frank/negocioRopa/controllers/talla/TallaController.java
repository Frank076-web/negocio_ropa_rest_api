package com.frank.negocioRopa.controllers.talla;

import com.frank.negocioRopa.controllers.BaseController;
import com.frank.negocioRopa.entities.Talla;
import org.springframework.http.ResponseEntity;

public interface TallaController extends BaseController<Talla, Long> {

    ResponseEntity<?> getTallesCoincidentByName(String name);

}
