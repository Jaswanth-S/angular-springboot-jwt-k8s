package com.stackroute.userservice.security;

import com.stackroute.userservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * This class is implementing the SecurityTokenGenerator interface. This class has to be annotated with
 * @Service annotation.
 * @Service - is an annotation that annotates classes at the service layer, thus
 * clarifying it's role.
 *
 * */
@Service
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator {

    /*
     * This method is responsible for generating a JWT token with issuedAt, subject and secret
     */
    @Override
    public Map<String, String> generateToken(User user) {

        String jwtToken = null;

        jwtToken = Jwts.builder().setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "SecretKey")
                .compact();

        Map<String, String> map = new HashMap<>();
        map.put("token", jwtToken);
        map.put("message", "User authentication successful");

        return map;
    }
}
