package com.example.demo.controller;

import com.example.demo.model.UserDto;
import com.example.demo.service.AggregatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {

  private final AggregatorService aggregatorService;

  public Controller(AggregatorService aggregatorService) {
    this.aggregatorService = aggregatorService;
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserDto> findOne(@PathVariable Long userId) {
    return aggregatorService
        .getUserDetailed(userId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }
}
