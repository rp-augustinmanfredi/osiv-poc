package com.example.demo.controller;

import com.example.demo.service.RandomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/random")
public class RandomController {

  private final RandomService randomService;

  public RandomController(RandomService randomService) {
    this.randomService = randomService;
  }

  @GetMapping
  public String getRandom() {
    return randomService.getRandom();
  }
}
