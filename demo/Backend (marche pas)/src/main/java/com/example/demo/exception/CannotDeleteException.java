package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CannotDeleteException extends RuntimeException {
  public CannotDeleteException(String message) {
    super(message);
  }
}