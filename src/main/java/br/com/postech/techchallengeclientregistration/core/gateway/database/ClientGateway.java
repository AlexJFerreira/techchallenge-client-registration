package br.com.postech.techchallengeclientregistration.core.gateway.database;

import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import java.util.Optional;

public interface ClientGateway {
  void registerClient(Client client);

  Optional<Client> searchClientByCpf(String cpf);

  Boolean checkClientRegistrationByCpf(String cpf);

}
