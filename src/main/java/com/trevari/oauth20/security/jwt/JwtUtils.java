package com.trevari.oauth20.security.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject((authentication.getName()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(jwtSecret).build().parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            // 로그를 추가하거나 예외를 처리할 수 있습니다.
        } catch (MalformedJwtException e) {
            // 로그를 추가하거나 예외를 처리할 수 있습니다.
        } catch (ExpiredJwtException e) {
            // 로그를 추가하거나 예외를 처리할 수 있습니다.
        } catch (UnsupportedJwtException e) {
            // 로그를 추가하거나 예외를 처리할 수 있습니다.
        } catch (IllegalArgumentException e) {
            // 로그를 추가하거나 예외를 처리할 수 있습니다.
        }
        return false;
    }
}
