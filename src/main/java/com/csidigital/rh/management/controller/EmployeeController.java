package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.management.service.impl.EmployeeImpl;
import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/rh/employee")
public class EmployeeController {
    @Autowired
    private EmployeeImpl employeeService;
    @Autowired
    public EmployeeController(EmployeeImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getEmployees")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/add")
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponse updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest,
                                         @PathVariable Long id){
        return employeeService.updateEmployee(employeeRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
@GetMapping("/testV1")
    public List<Employee> getEmployee(){
        return employeeService.findByEmployeeStatus();
}

@GetMapping("/getAllCandidates")
    public List<Employee> getAllCandidates(){
        return employeeService.getAllCandidates();
}
    @GetMapping("/getAllResourcesBackOffice")
    public List<Employee> getAllResourcesBackOffice(){
        return employeeService.getAllResourcesBackOffice();
    }
    @GetMapping("/getAllResourcesInterne")
    public List<Employee> getAllResourcesInterne(){
        return employeeService.getAllResourcesInterne();
    }
    @GetMapping("/getAllResourcesExterne")
    public List<Employee> getAllResourcesExterne(){
        return employeeService.getAllResourcesExterne();
    }
}
