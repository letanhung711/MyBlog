package com.example.BlogPersonal.repository;

import com.example.BlogPersonal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByFullName(String fullName);
    User findByUsername(String username);
}
