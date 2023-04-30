package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.management.service.impl.CertificationImpl;
import com.csidigital.rh.management.service.impl.ContractImpl;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.request.ContractRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import com.csidigital.rh.shared.dto.response.ContractResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/contract")
public class ContractController {

    @Autowired
    private ContractImpl contract;

    @GetMapping("/getAll")
    public List<ContractResponse> getAllContracts(){
        return contract.getAllContracts();
    }

    @GetMapping("/getContract/{id}")
    public ContractResponse getContractById(@PathVariable Long id){
        return contract.getContractById(id);
    }

    @PostMapping("/addContract")
    public ContractResponse createContract(@Valid @RequestBody ContractRequest contractRequest){
        return contract.createContract(contractRequest);
    }

    @PutMapping("/updateContract/{id}")
    public ContractResponse updateContract(@Valid @RequestBody ContractRequest contractRequest,
                                                     @PathVariable Long id){
        return contract.updateContract(contractRequest, id);
    }

    @DeleteMapping("/deleteContract/{id}")
    public void deleteContract(@PathVariable Long id){
        contract.deleteContract(id);
    }
    @PutMapping("/updateStatusById")
    void updateStatusById(Long id, String contractStatus){
        contract.updateStatusById(id, contractStatus);
    }
    @PutMapping("/updateToAcceptedById")
    void updateStatusToAcceptedById(Long id){
        contract.updateStatusToAcceptedById(id);
    }
    @PutMapping("/updateToRefusedById")
    void updateStatusToRefusedById(Long id){
        contract.updateStatusToRefusedById(id);
    }
}
