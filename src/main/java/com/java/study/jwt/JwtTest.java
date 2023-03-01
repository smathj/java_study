package com.java.study.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class JwtTest {


    private static final String secretKey = "publicstaticvoidmainstringargspublicstaticvoidmainstringargspublicstaticvoidmainstringargs";

    public static long tokenValidMillisecond = 1000 * 60 * 60; // 1분 * 60 = 60분 = 1시간
    public static long ADD_SECOND = 1000 * 5; // 5초

        private static final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
//    private static final Key key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), SignatureAlgorithm.HS512.getJcaName());

    public static void main(String[] args) throws InterruptedException {

        String userId = "natae";
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_READ");
        roles.add("ROLE_WRITE");



        try {

            String nataeToken = createToken(userId, roles);

            // 토큰이 만료되도록 기다린다
//            Thread.sleep(ADD_SECOND);

            String username = getUsername(nataeToken);

        } catch(ExpiredJwtException e) {
            e.printStackTrace();
            System.out.println("[System] 토큰이 만료되었습니다");

        } catch (Exception ec) {
            ec.printStackTrace();
        }




    }

    /**
     * 토큰 생성
     */
    public static String createToken(String userId, List<String> roles) {
        System.out.println("[System] 토큰을 생성합니다");

        Claims claims = Jwts.claims()   // 즉 Jwt 토큰에는 페이로드하며, 페이로드는 클레임이다
                .setSubject(userId);   // 토큰의 제목을 사용자 이름으로 하였다

        claims.put("roles", roles);

        Date now = new Date();

        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)   // 발급일
//                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .setExpiration(new Date(now.getTime() + ADD_SECOND))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();


        System.out.println(" =======================[ 토큰 생성 ]======================= ");
        System.out.println("token = " + token);
        System.out.println(" ========================================================== ");

        System.out.println();
        System.out.println();


        return token;

    }

    public static String getUsername(String token) throws InterruptedException {
        System.out.println("[System] 토큰을 파싱합니다");
        JwtParser jp = Jwts.parserBuilder().setSigningKey(key).build();


        Claims claims = jp.parseClaimsJws(token).getBody(); // 만료된 토큰을 넣으면 에러발생
//        System.out.println("claims = " + claims);

        String sub = (String) claims.get("sub");
        List<String> roles = (List<String>) claims.get("roles");
        Integer iat = (Integer) claims.get("iat");
        Integer exp = (Integer) claims.get("exp");
        String subject = claims.getSubject();


        System.out.println(" =====================[ 토큰 정보 분석 ]===================== ");
        System.out.println("subject = " + subject);
        System.out.println("sub = " + sub);
        System.out.println("roles = " + roles);
        System.out.println("iat = " + iat);
        System.out.println("exp = " + exp);
        System.out.println(" ========================================================== ");

        boolean tokenIsAlive = claims.getExpiration().after(new Date(iat));
        System.out.println("tokenIsAlive = " + tokenIsAlive);


        Calendar createCalendar = Calendar.getInstance();
        createCalendar.setTime(new Date(iat));

        Calendar expireCalendar = Calendar.getInstance();
        expireCalendar.setTime(new Date(exp));

        boolean isAfter = expireCalendar.after(createCalendar);
        System.out.println("isAfter = " + isAfter);

//        boolean isBefore = expireCalendar.before(createCalendar);
//        System.out.println("isBefore = " + isBefore);


        return subject;
    }

}
