package com.campusland.crud_cliente.repositories.entities;

import java.time.LocalDate;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero_factura;
    private LocalDate fecha;
    private String descripcion;

    @ManyToOne()
    private Cliente cliente;

    @ManyToOne()
    @JoinColumn(name = "itemFactura_id")
    private ItemFactura itemFactura;
}
