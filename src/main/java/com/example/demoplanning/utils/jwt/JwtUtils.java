package com.example.demoplanning.utils.jwt;

import com.example.demoplanning.utils.auth.ApplicationUser;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;

@Component
public class JwtUtils {

    @Autowired
    private SecretKey jwtSecret;
    @Autowired
    private JwtConfig jwtConfig;

   // @Value("${application.jwt.tokenExpirationAfterDays}")
    //private int jwtExpiration;

    public String generateJwtToken(Authentication authResult) {

        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(jwtSecret)
                .compact();

       return jwtConfig.getTokenPrefix() + token;
    }

    public String getUsernameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtSecret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtSecret)
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        }catch (SignatureException e) {
            System.out.println("Invalid JWT Signature : {} " + e.getMessage());
        }catch (MalformedJwtException e) {
            System.out.println("Invalid JWT Signature : {} " + e.getMessage());
        }catch (ExpiredJwtException e) {
            System.out.println("Invalid JWT Signature : {} " + e.getMessage());
        }catch (UnsupportedJwtException e) {
            System.out.println("Invalid JWT Signature : {} " + e.getMessage());
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid JWT Signature : {} " + e.getMessage());
        }

        return false;
    }



}
