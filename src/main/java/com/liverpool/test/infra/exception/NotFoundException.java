package com.liverpool.test.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

  private String message;

  public NotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
