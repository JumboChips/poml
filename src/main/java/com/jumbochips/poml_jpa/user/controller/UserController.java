package com.jumbochips.poml_jpa.user.controller;

import com.jumbochips.poml_jpa.user.dto.UserResponseDto;
import com.jumbochips.poml_jpa.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponseDto> getUser(
            @RequestParam Long userId
    ) {
        try {
            UserResponseDto userResponseDto = userService.getUser(userId);
            return ResponseEntity.ok(userResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/introduction")
    public ResponseEntity<UserResponseDto> updateIntroduction(
            @RequestParam Long userId,
            @RequestParam String introduction
    ) {
        try {
            UserResponseDto userResponseDto = userService.updateIntroduction(userId, introduction);
            return ResponseEntity.ok(userResponseDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/name")
    public ResponseEntity<UserResponseDto> updateUsername(
            @RequestParam Long userId,
            @RequestParam String name
    ) {
        try {
        UserResponseDto updatedUser = userService.updateUsername(userId, name);
        return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/phone")
    public ResponseEntity<UserResponseDto> updatePhone(
            @RequestParam Long userId,
            @RequestParam String phone
    ) {
        try {
            UserResponseDto updatedUser = userService.updatePhone(userId, phone);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/github")
    public ResponseEntity<UserResponseDto> updateGithub(
            @RequestParam Long userId,
            @RequestParam String github
    ) {
        try {
            UserResponseDto updatedUser = userService.updateGithub(userId, github);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/password")
    public ResponseEntity<UserResponseDto> updatePassword(
            @RequestParam Long userId,
            @RequestParam String password
    ) {
        try {
            UserResponseDto updatedUser = userService.updatePassword(userId, password);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/profileImage")
    public ResponseEntity<UserResponseDto> updateProfileImage(
            @RequestParam Long userId,
            @RequestParam MultipartFile profileImage
    ) {
        try {
            UserResponseDto updatedUser = userService.updateProfileImage(userId, profileImage);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/profileImage")
    public ResponseEntity<?> deleteProfileImage(
            @RequestParam Long userId
    ) {
        try {
            userService.deleteProfileImage(userId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
