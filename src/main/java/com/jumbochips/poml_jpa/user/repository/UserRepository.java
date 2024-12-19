package com.jumbochips.poml_jpa.user.repository;

import com.jumbochips.poml_jpa.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);

    User findByUsername(String username);

}
