package br.com.postech.techchallengeclientregistration.core.domain.entity;

import lombok.Data;

@Data
public class ClientInactivation {
  private String name;
  private String cep;
  private String addressNumber;
  private String telephoneNumber;
  private String cpf;
}
