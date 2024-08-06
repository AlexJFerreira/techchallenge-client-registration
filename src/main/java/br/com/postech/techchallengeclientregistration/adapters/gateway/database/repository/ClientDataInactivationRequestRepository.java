package br.com.postech.techchallengeclientregistration.adapters.gateway.database.repository;

import br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity.ClientDataInactivatioRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataInactivationRequestRepository extends JpaRepository<ClientDataInactivatioRequestEntity, Integer> {
}
