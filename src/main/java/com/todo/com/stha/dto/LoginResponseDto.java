package com.todo.com.stha.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pritam shrestha
 * @version v1.0
 * @date 2024-10-22
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String token;
    private String refreshToken;
}
