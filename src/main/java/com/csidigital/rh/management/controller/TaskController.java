package com.csidigital.rh.management.controller;



import com.csidigital.rh.management.service.TaskService;
import com.csidigital.rh.management.service.impl.TaskServiceImpl;
import com.csidigital.rh.shared.dto.request.TaskDtoRequest;
import com.csidigital.rh.shared.dto.response.TaskDtoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskService;
    @GetMapping("/getAll")
    public List<TaskDtoResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<TaskDtoResponse> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public TaskDtoResponse createTask(@Valid @RequestBody TaskDtoRequest taskDtoRequest) {
        return taskService.createTask(taskDtoRequest);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<TaskDtoResponse> updateTask(@Valid @RequestBody TaskDtoRequest taskDtoRequest, @PathVariable Long id) {
        return new ResponseEntity<>(taskService.updateTask(id,taskDtoRequest), HttpStatus.OK);
    }
    /*@PutMapping("/update")
    public void update(@Valid @RequestBody TaskDtoRequest taskDtoRequest) {
       taskService.update(taskDtoRequest);
    }*/
    @DeleteMapping("/deleteById/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskById(id);

    }


}
