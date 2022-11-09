package com.frank.negocioRopa.services.marca;

import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.repositories.MarcaRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MarcaServiceImpl extends BaseServiceImpl<Marca, Long> implements MarcaService {

    @Autowired
    private MarcaRepository repository;

    @Override
    @Transactional
    public Marca findByName(String name) throws Exception {
        try {
            return repository.findByName(name).orElse(null);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<Marca> findCoincidentByName(String name) throws Exception {
        try {
            List<Marca> marcas = repository.findCoincidentByName(name);
            return marcas != null ? marcas : new ArrayList<>();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
