package com.todo.com.stha.service.impl;

import com.todo.com.stha.dto.LoginRequestDto;
import com.todo.com.stha.dto.LoginResponseDto;
import com.todo.com.stha.entity.Users;
import com.todo.com.stha.repository.UserRepository;
import com.todo.com.stha.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-10-22
 **/

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public void signUpUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public LoginResponseDto signInUser(LoginRequestDto loginRequestDto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword())
        );
        var user = userRepository.findByUsername(loginRequestDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        var jwt = jwtService.generateToken(loginRequestDto.getUsername());
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(jwt);
        loginResponseDto.setRefreshToken((String) refreshToken);
        return loginResponseDto;
    }

}
