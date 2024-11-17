package com.todo.com.stha.controller;

import com.todo.com.stha.dto.LoginRequestDto;
import com.todo.com.stha.dto.LoginResponseDto;
import com.todo.com.stha.entity.Users;
import com.todo.com.stha.service.UserService;
import com.todo.com.stha.service.impl.AuthenticationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-11-17
 **/

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final AuthenticationServiceImpl authenticationService;

    @PostMapping("/signUp")
    private ResponseEntity<?> signUpUser(@RequestBody Users user) {
        authenticationService.signUpUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/signIn")
    private ResponseEntity<LoginResponseDto> signInUser(@RequestBody LoginRequestDto loginRequestDto) {
        return new ResponseEntity<>(authenticationService.signInUser(loginRequestDto), HttpStatus.OK);
    }

}
