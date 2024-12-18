package com.todo.com.stha.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-11-17
 **/


public interface UserService {


    UserDetailsService userDetailsService();
}
