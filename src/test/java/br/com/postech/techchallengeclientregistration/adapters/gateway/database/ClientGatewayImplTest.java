package br.com.postech.techchallengeclientregistration.adapters.gateway.database;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.postech.techchallengeclientregistration.adapters.gateway.database.repository.ClientRepository;
import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import br.com.postech.techchallengeclientregistration.core.usecase.impl.RegisterClientUseCaseImpl;
import br.com.postech.techchallengeclientregistration.infra.ModelMapperConfig;
import br.com.postech.techchallengeclientregistration.utils.ClientTestProvider;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class ClientGatewayImplTest extends ClientTestProvider {

  @InjectMocks
  private ClientGatewayImpl clientGateway;

  @Mock
  private ClientRepository clientRepository;

  @BeforeEach
  public void beforeEach() {
    ReflectionTestUtils.setField(clientGateway, "modelMapper", new ModelMapperConfig().modelMapper());
  }

  @Test
  void searchClientByCpf() {
    // Arrange
    var cpfToSearch = "36227297836";
    var clientEntityOutput = getFakeEntityClient();

    when(clientRepository.findById(cpfToSearch))
        .thenReturn(Optional.of(clientEntityOutput));

    //act
    Optional<Client> client = clientGateway.searchClientByCpf(cpfToSearch);

    //Assert
    verify(clientRepository).findById(cpfToSearch);
    assertTrue(client.isPresent());
  }

  @Test
  void checkClientRegistrationByCpf() {
    //Arrange
    var cpfToCheck = "36227297836";
    when(clientRepository.existsById(cpfToCheck))
        .thenReturn(true);

    //Act
    Boolean exists = clientGateway.checkClientRegistrationByCpf(cpfToCheck);

    //Assert
    verify(clientRepository).existsById(cpfToCheck);
    assertTrue(exists);
  }
}