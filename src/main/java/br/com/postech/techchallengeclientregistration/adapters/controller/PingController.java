package br.com.postech.techchallengeclientregistration.adapters.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PingController {

  @GetMapping("/")
  @ResponseStatus(HttpStatus.OK)
  public void ping() {
  }

}
