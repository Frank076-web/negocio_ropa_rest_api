package com.frank.negocioRopa.repositories;

import com.frank.negocioRopa.entities.Talla;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TallaRepository extends BaseRepository<Talla, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM tallas t WHERE t.nombre = ?1"
    )
    Optional<Talla> findByName(String nombre);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM tallas t WHERE t.nombre LIKE %?1%"
    )
    List<Talla> findCoincidentByName(String name);

}
