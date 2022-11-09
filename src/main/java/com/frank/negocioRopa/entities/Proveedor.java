package com.frank.negocioRopa.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor extends BaseEntity{

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 16)
    private Integer telefono;

    @Column(name = "email", length = 100)
    private String email;

}
