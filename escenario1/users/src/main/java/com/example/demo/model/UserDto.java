package com.example.demo.model;

import java.util.List;

public class UserDto {
  private Long id;
  private String username;
  private String randomNumber;
  private List<OrderDto> orders;

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getRandomNumber() {
    return randomNumber;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setRandomNumber(String randomNumber) {
    this.randomNumber = randomNumber;
  }

  public List<OrderDto> getOrders() {
    return orders;
  }

  public void setOrders(List<OrderDto> orders) {
    this.orders = orders;
  }
}
