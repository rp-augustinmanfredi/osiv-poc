package com.example.demo.service;

import com.example.demo.model.UserEntity;
import com.example.demo.repository.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

  private final UsersRepository userRepository;
  @PersistenceContext private EntityManager entityManager;

  public UsersServiceImpl(UsersRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public Optional<UserEntity> findById(Long userId) {
    Optional<UserEntity> userEntityOpt = userRepository.findDetailedById(userId);
    Session session = entityManager.unwrap(Session.class);
    session.getIdentifier(userEntityOpt.get());
    return userEntityOpt;
  }
}
