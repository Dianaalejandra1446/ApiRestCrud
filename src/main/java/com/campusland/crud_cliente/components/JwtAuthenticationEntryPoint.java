package com.campusland.crud_cliente.components;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    // manejar las excepciones relacionadas con la autenticación cuando un usuario no está autorizado para acceder a un recurso protegido

    /*`request`: La solicitud HTTP que desencadenó la excepción de autenticación.
    `response`: La respuesta HTTP que será enviada al cliente.
    `authException`: La excepción de autenticación que ocurrió. */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
                // error HTTP 401 (Unauthorized)
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
    }
    
}
