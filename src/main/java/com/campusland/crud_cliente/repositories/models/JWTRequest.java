package com.campusland.crud_cliente.repositories.models;

import lombok.Data;

@Data
public class JWTRequest {
    private String username;
    private String password;
}
