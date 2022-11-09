package com.frank.negocioRopa.repositories;

import com.frank.negocioRopa.entities.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends BaseRepository<Categoria, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM categorias c WHERE c.nombre = ?1"
    )
    Optional<Categoria> findByName(String nombre);

}
