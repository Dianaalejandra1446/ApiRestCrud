package com.campusland.crud_cliente.security;

import java.io.IOException;
import java.util.Objects;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CsrfCookieFilter extends OncePerRequestFilter{
    /* Esta clase CsrfCookieFilter se utiliza para agregar el token CSRF como una cookie en la respuesta HTTP. Esto es importante para proteger contra ataques de falsificación de solicitudes entre sitios (CSRF) al asociar un token único con cada sesión del usuario y verificarlo en cada solicitud.  */
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        var csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        
        if (Objects.nonNull(csrfToken.getHeaderName())) {
            response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        }
        filterChain.doFilter(request, response);
    }
    
}
