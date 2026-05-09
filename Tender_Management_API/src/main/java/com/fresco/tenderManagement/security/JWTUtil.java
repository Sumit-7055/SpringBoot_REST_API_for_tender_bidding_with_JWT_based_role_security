package com.fresco.tenderManagement.security;

import com.fresco.tenderManagement.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil implements Serializable {

    private static final long serialVersionUID = 654352132132L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // 5 hours

    private final String secretKey = "randomkey123";

    @Autowired
    private UserService userService;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    	return null;
    } 

    private Claims getAllClaimsFromToken(String token) {
        return null;
    }

    private Boolean isTokenExpired(String token) {
    	final Date date= getExpirationDateFromToken( token);
        return date.before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
    	
        return null;
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return null;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return null;
    }
}
