package com.campusland.crud_cliente.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campusland.crud_cliente.Dto.FacturaDTO;
import com.campusland.crud_cliente.repositories.entities.Factura;

@Component
public class FacturaDTOConverte {
    @Autowired
    private ModelMapper dbm;
    
    public FacturaDTO conveFacturaDTO(Factura factura){
        FacturaDTO facturaDTO=dbm.map(factura, FacturaDTO.class);
        facturaDTO.setItems(factura.getItems());
        return facturaDTO;
    }
    public Factura convertFacturaDTO(FacturaDTO facturaDTO){
        return dbm.map(facturaDTO,Factura.class);
    }

}
