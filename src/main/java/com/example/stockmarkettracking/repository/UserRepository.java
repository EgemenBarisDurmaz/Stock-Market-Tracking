package com.example.stockmarkettracking.repository;


import com.example.stockmarkettracking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String userName);
}
