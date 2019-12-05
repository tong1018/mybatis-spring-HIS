package com.ct.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ct.entity.HisUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class TokenUtil {
    /**
     * 签名秘钥
     */

    public static final String SECRET = "admin";

    /**
     * 生成token
     * @param username
     * @return
     */
    public static String createJwtToken(String username){
        String issuer="tdoor";
        String subject="liao";
        long ttlMillis=36000000;//10个小时后过期
        return createJwtToken(username,issuer,subject,ttlMillis);
    }

    public static String createJwtToken(String username,long ttlMillis){
        String issuer="tdoor";
        String subject="liao";

        return createJwtToken(username,issuer,subject,ttlMillis);
    }

    public static String createJwtToken(HisUser hisUser){
        long ttlMillis = 36000000;
        //签名算法，将token进行签名
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        //生成签发时间
        long nowMills=System.currentTimeMillis();
        Date now=new Date(nowMills);
        //通过秘钥签名JWT
        byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary(hisUser.getPassword());
        Key signingKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        //创建token

        JwtBuilder builder= Jwts.builder().setId(hisUser.getUsername())
                .setIssuedAt(now)
                .signWith(signatureAlgorithm,signingKey);

        //添加过期时间
        if(ttlMillis>=0){
            long expMillis=nowMills+ttlMillis;
            Date exp=new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 生成token
     * @param username 用户名
     * @param issuer 改JWT的签发者，是否使用可以选
     * @param subject 改JWT所面向的用户，是否使用可选
     * @param ttlMillis 签发时间（有效时间，过期会报错）
     * @return token string
     */
    public static String createJwtToken(String username,String issuer,String subject,long ttlMillis){
        //签名算法，将token进行签名
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        //生成签发时间
        long nowMills=System.currentTimeMillis();
        Date now=new Date(nowMills);
        //通过秘钥签名JWT
        byte[] apiKeySecretBytes= DatatypeConverter.parseBase64Binary(SECRET);
        Key signingKey=new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());
        //创建token

        JwtBuilder builder= Jwts.builder().setId(username)

                .setIssuedAt(now)
                .signWith(signatureAlgorithm,signingKey);
        //添加过期时间
        if(ttlMillis>=0){
            long expMillis=nowMills+ttlMillis;
            Date exp=new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    //验证和读取JWT的示例方法
    public static Claims parseJWT(String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static Claims parseJWT(String jwt,String password){
        Claims claims=Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(password))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
    public static void main(String[] args){
        HisUser hisUser = new HisUser();
        hisUser.setPassword("fakjfklaj");
        hisUser.setUsername("user1");
        String token = "";

        Claims claims=parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJiaWFucXVlIiwiaWF0IjoxNTY3MTU3NjU1LCJleHAiOjE1NjcxOTM2NTV9.YHyc9yhfyk3B3KRdGojnt06GPsGzBkuB4nYoSuAR7X8");

        System.out.println(claims.getId());

        //System.out.println(TokenUtil.createJwtToken("liao180@vip.qq.com"));

        DecodedJWT decodedJWT = JWT.decode("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJ1c2VyMSIsImlhdCI6MTU2NzEzMjg4MSwiZXhwIjoxNTY3MTY4ODgxfQ.M2tDx74Dm3LT4krsfrYfuk8Z1EZiWsGmfkUFckOmXbk");
        //System.out.println(decodedJWT.getToken());

    }
}
