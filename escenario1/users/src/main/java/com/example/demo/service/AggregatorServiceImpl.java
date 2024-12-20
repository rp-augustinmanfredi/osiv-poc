package com.example.demo.service;

import com.example.demo.model.OrderDto;
import com.example.demo.model.UserDto;
import com.example.demo.model.UserEntity;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AggregatorServiceImpl implements AggregatorService {

  private final UsersService usersService;
  private final WebClient webClient;

  public AggregatorServiceImpl(UsersService usersService, WebClient webClient) {
    this.usersService = usersService;
    this.webClient = webClient;
  }

  @Override
  public Optional<UserDto> getUserDetailed(Long userId) {
    return usersService
        .findById(userId)
        .map(
            userEntity -> {
              String response = webClient.get().retrieve().bodyToMono(String.class).block();
              return mapToUserDto(userEntity, response);
            });
  }

  private UserDto mapToUserDto(UserEntity userEntity, String response) {

    UserDto userDto = new UserDto();
    userDto.setId(userEntity.getId());
    userDto.setUsername(userEntity.getUsername());
    userDto.setRandomNumber(response);
    userDto.setOrders(
        userEntity.getOrders().stream()
            .map(o -> new OrderDto(o.getId(), o.getDescription()))
            .toList());
    return userDto;
  }
}
