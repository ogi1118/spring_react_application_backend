package net.javaguides.spring_react_application_backend.repository;

import net.javaguides.spring_react_application_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ユーザー認証、管理のための追加メソッド
//    Optional<User> findByUsername(String email);
    Optional<User> existsByEmail(String email);
    Optional<User> findByEmail(String email);
}
