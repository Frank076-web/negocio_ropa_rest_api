package com.frank.negocioRopa.services.talla;

import com.frank.negocioRopa.entities.Talla;
import com.frank.negocioRopa.repositories.TallaRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TallaServiceImpl extends BaseServiceImpl<Talla, Long> implements TallaService{

    @Autowired
    TallaRepository repository;

    @Override
    public Talla findByName(String name) throws Exception {
        try {
            return repository.findByName(name).orElse(null);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
