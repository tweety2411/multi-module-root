package com.heypli.service;

import com.heypli.repo.domain.User;
import com.heypli.repo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    public User setUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
