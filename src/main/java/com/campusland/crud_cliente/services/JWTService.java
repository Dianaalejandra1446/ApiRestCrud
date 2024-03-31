package com.campusland.crud_cliente.services;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
    // Duracion del Token 5 horas(seg-horas)
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    // Clave secreta para firmar y verificar tokens
    public static final String JWT_SECRET="jxgEQe.XHuPq8VdbyYFNk.AN.dudQ0903YUn4";

    // Utiliza la clave secreta para verificar la firma del token y luego extrae las reclamaciones del cuerpo del token.
    private Claims getAllClaimsFromToken(String token){
        final var key = Keys.hmacShaKeyFor(JWT_SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaimsFromToken(String token, Function<Claims,T> claimsResolver){
        final var claims = this.getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    //  Obtiene la fecha de expiración del token JWT.
    private Date getExpirationDateFromToken(String token){
        return this.getClaimsFromToken(token, Claims::getExpiration);
    }
// Este método verifica si un token JWT ha expirado. 
    private Boolean isTokenExpired(String token){
        final var expirationDate = this.getExpirationDateFromToken(token);
        return expirationDate.before(new Date());
    }
    
}
