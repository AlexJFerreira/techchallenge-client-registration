package br.com.postech.techchallengeclientregistration.core.usecase;

import br.com.postech.techchallengeclientregistration.core.domain.entity.ClientInactivation;

public interface RegisterClientDataInactivationRequestUseCase {
  String execute(ClientInactivation clientInactivation);
}
