package com.frank.negocioRopa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria extends BaseEntity{

    @Column(name = "nombre", nullable = false, length = 45, unique = true)
    private String nombre;

    @ManyToMany
    private List<Marca> marcas;

}
