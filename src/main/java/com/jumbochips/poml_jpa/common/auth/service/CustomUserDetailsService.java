package com.jumbochips.poml_jpa.common.auth.service;

import com.jumbochips.poml_jpa.common.auth.dto.CustomUserDetails;
import com.jumbochips.poml_jpa.user.domain.User;
import com.jumbochips.poml_jpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User userData = userRepository.findByUsername(username);

        if (userData != null) {
            return new CustomUserDetails(userData);
        }

        return null;
    }
}
