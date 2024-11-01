package com.time.tracking.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class UtilController {

    public static boolean hasRoleUser(String auth) {
        if (auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            Claims claims = Jwts.parser()
                    .setSigningKey(Role.SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            String role = claims.get("role", String.class);
            return role.equals(Role.USER) || role.equals(Role.ADMIN);

        }
        return false;
    }

    public static boolean hasRoleAdmin(String auth) {
        if (auth != null && auth.startsWith("Bearer ")) {
            String token = auth.substring(7);
            Claims claims = Jwts.parser()
                    .setSigningKey(Role.SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            return claims.get("role", String.class).equals(Role.ADMIN);
        }
        return false;
    }
}
