package com.jumbochips.poml_jpa.user.service;

import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.dto.UserResponseDto;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class DefaultUserService implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponseDto getUser(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updateIntroduction(Long userId, String newIntroduction) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateIntroduction(newIntroduction);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updateUsername(Long userId, String newUsername) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateUsername(newUsername);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updateEmail(Long userId, String newEmail) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateEmail(newEmail);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updatePhone(Long userId, String newPhone) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updatePhone(newPhone);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updateGithub(Long userId, String newGithub) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateGithub(newGithub);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updatePassword(Long userId, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updatePassword(newPassword);
        userRepository.save(user);
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public UserResponseDto updateProfileImage(Long userId, MultipartFile newProfileImage) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        // 이미지 저장 및 파일 변환 로직 필요.
        return UserResponseDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .github(user.getGithub())
                .introduction(user.getIntroduction())
                .profileImage(user.getProfileImage())
                .build();
    }

    @Override
    public void deleteProfileImage(Long userId) {
        userRepository.deleteById(userId);
    }
}
