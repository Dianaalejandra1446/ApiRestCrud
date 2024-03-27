package com.campusland.crud_cliente.Configuracion;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.campusland.crud_cliente.Dto.ItemFacturaDTO;
import com.campusland.crud_cliente.repositories.entities.ItemFactura;

@Component
public class ItemFacturaDTOConverte {
    private ModelMapper dbm; 
    
    @Autowired
    public ItemFacturaDTOConverte(ModelMapper modelMapper) {
        this.dbm = modelMapper;
    }
    
    public ItemFacturaDTO converItemFacturaDTO(ItemFactura itemFactura){
        ItemFacturaDTO itemFacturaDTO = dbm.map(itemFactura, ItemFacturaDTO.class);
        if (itemFactura.getProducto() != null) {
            itemFacturaDTO.setProducto_id(itemFactura.getProducto().getCodigo());
        }
        return itemFacturaDTO;
    }

    public ItemFactura coverItemFactura(ItemFacturaDTO itemFacturaDTO){
        return dbm.map(itemFacturaDTO, ItemFactura.class);
    }
}
