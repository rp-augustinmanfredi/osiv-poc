package com.example.demo.service;

import com.example.demo.model.OrderDto;
import com.example.demo.model.UserDto;
import com.example.demo.model.UserEntity;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AggregatorServiceImpl implements AggregatorService {

    private final UsersService usersService;
    private final EntityManager entityManager;
    private static final int DB_ACCESS_TIMES = 10;

    public AggregatorServiceImpl(UsersService usersService, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.usersService = usersService;
    }
    @Override
    public Optional<UserDto> getUserDetailed(Long userId) {
        return usersService.findById(userId).map(this::mapToUserDto);
    }

    @Override
    public List<UserDto> getUserDetailedMultipleTimes(Long userId) {
        return usersService.findByIdMultipleTimes(userId, DB_ACCESS_TIMES).stream().map(this::mapToUserDto).toList();
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
