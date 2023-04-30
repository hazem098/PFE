package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.ExceptionalFeeImpl;
import com.csidigital.rh.shared.dto.request.ExceptionalFeeRequest;
import com.csidigital.rh.shared.dto.response.ExceptionalFeeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rh/exceptionalFees")
public class ExceptionalFeeController {
    @Autowired
    private ExceptionalFeeImpl ExceptionalFeeService ;

    @GetMapping("/getExceptionalFees")
    public List<ExceptionalFeeResponse> getAllExceptionalFees() {
        return ExceptionalFeeService.getAllExceptionalFees();
    }

    @GetMapping("/get/{id}")
    public ExceptionalFeeResponse getExceptionalFeeById(@PathVariable Long id){
        return ExceptionalFeeService.getExceptionalFeeById(id);
    }

    @PostMapping("/add")
    public ExceptionalFeeResponse createExceptionalFee(@Valid @RequestBody ExceptionalFeeRequest exceptionalFeeRequest){
        return ExceptionalFeeService.createExceptionalFee(exceptionalFeeRequest);
    }

    @PutMapping("/update/{id}")
    public ExceptionalFeeResponse updateExceptionalFee(@Valid @RequestBody ExceptionalFeeRequest exceptionalFeeRequest,
                                         @PathVariable Long id){
        return ExceptionalFeeService.updateExceptionalFee(exceptionalFeeRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExceptionalFee(@PathVariable Long id){
        ExceptionalFeeService.deleteExceptionalFee(id);
    }
}
