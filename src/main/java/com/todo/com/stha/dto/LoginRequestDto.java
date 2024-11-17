package com.todo.com.stha.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-10-22
 **/

@Getter
@Setter
@AllArgsConstructor
public class LoginRequestDto {

    private String username;
    private String password;
}
