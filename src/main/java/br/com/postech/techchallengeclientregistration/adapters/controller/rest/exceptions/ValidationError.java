package br.com.postech.techchallengeclientregistration.adapters.controller.rest.exceptions;

import lombok.Data;

@Data
public class ValidationError {
  private String message;
  private String field;
  private String rejectedValue;



}
