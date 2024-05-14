package br.com.postech.techchallengeclientregistration.core.domain.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Client {
  private String cpf;
  private String name;
  private String email;
  private LocalDate dateOfBirth;
}
