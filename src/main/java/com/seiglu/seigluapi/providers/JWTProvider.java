package com.seiglu.seigluapi.providers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JWTProvider {
    @Value("${security.token.secret}")
    private String secretKey;
    public  String tokenValidation(String token) {
        token = token.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        try {
           var subject = JWT.require(algorithm).build().verify(token).getSubject();
           return subject;
        } catch (JWTVerificationException err) {
             err.printStackTrace();
             return "";
        }


    }

}
