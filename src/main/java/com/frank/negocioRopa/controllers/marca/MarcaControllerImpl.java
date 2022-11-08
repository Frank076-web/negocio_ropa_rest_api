package com.frank.negocioRopa.controllers.marca;

import com.frank.negocioRopa.controllers.BaseControllerImpl;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.services.marca.MarcaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/marcas")
public class MarcaControllerImpl extends BaseControllerImpl<Marca, MarcaServiceImpl> implements MarcaController {
}
