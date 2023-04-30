package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.ExpenseReportImpl;
import com.csidigital.rh.shared.dto.request.ExpenseReportRequest;
import com.csidigital.rh.shared.dto.response.ExpenseReportResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rh/expenseReport")


public class ExpenseReportController {
    @Autowired
    private ExpenseReportImpl ExpenseReportService ;

    @GetMapping("/getExpenseReports")
    public List<ExpenseReportResponse> getAllExpenseReports() {
        return ExpenseReportService.getAllExpenseReports();
    }

    @GetMapping("/get/{id}")
    public ExpenseReportResponse getExpenseReportById(@PathVariable Long id){
        return ExpenseReportService.getExpenseReportById(id);
    }

    @PostMapping("/add")
    public ExpenseReportResponse createExpenseReport(@Valid @RequestBody ExpenseReportRequest expenseReportRequest){
        return ExpenseReportService.createExpenseReport(expenseReportRequest);
    }

    @PutMapping("/update/{id}")
    public ExpenseReportResponse updateExpenseReport(@Valid @RequestBody ExpenseReportRequest expenseReportRequest,
                                         @PathVariable Long id){
        return ExpenseReportService.updateExpenseReport(expenseReportRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpenseReport(@PathVariable Long id){
        ExpenseReportService.deleteExpenseReport(id);
    }
}
