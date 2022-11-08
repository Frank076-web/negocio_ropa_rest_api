package com.frank.negocioRopa.services;

import com.frank.negocioRopa.entities.BaseEntity;
import com.frank.negocioRopa.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

abstract public class BaseServiceImpl<E extends BaseEntity, ID extends Serializable> implements BaseService<E, ID>  {

    @Autowired
    BaseRepository<E, ID> repository;

    @Override
    public List<E> findAll() throws Exception {
        try {
            return repository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E findOneById(ID id) throws Exception {
        try {
            return repository.findById(id).get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E create(E entity) throws Exception {
        try {
            entity.setFechaCreacion(new Date());
            return repository.save(entity);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public E update(E entity) throws Exception {
        try {
            if (repository.findById((ID) entity.getId()).isPresent()) {
                return repository.save(entity);
            } else {
                throw new Exception("Error: la entidad solicitada para actualizar no existe");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(ID id) throws Exception {
        try {
            if (repository.findById(id).isPresent()) {
                repository.deleteById(id);
            } else {
                throw new Exception("Error: la entidad que quieres eliminar no existe");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
