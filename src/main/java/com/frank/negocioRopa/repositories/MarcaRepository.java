package com.frank.negocioRopa.repositories;

import com.frank.negocioRopa.entities.Marca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcaRepository extends BaseRepository<Marca, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM marcas WHERE marcas.nombre = ?1"
    )
    Optional<Marca> findByName(String nombre);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM marcas m WHERE m.nombre LIKE %?1%"
    )
    List<Marca> findCoincidentByName(String name);

}
