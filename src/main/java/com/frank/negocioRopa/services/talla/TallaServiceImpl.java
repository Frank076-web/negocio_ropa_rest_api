package com.frank.negocioRopa.services.talla;

import com.frank.negocioRopa.entities.Talla;
import com.frank.negocioRopa.repositories.TallaRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Talla> findCoincidentByName(String name) throws Exception {
        try {
            List<Talla> tallas = repository.findCoincidentByName(name);
            return tallas != null ? tallas : new ArrayList<>();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
