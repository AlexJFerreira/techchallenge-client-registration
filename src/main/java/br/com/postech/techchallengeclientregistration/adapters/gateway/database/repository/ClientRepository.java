package br.com.postech.techchallengeclientregistration.adapters.gateway.database.repository;

import br.com.postech.techchallengeclientregistration.adapters.gateway.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, String> {
  boolean existsByCpf(String cpf);

}
