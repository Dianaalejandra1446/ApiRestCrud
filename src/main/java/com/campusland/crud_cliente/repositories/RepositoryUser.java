package com.campusland.crud_cliente.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.campusland.crud_cliente.repositories.entities.UserEntity;

public interface RepositoryUser extends CrudRepository<UserEntity,BigInteger>{
    
    Optional<UserEntity> findByEmail(String email);
}
