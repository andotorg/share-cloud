package org.andot.graphene.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class JWTTokenUtil {
    // 寻找证书文件
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks");
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;

    static { // 将证书文件里边的私钥公钥拿出来
        try {
            // java key store 固定常量
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(inputStream, "123456".toCharArray());
            // jwt 为 命令生成整数文件时的别名
            privateKey = (PrivateKey) keyStore.getKey("andot", "123456".toCharArray());
            publicKey = keyStore.getCertificate("andot").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 生成jwt token
     * @param subject 加密内容
     * @param expirationSeconds 保存時間
     * @param salt  加密盐值, 如果为空则使用私钥加密
     * @return
     */
    public static String generateToken(Object subject, int expirationSeconds, String salt) {
        String token = "";
        if(StringUtils.isEmpty(salt)){
            token = Jwts.builder()
                    .setClaims(null)
                    .setSubject(subject.toString())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                    .signWith(SignatureAlgorithm.RS256, privateKey)
                    .compact();
        } else {
            token = Jwts.builder()
                    .setClaims(null)
                    .setSubject(subject.toString())
                    .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                    // 不使用公钥私钥
                    .signWith(SignatureAlgorithm.HS512, salt)
                    .compact();
        }
        return token;
    }

    /***
     * 解密jwt token
     * @param token
     * @param salt
     * @return
     */
    public static String parseToken(String token, String salt) throws TimeoutException {
        String subject = null;
        try {
            if(StringUtils.isEmpty(salt)){
                Claims claims = Jwts.parser()
                        .setSigningKey(publicKey)
                        .parseClaimsJws(token).getBody();
                subject = claims.getSubject();
            } else {
                Claims claims = Jwts.parser()
                        // 不使用公钥私钥
                        .setSigningKey(salt.getBytes(StandardCharsets.UTF_8))
                        .parseClaimsJws(token).getBody();
                subject = claims.getSubject();
            }
        } catch (Exception e) {
            throw new TimeoutException("登录过期");
        }
        return subject;
    }
}
