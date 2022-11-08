package com.frank.negocioRopa.controllers.categoria;

import com.frank.negocioRopa.controllers.BaseControllerImpl;
import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.services.categoria.CategoriaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categorias")
public class CategoriaControllerImpl extends BaseControllerImpl<Categoria, CategoriaServiceImpl> implements CategoriaController {
}
