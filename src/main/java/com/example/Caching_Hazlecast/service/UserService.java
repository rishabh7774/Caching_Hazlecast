package com.example.Caching_Hazlecast.service;

import com.example.Caching_Hazlecast.entity.User;
import com.example.Caching_Hazlecast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Cacheable(cacheNames = {"userCache"})
    public List<User> getUsers() {
        System.out.println("Getting Users List From DB For First Time");
        return userRepository.findAll();
    }

    @Cacheable(value = "userCache", key = "#id", unless = "#result==null")
    public User getUser(Integer id) {
        System.out.println("Getting User From DB For First Time");
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "userCache")
    public String delete(Integer id) {
        userRepository.deleteById(id);
        return "User Deleted With Id : " + id;
    }
}
