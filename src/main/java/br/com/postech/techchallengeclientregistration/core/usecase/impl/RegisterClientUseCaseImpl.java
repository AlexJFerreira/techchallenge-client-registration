package br.com.postech.techchallengeclientregistration.core.usecase.impl;

import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import br.com.postech.techchallengeclientregistration.core.exceptions.ConflictException;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import br.com.postech.techchallengeclientregistration.core.usecase.RegisterClientUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientUseCaseImpl implements RegisterClientUseCase {

  private final ClientGateway clientGateway;

  @Override
  public void execute(Client client) {
    var existsByCpf = clientGateway.checkClientRegistrationByCpf(client.getCpf());

    if (existsByCpf) {
      throw new ConflictException("Cliente com CPF %s já está cadastrado".formatted(client.getCpf()));
    }
    clientGateway.registerClient(client);

  }
}
