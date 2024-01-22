package com.seiglu.seigluapi.modules.contracts.controller;

import com.seiglu.seigluapi.modules.contracts.ContractEntity;
import com.seiglu.seigluapi.modules.contracts.useCase.ContractUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ContractUseCase contractUseCase;
    @PostMapping("")
    public ResponseEntity<Object> createContract(@Valid @RequestBody ContractEntity contractEntity) {
        try {
            var contract = this.contractUseCase.createContract(contractEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(contractEntity);
        } catch (Exception err) {

            return ResponseEntity.badRequest().body(err.getMessage());
        }
    }

}
