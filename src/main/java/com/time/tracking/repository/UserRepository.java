package com.time.tracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.time.tracking.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
