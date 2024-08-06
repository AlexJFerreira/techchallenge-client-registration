package br.com.postech.techchallengeclientregistration.adapters.controller.rest.request;

import lombok.Data;

@Data
public class ClientInactivationRequest {
  private String name;
  private String cep;
  private String addressNumber;
  private String telephoneNumber;
  private String cpf;
}

