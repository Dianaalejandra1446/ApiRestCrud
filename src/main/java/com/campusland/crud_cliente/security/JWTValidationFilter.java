package com.campusland.crud_cliente.security;

import java.io.IOException;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.campusland.crud_cliente.services.JWTService;
import com.campusland.crud_cliente.services.JWTUserDetailService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro para validar tokens JWT en las solicitudes entrantes.
 */
public class JWTValidationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final JWTUserDetailService jwtUserDetailService;

    private static final Logger log = LoggerFactory.getLogger(JWTValidationFilter.class);

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String AUTHORIZATION_HEADER_BEARER = "Bearer";

    /**
     * Constructor del filtro.
     */
    public JWTValidationFilter(JWTService jwtService, JWTUserDetailService jwtUserDetailService) {
        this.jwtService = jwtService;
        this.jwtUserDetailService = jwtUserDetailService;
    }

    /**
     * Método principal para la lógica de filtrado.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Obtener el encabezado de autorización de la solicitud
        final var requestTokenHeader = request.getHeader(AUTHORIZATION_HEADER);
        String username = null;
        String jwt = null;

        // Verificar si el encabezado de autorización comienza con "Bearer" y obtener el token JWT
        if (Objects.nonNull(requestTokenHeader) && requestTokenHeader.startsWith(AUTHORIZATION_HEADER_BEARER)) {
            jwt = requestTokenHeader.substring(7); // Extraer el token JWT
            try {
                // Obtener el nombre de usuario del token JWT
                username = jwtService.getUsernameFromToken(jwt);
            } catch (IllegalArgumentException e) {
                // Manejar errores al obtener el nombre de usuario del token JWT
                log.error("Error al obtener el nombre de usuario del token JWT: {}", e.getMessage());
            } catch (ExpiredJwtException e) {
                // Manejar advertencias de token JWT caducado
                log.warn("Token JWT expirado: {}", e.getMessage());
            }
        }

        // Continuar con el filtro llamando al siguiente filtro en la cadena
        filterChain.doFilter(request, response);
    }
}

