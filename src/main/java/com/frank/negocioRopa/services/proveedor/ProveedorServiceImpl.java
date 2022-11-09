package com.frank.negocioRopa.services.proveedor;

import com.frank.negocioRopa.entities.Proveedor;
import com.frank.negocioRopa.repositories.ProveedorRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl<Proveedor, Long> implements ProveedorService {

    @Autowired
    private ProveedorRepository repository;

    @Override
    public Proveedor findByName(String name) throws Exception {
        try {
            return repository.findByName(name).orElse(null);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Proveedor> findCoincidentByName(String name) throws Exception {
        try {
            List<Proveedor> proveedores = repository.findCoincidentByName(name);
            return proveedores != null ? proveedores : new ArrayList<>();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
