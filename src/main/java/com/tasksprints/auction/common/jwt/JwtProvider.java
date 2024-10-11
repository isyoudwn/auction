package com.tasksprints.auction.common.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtProperties jwtProperties;

    /**
     * TODO: createToken 으로 변경 -> refreshToken 확장성 고려
     * accessToken 을 생성합니다.
     * */
    public String createAccessToken(Long userId) {


        Date now = new Date(System.currentTimeMillis());

        return Jwts.builder()
            .setIssuer(jwtProperties.getIssuer())
            .claim("userId", userId)
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime() + jwtProperties.getExpireMs()))
            .signWith(SignatureAlgorithm.HS256, JwtUtil.encodeSecretKey((jwtProperties.getSecretKey())))
            .compact();
    }

    /**
     * TODO:
     *  1. Claims 리팩토링
     *  2. 토큰 종류에 따른 expire 시간 다른 반환
     *      - claim 길이 유무로 판단
     * */
}
