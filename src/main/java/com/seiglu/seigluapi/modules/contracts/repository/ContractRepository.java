package com.seiglu.seigluapi.modules.contracts.repository;
import com.seiglu.seigluapi.modules.contracts.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractRepository extends JpaRepository<ContractEntity, UUID> {
    Optional<ContractEntity> findByTherapistId(UUID therapistId);
}
