package com.campusland.crud_cliente.repositories.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "factura_items")
@Data
public class ItemFactura implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;
    private Integer cantidad;
    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
