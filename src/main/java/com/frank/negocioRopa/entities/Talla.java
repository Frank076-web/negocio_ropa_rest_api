package com.frank.negocioRopa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tallas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Talla extends BaseEntity{

    @Column(name = "nombre", length = 45, nullable = false, unique = true)
    private String nombre;

}
