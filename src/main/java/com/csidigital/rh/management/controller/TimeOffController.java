package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.TimeOffImpl;
import com.csidigital.rh.shared.dto.request.TimeOffRequest;
import com.csidigital.rh.shared.dto.response.TimeOffResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/TimeOff")
public class TimeOffController {
    @Autowired
    private TimeOffImpl timeOffImpl ;

    @GetMapping("getAll")
    public List<TimeOffResponse> getAllTimeOff() {
        return timeOffImpl.getAllTimeOff();
    }

    @GetMapping("/getBy/{id}")
    public TimeOffResponse getTimeOffById(@PathVariable Long id){
        return timeOffImpl.getTimeOffById(id);
    }

    @PostMapping("/add")
    public TimeOffResponse createTimeOff(@Valid @RequestBody TimeOffRequest timeOffRequest){
        return timeOffImpl.createTimeOff(timeOffRequest);
    }

    @PutMapping("/update/{id}")
    public TimeOffResponse updateTimeOff(@Valid @RequestBody TimeOffRequest timeOffRequest,
                                                   @PathVariable Long id){
        return timeOffImpl.updateTimeOff(timeOffRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTimeOff(@PathVariable Long id){
        timeOffImpl.deleteTimeOff(id);
    }

}
