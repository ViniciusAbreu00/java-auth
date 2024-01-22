package com.seiglu.seigluapi.modules.contracts.useCase;

import com.seiglu.seigluapi.modules.contracts.ContractEntity;
import com.seiglu.seigluapi.modules.contracts.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractUseCase {
    @Autowired
    ContractRepository contractRepository;

    public ContractEntity createContract(ContractEntity contract) {
        return contractRepository.save(contract);
    }

}
