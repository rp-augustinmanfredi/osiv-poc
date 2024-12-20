package com.example.demo.service;

import com.example.demo.model.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UsersService {
  Optional<UserEntity> findById(Long userId);
  List<UserEntity> findByIdMultipleTimes(Long userId, int times);
  
}
