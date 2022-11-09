package com.frank.negocioRopa.controllers;

import com.frank.negocioRopa.entities.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<E extends BaseEntity, ID extends Serializable> {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getOneById(@PathVariable ID id);

    ResponseEntity<?> save(@RequestBody E entity);

    ResponseEntity<?> update(@RequestBody E entity);

    ResponseEntity<?> remove(@PathVariable ID id);

}
