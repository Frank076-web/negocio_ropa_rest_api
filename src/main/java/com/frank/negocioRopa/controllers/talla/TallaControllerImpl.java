package com.frank.negocioRopa.controllers.talla;

import com.frank.negocioRopa.controllers.BaseControllerImpl;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.entities.Talla;
import com.frank.negocioRopa.services.talla.TallaService;
import com.frank.negocioRopa.services.talla.TallaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/tallas")
public class TallaControllerImpl extends BaseControllerImpl<Talla, TallaServiceImpl> implements TallaController {

    @Autowired
    TallaService service;

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Talla entity) {
        try {
            Talla entityExists = service.findByName(entity.getNombre());
            return entityExists != null && entity.getNombre()
                                                 .equalsIgnoreCase(entityExists.getNombre())
                    ? response.buildResponse(HttpStatus.BAD_REQUEST, "Error: el nombre del registro ya existe")
                    : response.buildResponse(HttpStatus.CREATED, service.create(entity), "OK");

        } catch (
                Exception e) {
            return response.buildResponse(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
