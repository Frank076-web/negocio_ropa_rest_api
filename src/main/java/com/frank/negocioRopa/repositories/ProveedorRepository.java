package com.frank.negocioRopa.repositories;

import com.frank.negocioRopa.entities.Proveedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends BaseRepository<Proveedor, Long>{

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM proveedores p WHERE p.nombre = ?1"
    )
    Optional<Proveedor> findByName(String nombre);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM proveedores p WHERE p.nombre LIKE %?1%"
    )
    List<Proveedor> findCoincidentByName(String name);

}
