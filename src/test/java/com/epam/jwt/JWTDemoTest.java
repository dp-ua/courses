package com.epam.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JWTDemoTest {

    public static final Logger LOG = LoggerFactory.getLogger(JWTDemo.class);


    /*
        Create a simple JWT, decode it, and assert the claims
     */
    @Test
    public void createAndDecodeJWT() {

        String jwtId = "SOMEID1234";
        String jwtIssuer = "JWT Demo";
        String jwtSubject = "Andrew";
        int jwtTimeToLive = 800000;

        String jwt = JWTDemo.createJWT(
                jwtId, // claim = jti
                jwtIssuer, // claim = iss
                jwtSubject, // claim = sub
                jwtTimeToLive // used to calculate expiration (claim = exp)
        );

        LOG.info("jwt = \"" + jwt.toString() + "\"");

        Claims claims = JWTDemo.decodeJWT(jwt);

        LOG.info("claims = " + claims.toString());

        assertEquals(jwtId, claims.getId());
        assertEquals(jwtIssuer, claims.getIssuer());
        assertEquals(jwtSubject, claims.getSubject());

    }

    /*
        Attempt to decode a bogus JWT and expect an exception
     */
    @Test(expected = MalformedJwtException.class)
    public void decodeShouldFail() {

        String notAJwt = "This is not a JWT";

        // This will fail with expected exception listed above
        Claims claims = JWTDemo.decodeJWT(notAJwt);

    }

    /*
    Create a simple JWT, modify it, and try to decode it
 */
    @Test(expected = SignatureException.class)
    public void createAndDecodeTamperedJWT() {

        String jwtId = "SOMEID1234";
        String jwtIssuer = "JWT Demo";
        String jwtSubject = "Andrew";
        int jwtTimeToLive = 800000;

        String jwt = JWTDemo.createJWT(
                jwtId, // claim = jti
                jwtIssuer, // claim = iss
                jwtSubject, // claim = sub
                jwtTimeToLive // used to calculate expiration (claim = exp)
        );

        LOG.info("jwt = \"" + jwt.toString() + "\"");

        // tamper with the JWT

        StringBuilder tamperedJwt = new StringBuilder(jwt);
        tamperedJwt.setCharAt(22, 'I');

        LOG.info("tamperedJwt = \"" + tamperedJwt.toString() + "\"");

        assertNotEquals(jwt, tamperedJwt);

        // this will fail with a SignatureException

        JWTDemo.decodeJWT(tamperedJwt.toString());

    }

}