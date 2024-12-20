package com.example.demo.service;

import com.example.demo.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface AggregatorService {

    Optional<UserDto> getUserDetailed(Long userId);

    List<UserDto> getUserDetailedMultipleTimes(Long userId);

}
