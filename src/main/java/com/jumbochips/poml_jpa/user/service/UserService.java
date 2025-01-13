package com.jumbochips.poml_jpa.user.service;

import com.jumbochips.poml_jpa.user.dto.UserResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    UserResponseDto getUser(Long userId);
    UserResponseDto updateIntroduction(Long userId, String introduction);
    UserResponseDto updateUsername(Long userId, String newUsername);
    UserResponseDto updatePassword(Long userId, String newPassword);
    UserResponseDto updatePhone(Long userId, String newPhone);
    UserResponseDto updateGithub(Long userId, String newGithub);
    UserResponseDto updateProfileImage(Long userId, MultipartFile newProfileImage);
    void deleteProfileImage(Long userId);
}
