package com.jumbochips.poml_jpa.common.auth.service;

import com.jumbochips.poml_jpa.common.auth.dto.JoinDto;
import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {

        String username = joinDto.getUsername();
        String password = joinDto.getPassword();

        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Boolean isExist = userRepository.existsByUsername(username);

        if (isExist) {
            return;
        }

        User newUser = User.builder()
                .username(username)
                .password(encodedPassword)
                .role("ROLE_ADMIN")
                .build();

        userRepository.save(newUser);
    }
}
