package com.frank.negocioRopa.controllers;

import com.frank.negocioRopa.entities.BaseEntity;
import com.frank.negocioRopa.response.ResponseEntityHanlder;
import com.frank.negocioRopa.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

abstract public class BaseControllerImpl<E extends BaseEntity, S extends BaseService<E, Long>> implements BaseController<E, Long> {

    @Autowired
    S service;

    protected ResponseEntityHanlder response;

    @Override
    public ResponseEntity<?> getAll() throws Exception {
        try {
            return response.buildResponse(HttpStatus.OK, service.findAll(), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    public ResponseEntity<?> getOneById(Long id) throws Exception {
        try {
            return response.buildResponse(HttpStatus.OK, service.findOneById(id), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, no se encontró el registro solicitado");
        }
    }

    @Override
    public ResponseEntity<?> save(E entity) throws Exception {
        try {
            return response.buildResponse(HttpStatus.CREATED, service.create(entity), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.BAD_REQUEST, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    public ResponseEntity<?> update(E entity) throws Exception {
        try {
            return response.buildResponse(HttpStatus.OK, service.update(entity), "OK");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.BAD_REQUEST, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }

    @Override
    public ResponseEntity<?> remove(Long id) throws Exception {
        try {
            service.delete(id);
            return response.buildResponse(HttpStatus.OK, "Eliminado Correctamente");
        } catch (Exception e){
            return response.buildResponse(HttpStatus.NOT_FOUND, "Hubo un error, por favor intente de nuevo más tarde");
        }
    }
}
