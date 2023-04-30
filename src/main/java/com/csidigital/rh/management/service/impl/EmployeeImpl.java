package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.dao.repository.EmployeeRepository;
import com.csidigital.rh.management.service.EmployeeService;
import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.EmployeeResponse;
import com.csidigital.rh.shared.enumeration.EmployeeStatus;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository ;

    @Autowired
    private ModelMapper modelMapper ;





    @Override
    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = modelMapper.map(request, Employee.class);
        if (employee instanceof BackOffice || employee instanceof Resource) {
            String code = employeeSerialNumberGenerator();
            employee.setSerialNumber(code);
        }
        else {
            employee.setSerialNumber(null);
        }

        Employee employeeSaved = employeeRepository.save(employee);
        return modelMapper.map(employeeSaved, EmployeeResponse.class);


    }


    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeList = new ArrayList<>();

        for (Employee employee : employees) {
            EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
            employeeList.add(response);
        }

        return employeeList;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " +id+ " not found"));
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
        return employeeResponse;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request, Long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id: " + id + " not found"));
        modelMapper.map(request, existingEmployee);
        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return modelMapper.map(savedEmployee, EmployeeResponse.class);
    }

    @Override
    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);
    }

    @Override
    public String employeeSerialNumberGenerator() {
        return null;
    }


//
//    @Override
//    public String employeeSerialNumberGenerator() {
//        String lastCode = employeeRepository.resourceLastCode();
//        if (lastCode == null) {
//            return "E_0001";
//        }
//        Integer codeNumber = Integer.parseInt(lastCode.substring(2));
//
//        if (codeNumber < 10000) {
//            codeNumber= codeNumber+Integer.parseInt(String.format("%04d", 1));
//        }
//        String numbers= codeNumber.toString();
//        if (numbers.length()<4){
//            for(int i=0;i<3;i++){
//                numbers='0'+ numbers;
//            }
//
//        }
//        return "E_" + numbers;
//    }

    @Override
    public List<Employee> findByEmployeeStatus() {
        return employeeRepository.findByEmployeeStatus(EmployeeStatus.CONVERTED_TO_RESOURCE);
    }

    @Override
    public List<Employee> getAllCandidates() {
        return employeeRepository.getAllCandidates();
    }

    @Override
    public List<Employee> getAllResourcesBackOffice() {
        return employeeRepository.getAllResourcesBackOffice();
    }

    @Override
    public List<Employee> getAllResourcesInterne() {
        return employeeRepository.getAllResourcesInterne();
    }

    @Override
    public List<Employee> getAllResourcesExterne() {
        return employeeRepository.getAllResourcesExterne();
    }
}
