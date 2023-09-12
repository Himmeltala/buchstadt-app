package com.buchstadt.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @description: jwt token 解析和封装
 * @package: com.buchstadt.utils
 * @author: zheng
 * @date: 2023/9/3
 */
public class JwtUtil {

    private static final long EXPIRE_SECONDS = 86400000 * 7;
    private static final String KEY = "cereshuzhitingnizhenbangcereshuzhitingnizhenbang";

    public static Long getExpire() {
        return new Date(System.currentTimeMillis() + EXPIRE_SECONDS).getTime();
    }

    private static SecretKey generateKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(KEY));
    }

    public static String createJwt(String username, String type, String jwtUuid, Long expire) {
        JwtBuilder builder = Jwts.builder();
        return builder
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .claim("username", username)
                .claim("type", type)
                .setExpiration(new Date(expire))
                .setIssuedAt(new Date())
                .setId(jwtUuid)
                .signWith(generateKey())
                .compact();
    }

    public static Claims parseJwt(String header) {
        if (header == null || header.isBlank() || !header.startsWith("Bearer ")) return null;

        String token = header.substring(7);

        try {
            JwtParser parser = Jwts
                    .parserBuilder()
                    .setSigningKey(generateKey())
                    .build();
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);

            return claimsJws.getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
