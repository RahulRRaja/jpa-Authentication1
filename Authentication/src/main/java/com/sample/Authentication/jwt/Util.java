package com.sample.Authentication.jwt;

import com.sample.Authentication.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.ToString;

public class Util {
    private static  String secret = "This_place";
    public static String generateToken(User user)
    {
        Claims claims = Jwts.claims()
                .setIssuer(user.getId().toString());

        claims.put("name", user.getName());
        claims.put("emailId",user.getEmail());
        return Jwts.builder()
                .setClaims(claims)
                .compact();
    }
}
