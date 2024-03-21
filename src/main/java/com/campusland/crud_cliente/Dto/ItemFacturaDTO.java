package com.campusland.crud_cliente.Dto;

import lombok.Data;

@Data
public class ItemFacturaDTO {
    private Long id;
    private Integer cantidad;
    private Long producto_id;    
}
