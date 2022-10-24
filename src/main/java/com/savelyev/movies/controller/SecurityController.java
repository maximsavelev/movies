package com.savelyev.movies.controller;

import com.savelyev.movies.JWT.JWTUtils;
import com.savelyev.movies.exception.NoSuchTokenException;
import com.savelyev.movies.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class SecurityController {

    private final UserService  userService;

    @PostMapping("/token/refresh")
    public ResponseEntity<Map<String,String>> refreshToken(@RequestHeader(AUTHORIZATION) String authorization)   {
        String authorizationHeader = authorization;
        if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refreshToken =  authorizationHeader.substring("Bearer ".length());
                String username = JWTUtils.decodeUsernameFromToken(refreshToken);
                User user = (User) userService.loadUserByUsername(username);
                String access_token = JWTUtils.createAccessToken(user);
                refreshToken = JWTUtils.createRefreshToken(user);
                Map<String,String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refreshToken);
                return ResponseEntity.ok(tokens);
            } catch (Exception e) {
                throw  new NoSuchTokenException(e.getMessage());
            }
        }
        else{
            throw  new NoSuchTokenException("Token not found");
        }
    }

}
