package com.frank.negocioRopa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marca extends BaseEntity{

    @Column(name = "nombre", nullable = false, length = 45, unique = true)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "marca_categoria",
            joinColumns = @JoinColumn(name = "idmarcas"),
            inverseJoinColumns = @JoinColumn(name = "idcategorias")
    )
    private List<Categoria> categorias;

}
