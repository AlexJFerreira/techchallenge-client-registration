package br.com.postech.techchallengeclientregistration.adapters.controller.rest.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ClientResponse {
  private String cpf;
  private String name;
  private String email;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateOfBirth;
}
