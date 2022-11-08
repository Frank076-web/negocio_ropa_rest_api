package com.frank.negocioRopa.services;

import com.frank.negocioRopa.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity, ID extends Serializable> {

    List<E> findAll() throws Exception;

    E findOneById(ID id) throws Exception;

    E create(E entity) throws Exception;

    E update(E entity) throws Exception;

    void delete(ID id) throws Exception;

}
