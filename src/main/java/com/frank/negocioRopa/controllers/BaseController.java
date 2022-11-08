package com.frank.negocioRopa.controllers;

import com.frank.negocioRopa.entities.BaseEntity;
import com.frank.negocioRopa.services.BaseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.net.http.HttpResponse;

public interface BaseController<E extends BaseEntity, ID extends Serializable, S extends BaseService<E, ID>> {

    HttpResponse<?> getAll() throws Exception;

    HttpResponse<?> getOneById(@PathVariable ID id) throws Exception;

    HttpResponse<?> save(@RequestBody E entity) throws Exception;

    HttpResponse<?> update(@RequestBody E entity) throws Exception;

    HttpResponse<?> remove(@PathVariable ID id) throws Exception;

}
