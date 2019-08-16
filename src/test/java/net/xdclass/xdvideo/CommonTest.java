package net.xdclass.xdvideo;

import io.jsonwebtoken.Claims;
import net.xdclass.xdvideo.domain.User;
import net.xdclass.xdvideo.utils.JwtUtils;
import org.junit.Test;

/**
 * @description:
 * @author: W
 * @create: 2019-07-17 20:38
 **/
public class CommonTest {
    
    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(999);
        user.setName("xd");
        user.setHeadImg("www.xdclass.net");
        String token = JwtUtils.geneJsonWebToken(user);
        System.out.println(token);
    }
    
    @Test
    public void testCheck() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZGNsYXNzIiwiaWQiOjk5OSwibmFtZSI6InhkIiwiaW1nIjoid3d3LnhkY2xhc3MubmV0IiwiaWF0IjoxNTYzMzY3MzQxLCJleHAiOjE1NjM5NzIxNDF9.zUebCPTMQPqvmzR9C65LxYoRCGjIXyjqIJzmMQAgEQE";
        Claims claims = JwtUtils.checkJWT(token);
        if (null != claims) {
            System.out.println(claims.get("id"));
            System.out.println(claims.get("name"));
            System.out.println(claims.get("img"));
        } else {
            System.out.println("非法token");
        }
    }
}
