package br.com.postech.techchallengeclientregistration.core.usecase;


import br.com.postech.techchallengeclientregistration.core.domain.entity.Client;

public interface RegisterClientUseCase {
  void execute(Client client);

}
