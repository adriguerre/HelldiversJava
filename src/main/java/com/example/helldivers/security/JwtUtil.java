package com.example.helldivers.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${JWT_KEY}")
   private String KEY;

   private Key getSigningKey(){
       byte[] keyBytes = KEY.getBytes(StandardCharsets.UTF_8);
       return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email, String role, Integer accountId) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .claim("accountId", accountId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(getSigningKey())
                .compact();
    }

    public String extractEmail(String token){
       return Jwts.parserBuilder()
               .setSigningKey(getSigningKey())
               .build().parseClaimsJws(token)
               .getBody().getSubject();
    }

    public boolean isTokenValid(String token){
       try{
           Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);
            return true;
       }catch(Exception e){
           return false;
       }
    }

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }

    public Integer extractAccountId(String token){
       return Jwts.parserBuilder()
               .setSigningKey(getSigningKey())
               .build()
               .parseClaimsJws(token)
               .getBody()
               .get("accountId", Integer.class);
    }
}
