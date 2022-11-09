package com.frank.negocioRopa.services.categoria;

import com.frank.negocioRopa.entities.Categoria;
import com.frank.negocioRopa.entities.Marca;
import com.frank.negocioRopa.repositories.CategoriaRepository;
import com.frank.negocioRopa.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    @Autowired
    CategoriaRepository repository;

    @Override
    public Categoria findByName(String name) throws Exception {
        try {
            return repository.findByName(name).orElse(null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Marca> findMarcasAssosiatedWithCategoria(Long id) throws Exception {
        try {
            Categoria categoria = repository.findById((id)).orElse(null);
            return categoria.getMarcas();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
