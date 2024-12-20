package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UsersRepository;
import java.util.ArrayList;
import java.util.List;
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

  @Override
  @Transactional
  public List<UserEntity> findByIdMultipleTimes(Long userId, int times) {
    List<UserEntity> userEntities = new ArrayList<>();
    for (int i = 0; i < times; i++) {
      Optional<UserEntity> userEntity = userRepository.findDetailedById(userId);
      userEntity.ifPresent(userEntities::add);
    }
    return userEntities;
  }
}
