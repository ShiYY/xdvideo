package net.xdclass.xdvideo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import net.xdclass.xdvideo.domain.User;

/**
 * Jwt工具类
 */
public class JwtUtils {
    
    public static final String SUBJECT = "xdclass";
    
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7; // 一周 单位:毫秒
    
    public static final String APPSECRET = "xd666"; // 秘钥
    
    /**
     * 生成Jwt
     */
    public static String geneJsonWebToken(User user) {
        if (null == user || null == user.getId() || null == user.getName() || null == user
            .getHeadImg()) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
            .claim("id", user.getId())
            .claim("name", user.getName())
            .claim("img", user.getHeadImg())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, APPSECRET)
            .compact();
        
        return token;
    }
    
    /**
     * 校验token
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET)
                .parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
