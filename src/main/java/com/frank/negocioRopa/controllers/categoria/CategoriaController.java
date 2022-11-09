package com.frank.negocioRopa.controllers.categoria;

import com.frank.negocioRopa.controllers.BaseController;
import com.frank.negocioRopa.entities.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CategoriaController extends BaseController<Categoria, Long> {

    ResponseEntity<?> getMarcasAssociatedWithCategoria(Long id);

}
