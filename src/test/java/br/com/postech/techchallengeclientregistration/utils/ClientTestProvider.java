package br.com.postech.techchallengeclientregistration.utils;

import br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity.ClientEntity;
import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import java.time.LocalDate;

public abstract class ClientTestProvider {

  public Client getFakeClient(){
    Client client = new Client();
    client.setCpf("36227297836");
    client.setName("Alex Ferreira");
    client.setDateOfBirth(LocalDate.of(1994, 04, 05));
    client.setEmail("alex@teste.com");
    return client;
  }

  public ClientEntity getFakeEntityClient(){
    ClientEntity client = new ClientEntity();
    client.setCpf("36227297836");
    client.setName("Alex Ferreira");
    client.setDateOfBirth(LocalDate.of(1994, 04, 05));
    client.setEmail("alex@teste.com");
    return client;
  }
}
