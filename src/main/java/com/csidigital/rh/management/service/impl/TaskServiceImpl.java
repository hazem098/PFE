package com.csidigital.rh.management.service.impl;




import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.dao.repository.ProjectRepository;
import com.csidigital.rh.dao.repository.ResourceRepository;
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
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceRepository resourceRepository;

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



        Project project = null ;
        if (projectRepository.findById(taskDtoRequest.getProjectNum()).orElseThrow() !=null) {
            project = projectRepository.findById(taskDtoRequest.getProjectNum()).orElseThrow();

        }
        Task task = modelMapper.map(taskDtoRequest, Task.class);

        project.getTasks().add(task);

        task.setProject(project);


        Task TaskSaved = taskRepository.save(task);

        projectRepository.save(project);
        return modelMapper.map(TaskSaved, TaskDtoResponse.class);
    }

    @Override
    public TaskDtoResponse updateTask(Long id, TaskDtoRequest taskDtoRequest) {

        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id: " + id + " not found"));
     Project project = projectRepository.findById(taskDtoRequest.getProjectNum()).orElseThrow();
        modelMapper.map(taskDtoRequest, task);
        //Resource newResource = resourceRepository.findById(taskDtoRequest.getResourceNum())
          //      .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + taskDtoRequest.getResourceNum() + " not found"));

        // Retrieve the existing resource
        //Resource existingResource = task.getResource();
        //Project existingProject = task.getProject();
        // Update the resource association if it has changed
        //if (existingResource != null && !existingResource.equals(newResource)) {
          //  existingResource.getTasks().remove(task); // Remove the task from the existing resource
        //}
      // task.setProject(task.getProject());
        //task.setResource(newResource);


        Task updatedTask = taskRepository.save(task);
        //esourceRepository.save(newResource);
        projectRepository.save(project);
        return modelMapper.map(updatedTask, TaskDtoResponse.class);
    }

    /*public void update(TaskDtoRequest taskDtoRequest) {
        Project project = projectRepository.findById(taskDtoRequest.getProjectNum()).orElseThrow();
        Resource resource = resourceRepository.findById(taskDtoRequest.getResourceNum()).orElseThrow();

        Task task = taskRepository.findByProjectIdAndResourceId(taskDtoRequest.getProjectNum(), taskDtoRequest.getResourceNum())
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));

        modelMapper.map(taskDtoRequest, task);
        taskRepository.save(task);
    }*/
    @Override
    public void deleteTaskById(Long id) {
      Task task = taskRepository.findById(id).orElseThrow();


        // Remove the task from the associated project
        Project project = task.getProject();
        if (project != null) {
            project.getTasks().remove(task);
        }


        taskRepository.deleteById(id);

    }
}
