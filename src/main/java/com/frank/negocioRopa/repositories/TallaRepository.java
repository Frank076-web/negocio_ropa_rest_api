package com.frank.negocioRopa.repositories;

import com.frank.negocioRopa.entities.Talla;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TallaRepository extends BaseRepository<Talla, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM tallas t WHERE t.nombre = ?1"
    )
    Optional<Talla> findByName(String nombre);

}
