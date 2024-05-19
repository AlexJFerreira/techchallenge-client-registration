package br.com.postech.techchallengeclientregistration.core.usecase.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import br.com.postech.techchallengeclientregistration.core.exceptions.NotFoundException;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import br.com.postech.techchallengeclientregistration.utils.ClientTestProvider;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SearchClientByCpfUseCaseImplTest extends ClientTestProvider {

  @InjectMocks
  private SearchClientByCpfUseCaseImpl searchClientByCpfUseCase;

  @Mock
  private ClientGateway clientGateway;

  @Test
  void executeWithSuccess() {
    //Arrange
    var cpfToSearch = "36227297836";
    var client = getFakeClient();

    when(clientGateway.searchClientByCpf(cpfToSearch))
        .thenReturn(Optional.of(client));


    //Act
    Client clientResponse = searchClientByCpfUseCase.execute(cpfToSearch);

    //Assert
    verify(clientGateway).searchClientByCpf(cpfToSearch);
    assertNotNull(clientResponse);
  }

  @Test
  void executeWhenClientIsNotFoundThenThrowsNofFoundException() {
    //Arrange
    var cpfToSearch = "36227297836";

    when(clientGateway.searchClientByCpf(cpfToSearch))
        .thenReturn(Optional.empty());

    //Act + assert
    assertThrows(NotFoundException.class, () -> searchClientByCpfUseCase.execute(cpfToSearch));

    //Assert
    verify(clientGateway).searchClientByCpf(cpfToSearch);
  }
}