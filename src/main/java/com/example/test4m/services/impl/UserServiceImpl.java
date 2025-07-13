package com.example.test4m.services.impl;

import com.example.test4m.entity.User;
import com.example.test4m.repositories.impl.InMemoryUserRepository;
import com.example.test4m.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final InMemoryUserRepository inMemoryUserRepository;
    @Override
    public List<User> getAllUsers() {
        return inMemoryUserRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return inMemoryUserRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return inMemoryUserRepository.findByUsername(name);
    }

    @Override
    public User createUser(User user) {
        user.setId(null);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> userOptional = inMemoryUserRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found."+id);
        }
        user.setId(id);
        return inMemoryUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        inMemoryUserRepository.deleteById(id);
    }

    @Override
    public List<User> getUsersAboveAge(int age) {
        return inMemoryUserRepository.findUsersAboveAge(age);
    }
}
