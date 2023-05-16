package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.dao.entity.Timesheet;
import com.csidigital.rh.dao.repository.TimesheetRepository;
import com.csidigital.rh.management.service.TimesheetService;

import com.csidigital.rh.shared.dto.request.TimesheetDtoRequest;
import com.csidigital.rh.shared.dto.response.TaskDtoResponse;
import com.csidigital.rh.shared.dto.response.TimesheetDtoResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
@Service
public class TimesheetServiceImpl implements TimesheetService {
    @Autowired
    private ModelMapper modelMapper ;

    @Autowired
    private TimesheetRepository timesheetRepository ;
    @Override
    public List<TimesheetDtoResponse> getAllTimesheets() {
        List<Timesheet> timesheets = timesheetRepository.findAll();
        List<TimesheetDtoResponse> timeSheetList = new ArrayList<>();

        for (Timesheet timesheet : timesheets) {
            TimesheetDtoResponse timesheetDtoResponse = modelMapper.map(timesheet,TimesheetDtoResponse.class);
            timeSheetList.add(timesheetDtoResponse);
        }

        return timeSheetList;
    }

    @Override
    public TimesheetDtoResponse getTimesheetById(Long id) {

        Timesheet timesheet = timesheetRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id " +id+ " not found"));
        TimesheetDtoResponse timesheetDtoResponse = modelMapper.map(timesheet, TimesheetDtoResponse.class);
        return timesheetDtoResponse;

    }

    @Override
    public TimesheetDtoResponse createTimesheet(TimesheetDtoRequest timesheetDtoRequest) {

        Timesheet timesheet = modelMapper.map(timesheetDtoRequest, Timesheet.class);
        Timesheet timesheetSaved = timesheetRepository.save(timesheet);
        return modelMapper.map(timesheetSaved, TimesheetDtoResponse.class);

    }

    @Override
    public TimesheetDtoResponse updateTimesheet(Long id, TimesheetDtoRequest timesheetDtoRequest) {

        Timesheet timesheet = timesheetRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Timesheet with id: " + id + " not found"));
        modelMapper.map(timesheetDtoRequest, timesheet);
        Timesheet updatedTimeSheet = timesheetRepository.save(timesheet);
        return modelMapper.map(updatedTimeSheet, TimesheetDtoResponse.class);
    }

    @Override
    public void deleteTimesheetById(Long id) {
    timesheetRepository.deleteById(id);
    }
}
