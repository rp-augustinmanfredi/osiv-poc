package com.example.demo.service;

import com.example.demo.model.OrderDto;
import com.example.demo.model.UserDto;
import com.example.demo.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AggregatorServiceImpl implements AggregatorService {

    private final UsersService usersService;

    public AggregatorServiceImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public Optional<UserDto> getUserDetailed(Long userId) {
        return usersService.findById(userId).map(this::mapToUserDto);
    }

    private UserDto mapToUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setUsername(userEntity.getUsername());
        userDto.setRandomNumber("1");
        userDto.setOrders(userEntity.getOrders().stream().map(o -> new OrderDto(o.getId(), o.getDescription())).toList());
        return userDto;
    }
}
