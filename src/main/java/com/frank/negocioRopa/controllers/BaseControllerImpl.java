package com.frank.negocioRopa.controllers;

import com.frank.negocioRopa.entities.BaseEntity;
import com.frank.negocioRopa.response.ResponseEntityHanlder;
import com.frank.negocioRopa.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


abstract public class BaseControllerImpl<E extends BaseEntity, S extends BaseService<E, Long>> implements BaseController<E, Long> {

    @Autowired
    S service;

    protected ResponseEntityHanlder response;

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return response.buildResponse(HttpStatus.OK, service.findAll(), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id) {
        try {
            return response.buildResponse(HttpStatus.OK, service.findOneById(id), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, no se encontró el registro solicitado");
        }
    }

    @Override
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity) {
        try {
            return response.buildResponse(HttpStatus.CREATED, service.create(entity), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.BAD_REQUEST, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody E entity) {
        try {
            return response.buildResponse(HttpStatus.OK, service.update(entity), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.BAD_REQUEST, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        try {
            service.delete(id);
            return response.buildResponse(HttpStatus.OK, "Eliminado Correctamente");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }
}
