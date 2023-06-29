package com.example.togglzdemo.common;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class TimeKeeper {

  public LocalTime getUtcTime() {
    return LocalTime.now();
  }
}
