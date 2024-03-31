package com.campusland.crud_cliente.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campusland.crud_cliente.repositories.RepositoryUser;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JWTUserDetailService {
    private final RepositoryUser repositoryUser;
    // Carga los detalles del usuario a partir del correo para la autenticacion
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Si encuentra el usuario, mapea sus roles a SimpleGrantedAuthority, crea un objeto User (de Spring Security) con los detalles del usuario y devuelve este objeto */
        return repositoryUser.findByEmail(username)
                .map(usuario -> {
                    List<SimpleGrantedAuthority> authorities = usuario.getRoles()
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList());
                    return new User(usuario.getEmail(), usuario.getPassword(), authorities);
                })
                /*Si no encuentra el usuario, lanza una excepción */
                .orElseThrow(() -> new UsernameNotFoundException("User not exist"));
    }
}
