package com.example.Caching_Hazlecast.repository;

import com.example.Caching_Hazlecast.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
