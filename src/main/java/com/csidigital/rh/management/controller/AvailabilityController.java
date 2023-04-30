package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.AvailabilityImpl;
import com.csidigital.rh.shared.dto.request.AvailabilityRequest;
import com.csidigital.rh.shared.dto.response.AvailabilityResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rh/Availability")

public class AvailabilityController {
    @Autowired
    private AvailabilityImpl availabilityImpl ;

    @GetMapping("getAll")
    public List<AvailabilityResponse> getAllAvailability() {
        return availabilityImpl.getAllAvailability();
    }

    @GetMapping("/getBy/{id}")
    public AvailabilityResponse getAvailabilityById(@PathVariable Long id){
        return availabilityImpl.getAvailabilityById(id);
    }

    @PostMapping("/add")
    public AvailabilityResponse createAvailability(@Valid @RequestBody AvailabilityRequest availabilityRequest){
        return availabilityImpl.createAvailability(availabilityRequest);
    }

    @PutMapping("/update/{id}")
    public AvailabilityResponse updateAvailability(@Valid @RequestBody AvailabilityRequest availabilityRequest,
                                                 @PathVariable Long id){
        return availabilityImpl.updateAvailability(availabilityRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAvailability(@PathVariable Long id){
        availabilityImpl.deleteAvailability(id);
    }

}
