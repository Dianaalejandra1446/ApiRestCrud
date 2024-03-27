package com.campusland.crud_cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.Dto.ItemFacturaDTO;
import com.campusland.crud_cliente.services.ItemFacturaServices;

@RestController
@RequestMapping("/items")
public class ItemFacturaController {
   @Autowired
   private ItemFacturaServices itemFacturaServices;
   
   @GetMapping("/ver-items")
   public List<ItemFacturaDTO> findAll(){
        return itemFacturaServices.findAll();
   }
}
