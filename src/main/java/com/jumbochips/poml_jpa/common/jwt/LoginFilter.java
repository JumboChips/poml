package com.jumbochips.poml_jpa.common.jwt;

import com.jumbochips.poml_jpa.common.auth.dto.CustomUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {

        //username, password 추출
        String username = obtainUsername(req);
        String password = obtainPassword(req);

        System.out.println(username);

        //Spring Security에서 username, password를 검증하기 위해 토큰에 담는다.
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password, null);

        //token에 담은 검증을 위한 AuthenticationManager로 전달
        return authenticationManager.authenticate(authRequest);
    }

    // 로그인 성공시 실행하는 메서드 (여기서 JWT를 발급받는다.)
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        CustomUserDetails customUserDetails = (CustomUserDetails) authResult.getPrincipal();

        String username = customUserDetails.getUsername();

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        Iterator<? extends GrantedAuthority> authoritiesIterator = authorities.iterator();
        GrantedAuthority authority = authoritiesIterator.next();

        String role = authority.getAuthority();

        String token = jwtUtil.createJwtToken(username, role, 60*60*100000000L);

        response.addHeader("Authorization", "Bearer " + token);
    }

    // 로그인 실패시 실행하는 메서드
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }


}
