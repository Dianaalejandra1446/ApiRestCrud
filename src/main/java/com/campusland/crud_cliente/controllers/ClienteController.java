package com.campusland.crud_cliente.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campusland.crud_cliente.repositories.entities.Cliente;
import com.campusland.crud_cliente.services.ClienteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> findAll() {
        return clienteService.finaAll();
    }

    @GetMapping("/{id}")
    public Cliente findAllById(@PathVariable Long id) {
        return clienteService.finById(id);
    }
    @GetMapping("/byEmail/{email}")
    public ResponseEntity<Map<String,Object>> findAllById(@PathVariable String email) {

         Map<String,Object> response=new HashMap<>();

         Cliente cliente=clienteService.findByEmail(email);

         if(cliente!=null){
            response.put("cliente",cliente);
            return new ResponseEntity<>(response,HttpStatus.OK);
         }else{
            response.put("mensaje",new String("No existe ningún cliente con ese id:"));
            return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
         }



    }
    @PostMapping("/")
    public ResponseEntity<?> saveCliente(@Valid @RequestBody Cliente cliente, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                                        .stream()
                                        .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                                        .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
        Cliente clienteNew;
        try {
            clienteNew = clienteService.save(cliente);
        } catch (DataAccessException e) {
            response.put("Mensaje", "Error al realizar el insert en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        response.put("Mensaje", "El cliente ha sido creado con éxito");
        response.put("Cliente", clienteNew);
    
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
     
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody Cliente cliente, BindingResult result,
            @PathVariable Long id) {

        Cliente clienteUpdate = null;

        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo " + err.getField() + " " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {

            clienteUpdate = clienteService.update(id, cliente);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar el upate en la base de datos");
            response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }

        response.put("mensaje", "El cliente ha sido actualizado con éxito");
        response.put("cliente", clienteUpdate);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
 }

