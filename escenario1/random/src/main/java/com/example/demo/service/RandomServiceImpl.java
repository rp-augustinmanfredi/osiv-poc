package com.example.demo.service;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements RandomService {

  @Override
  public String getRandom() {

    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt(); // Restaura el estado de interrupción
    }
    return String.valueOf(
        ThreadLocalRandom.current().nextInt(0, 101)); // Límite superior es exclusivo
  }
}
