package com.frank.negocioRopa.controllers.proveedor;

import com.frank.negocioRopa.controllers.BaseControllerImpl;
import com.frank.negocioRopa.entities.Proveedor;
import com.frank.negocioRopa.services.proveedor.ProveedorService;
import com.frank.negocioRopa.services.proveedor.ProveedorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/proveedores")
public class ProveedorControllerImpl extends BaseControllerImpl<Proveedor, ProveedorServiceImpl> implements ProveedorController {

    @Autowired
    private ProveedorService service;

    @Override
    @GetMapping("/nombre")
    public ResponseEntity<?> getProveedoresCoincidentByName(String name) {
        try {
            return response.buildResponse(HttpStatus.OK, service.findCoincidentByName(name), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Proveedor entity) {
        try {
            Proveedor entityExists = service.findByName(entity.getNombre());
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
