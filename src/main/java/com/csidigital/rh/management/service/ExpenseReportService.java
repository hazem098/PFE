package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.ExpenseReportRequest;
import com.csidigital.rh.shared.dto.response.ExpenseReportResponse;

import java.util.List;

public interface ExpenseReportService {
    ExpenseReportResponse createExpenseReport(ExpenseReportRequest request);
    List<ExpenseReportResponse> getAllExpenseReports();
    ExpenseReportResponse getExpenseReportById(Long id);

    ExpenseReportResponse updateExpenseReport(ExpenseReportRequest request, Long id);

    void deleteExpenseReport(Long id);
}
