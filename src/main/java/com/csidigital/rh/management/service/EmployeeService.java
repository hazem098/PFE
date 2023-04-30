package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(EmployeeRequest request, Long id);

    void deleteEmployee(Long id);

    String employeeSerialNumberGenerator ();

    List<Employee> findByEmployeeStatus();

    List<Employee> getAllCandidates ();
    List<Employee> getAllResourcesBackOffice ();

    List<Employee> getAllResourcesInterne ();

    List<Employee> getAllResourcesExterne();
}
