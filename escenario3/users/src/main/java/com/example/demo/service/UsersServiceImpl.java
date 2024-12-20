package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UsersRepository;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository userRepository;

    public UsersServiceImpl(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<UserEntity> findById(Long userId) {
        return userRepository.findDetailedById(userId);
    }
}
