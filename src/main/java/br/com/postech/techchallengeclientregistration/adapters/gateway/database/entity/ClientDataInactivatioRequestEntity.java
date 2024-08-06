package br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "client_data_inactivation_request")
public class ClientDataInactivatioRequestEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "request_number")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "cep")
  private String cep;

  @Column(name = "address_number")
  private String addressNumber;

  @Column(name = "telephone_number")
  private String telephoneNumber;

  @Column(name = "cpf")
  private String cpf;
}
