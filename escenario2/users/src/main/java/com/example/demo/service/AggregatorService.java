package com.example.demo.service;

import com.example.demo.model.UserDto;
import java.util.Optional;

public interface AggregatorService {

  Optional<UserDto> getUserDetailed(Long userId);
}
