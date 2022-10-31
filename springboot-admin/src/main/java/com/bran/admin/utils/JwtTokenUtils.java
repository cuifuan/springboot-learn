package com.bran.admin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Slf4j
@Component
public class JwtTokenUtils {

    private static final String JWT_SECRET = "springboot-admin13921springboot-admin13921springboot-admin13921";
    // 过期时间-毫秒计时 默认 7 天
    private static final Long JWT_EXPIRATION = 7L * 24 * 60 * 1000;

    private static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;


    /**
     * 根据用户信息生成token
     */
    public String generateToken(String username) {

        Claims claims = Jwts.claims().setSubject(username);

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(getSignKey())
                .compact();
    }

    /**
     * 从token中获取用户名
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 判断token是否有效
     * 两方面：token是否过期
     * token用户名是否和userDetails中用户名一致
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.extractUsername(token);
        if (null == userDetails) {
            return false;
        }
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否失效
     */
    public boolean isTokenExpired(String token) {
        Date expiredDate = this.getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }

    /**
     * 从token中获取失效时间
     */
    public Date getExpiredDateFromToken(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }

    /**
     * 从token中获取负载
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 生成token失效时间
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + JWT_EXPIRATION);
    }

    private static Key getSignKey() {
        // 使用我们的 JWT_SECRET 密钥签署我们的 JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(JWT_SECRET);
        return new SecretKeySpec(apiKeySecretBytes, SIGNATURE_ALGORITHM.getJcaName());
    }
}