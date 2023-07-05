package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.Phase;
import com.csidigital.rh.management.service.impl.PhaseService;
import com.csidigital.rh.shared.dto.request.PhaseRequest;
import com.csidigital.rh.shared.dto.request.ProjectDtoRequest;
import com.csidigital.rh.shared.dto.response.PhaseResponse;
import com.csidigital.rh.shared.dto.response.ProjectDtoResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping("/phase")
public class PhaseController {
    @Autowired
    private PhaseService phaseService;
    @GetMapping("/getAll")
    public ResponseEntity<List<Phase>> getAllPhases() {
        return new ResponseEntity<>(phaseService.getAllPhases(), HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PhaseResponse> getPhaseById(@PathVariable Long id) {
        return new ResponseEntity<>(phaseService.getPhaseById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Phase> createPhase(@Valid @RequestBody PhaseRequest phaseRequest,  @RequestParam Long projectId) {
        return new ResponseEntity<>(phaseService.createPhase(phaseRequest , projectId), HttpStatus.OK);
    }
    @PostMapping("/addphases")
    public ResponseEntity<List<Phase>> createPhases(@Valid @RequestBody List<PhaseRequest> phaseRequests, @RequestParam Long projectId) {
        List<Phase> phases = phaseService.createPhases(phaseRequests, projectId);
        return new ResponseEntity<>(phases, HttpStatus.OK);
    }

}
