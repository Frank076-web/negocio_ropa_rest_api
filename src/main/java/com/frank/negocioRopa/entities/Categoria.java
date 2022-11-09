package com.frank.negocioRopa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends BaseEntity implements Serializable {

    @Column(name = "nombre", nullable = false, length = 45, unique = true)
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "marca_categoria",
            joinColumns = @JoinColumn(name = "idmarcas"),
            inverseJoinColumns = @JoinColumn(name = "idcategorias")
    )
    private List<Marca> marcas = new ArrayList<>();

}
