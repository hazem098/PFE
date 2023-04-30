package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.ExpenseReport;
import com.csidigital.rh.dao.repository.ExpenseReportRepository;
import com.csidigital.rh.management.service.ExpenseReportService;
import com.csidigital.rh.shared.dto.request.ExpenseReportRequest;
import com.csidigital.rh.shared.dto.response.ExpenseReportResponse;
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
public class ExpenseReportImpl implements ExpenseReportService {
    @Autowired
    private ExpenseReportRepository expenseReportRepository ;
    @Autowired
    private ModelMapper modelMapper ;
    
    @Override
    public ExpenseReportResponse createExpenseReport(ExpenseReportRequest request) {
        ExpenseReport expenseReport = modelMapper.map(request, ExpenseReport.class);
        ExpenseReport expenseReportSaved = expenseReportRepository.save(expenseReport);
        return modelMapper.map(expenseReportSaved, ExpenseReportResponse.class);
    }

    @Override
    public List<ExpenseReportResponse> getAllExpenseReports() {
        List<ExpenseReport> expenseReports = expenseReportRepository.findAll();
        List<ExpenseReportResponse> expenseReportList = new ArrayList<>();

        for (ExpenseReport expenseReport : expenseReports) {
            ExpenseReportResponse response = modelMapper.map(expenseReport, ExpenseReportResponse.class);
            expenseReportList.add(response);
        }

        return expenseReportList;
    }

    @Override
    public ExpenseReportResponse getExpenseReportById(Long id) {
        ExpenseReport expenseReport = expenseReportRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExpenseReport with id " +id+ " not found"));
        ExpenseReportResponse expenseReportResponse = modelMapper.map(expenseReport, ExpenseReportResponse.class);
        return expenseReportResponse;
    }

    @Override
    public ExpenseReportResponse updateExpenseReport(ExpenseReportRequest request, Long id) {
        ExpenseReport existingExpenseReport = expenseReportRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExpenseReport with id: " + id + " not found"));
        modelMapper.map(request, existingExpenseReport);
        ExpenseReport savedExpenseReport = expenseReportRepository.save(existingExpenseReport);
        return modelMapper.map(savedExpenseReport, ExpenseReportResponse.class);
    }

    @Override
    public void deleteExpenseReport(Long id) {
    expenseReportRepository.deleteById(id);
    }
}
