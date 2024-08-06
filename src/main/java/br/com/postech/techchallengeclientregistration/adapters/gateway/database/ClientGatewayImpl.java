package br.com.postech.techchallengeclientregistration.adapters.gateway.database;

import br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity.ClientDataInactivatioRequestEntity;
import br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity.ClientEntity;
import br.com.postech.techchallengeclientregistration.adapters.gateway.database.repository.ClientDataInactivationRequestRepository;
import br.com.postech.techchallengeclientregistration.adapters.gateway.database.repository.ClientRepository;
import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;
import br.com.postech.techchallengeclientregistration.core.domain.entity.ClientInactivation;
import br.com.postech.techchallengeclientregistration.core.gateway.database.ClientGateway;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientGatewayImpl implements ClientGateway {

  private final ClientRepository clientRepository;
  private final ClientDataInactivationRequestRepository clientInactivationRepository;
  private final ModelMapper modelMapper;

  @Override
  @Transactional
  public void registerClient(Client client) {
    var clientEntity = modelMapper.map(client, ClientEntity.class);
    clientRepository.save(clientEntity);
  }

  public Optional<Client> searchClientByCpf(String cpf) {
    return clientRepository.findById(cpf)
        .map(clientEntity -> modelMapper.map(clientEntity, Client.class));
  }

  @Override
  public Boolean checkClientRegistrationByCpf(String cpf) {
    return clientRepository.existsById(cpf);
  }

  @Override
  public String createDataInactivationRequest(ClientInactivation clientInactivation) {
    var clientInactivationEntity =
        clientInactivationRepository.save(modelMapper.map(clientInactivation, ClientDataInactivatioRequestEntity.class));
    return clientInactivationEntity.getId().toString();
  }
}
