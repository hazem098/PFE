package com.csidigital.rh.management.service.impl;




import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.dao.repository.TaskRepository;
import com.csidigital.rh.management.service.TaskService;
import com.csidigital.rh.shared.dto.request.TaskDtoRequest;
import com.csidigital.rh.shared.dto.response.TaskDtoResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TaskDtoResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDtoResponse> taskList = new ArrayList<>();

        for (Task task : tasks) {
            TaskDtoResponse taskDtoResponse = modelMapper.map(task,TaskDtoResponse.class);
            taskList.add(taskDtoResponse);
        }

        return taskList;
    }

    @Override
    public TaskDtoResponse getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id " +id+ " not found"));
        TaskDtoResponse taskDtoResponse = modelMapper.map(task, TaskDtoResponse.class);
        return taskDtoResponse;
    }

    @Override
    public TaskDtoResponse createTask(TaskDtoRequest taskDtoRequest) {
        Task task = modelMapper.map(taskDtoRequest, Task.class);
        Task TaskSaved = taskRepository.save(task);
        return modelMapper.map(TaskSaved, TaskDtoResponse.class);
    }

    @Override
    public TaskDtoResponse updateTask(Long id, TaskDtoRequest taskDtoRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id: " + id + " not found"));
        modelMapper.map(taskDtoRequest, task);
        Task updatedTask = taskRepository.save(task);
        return modelMapper.map(updatedTask, TaskDtoResponse.class);
    }

    @Override
    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);

    }
}
