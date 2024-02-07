package com.app.premom.repository;

import com.app.premom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.day = u.day + 1")
    void incrementDayForAllUsers();
}

