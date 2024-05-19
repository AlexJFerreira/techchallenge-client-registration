package br.com.postech.techchallengeclientregistration.core.usecase.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.postech.techchallengeclientregistration.core.exceptions.ConflictException;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import br.com.postech.techchallengeclientregistration.utils.ClientTestProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RegisterClientUseCaseImplTest extends ClientTestProvider {

  @InjectMocks
  private RegisterClientUseCaseImpl registerClientUseCase;

  @Mock
  private ClientGateway clientGateway;

  @Test
  void executeWithSuccess() {
    //Arrange
    var inputClient = getFakeClient();
    when(clientGateway.checkClientRegistrationByCpf(inputClient.getCpf()))
        .thenReturn(false);
    doNothing().when(clientGateway).registerClient(inputClient);

    //Act
    registerClientUseCase.execute(inputClient);

    //Assert
    verify(clientGateway).registerClient(inputClient);
    verify(clientGateway).checkClientRegistrationByCpf(inputClient.getCpf());
  }

  @Test
  void executeWhenClientAlreadyRegisteredThenThrowsConflictException() {
    //Arrange
    var inputClient = getFakeClient();
    when(clientGateway.checkClientRegistrationByCpf(inputClient.getCpf()))
        .thenReturn(true);

    //Act + assert
    assertThrows(ConflictException.class, () -> registerClientUseCase.execute(inputClient));

    //Assert
    verify(clientGateway, never()).registerClient(inputClient);
    verify(clientGateway).checkClientRegistrationByCpf(inputClient.getCpf());
  }
}