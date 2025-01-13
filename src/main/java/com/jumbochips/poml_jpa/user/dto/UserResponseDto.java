package com.jumbochips.poml_jpa.user.dto;


import com.jumbochips.poml_jpa.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {
    private String username;
    private String password;
    private String phone;
    private String github;
    private String introduction;
    private String profileImage;
}
