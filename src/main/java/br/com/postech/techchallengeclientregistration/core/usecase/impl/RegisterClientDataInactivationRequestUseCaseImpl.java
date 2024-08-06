package br.com.postech.techchallengeclientregistration.core.usecase.impl;

import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import br.com.postech.techchallengeclientregistration.core.domain.entity.ClientInactivation;
import br.com.postech.techchallengeclientregistration.core.exceptions.NotFoundException;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import br.com.postech.techchallengeclientregistration.core.usecase.RegisterClientDataInactivationRequestUseCase;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterClientDataInactivationRequestUseCaseImpl implements RegisterClientDataInactivationRequestUseCase {

  private final ClientGateway clientGateway;


  @Override
  public String execute(ClientInactivation clientInactivation) {
    clientGateway.searchClientByCpf(clientInactivation.getCpf())
        .orElseThrow(() -> new NotFoundException("Client not found"));

    return clientGateway.createDataInactivationRequest(clientInactivation);
  }
}
