package com.campusland.crud_cliente.Dto;

import java.util.Date;
import java.util.List;

import com.campusland.crud_cliente.repositories.entities.ItemFactura;

import lombok.Data;

@Data
public class FacturaDTO {
    private Long id;
    private String descripcion;
    private String observacion;
    private Date createAt;
    List<ItemFactura> items;
    private Long cliente_id;
}
