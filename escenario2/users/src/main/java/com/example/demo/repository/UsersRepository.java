package com.example.demo.repository;

import com.example.demo.model.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

  @EntityGraph(attributePaths = "orders")
  Optional<UserEntity> findDetailedById(Long userId);

  Optional<UserEntity> findSummaryById(Long userId);
}
