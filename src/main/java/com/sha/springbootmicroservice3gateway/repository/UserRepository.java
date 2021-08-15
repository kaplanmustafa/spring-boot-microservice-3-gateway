package com.sha.springbootmicroservice3gateway.repository;

import com.sha.springbootmicroservice3gateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
