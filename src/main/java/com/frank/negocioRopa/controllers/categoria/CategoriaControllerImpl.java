package com.frank.negocioRopa.controllers.categoria;

import com.frank.negocioRopa.controllers.BaseControllerImpl;
import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.services.categoria.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/categorias")
public class CategoriaControllerImpl extends BaseControllerImpl<Categoria, CategoriaServiceImpl> implements CategoriaController {

    @Autowired
    CategoriaServiceImpl service;

    @Override
    @GetMapping("/{id}/marcas")
    public ResponseEntity<?> getMarcasAssociatedWithCategoria(@PathVariable Long id) {
        try {
            return response.buildResponse(HttpStatus.OK, service.findMarcasAssosiatedWithCategoria(id), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Categoria entity) {
        try {
            Categoria entityExists = service.findByName(entity.getNombre());
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
