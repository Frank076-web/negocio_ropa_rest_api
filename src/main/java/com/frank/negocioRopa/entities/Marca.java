package com.frank.negocioRopa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marcas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Marca extends BaseEntity implements Serializable {

    @Column(name = "nombre", nullable = false, length = 45, unique = true)
    private String nombre;

    @ManyToMany(mappedBy = "marcas",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Categoria> categorias = new ArrayList<>();
}
