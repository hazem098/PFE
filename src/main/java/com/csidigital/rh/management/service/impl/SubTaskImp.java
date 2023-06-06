package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.entity.SubTask;
import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.dao.repository.*;
import com.csidigital.rh.shared.dto.request.SousTacheRequest;
import com.csidigital.rh.shared.dto.response.SousTacheResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubTaskImp {
    @Autowired
    private SubTaskRepository subtaskRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SousTacheResponse> getAllTasks() {
        List<SubTask> tasks = subtaskRepository.findAll();
        List<SousTacheResponse> subTaskList = new ArrayList<>();

        for (SubTask task : tasks) {
            SousTacheResponse SousTacheResponse = modelMapper.map(task, SousTacheResponse.class);

            subTaskList.add(SousTacheResponse);

        }

        return subTaskList;
    }


    public SousTacheResponse getTaskById(Long id) {
        SubTask task = subtaskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task with id " +id+ " not found"));
        SousTacheResponse sousTacheResponse = modelMapper.map(task, SousTacheResponse.class);

        return sousTacheResponse;
    }

    public SousTacheResponse createTask(SousTacheRequest sousTacheRequest) {
        Resource resource = null ;
        Task tache = null ;
        if( resourceRepository.findById(sousTacheRequest.getResourceNum()) !=null){
            resource = resourceRepository.findById(sousTacheRequest.getResourceNum()).orElseThrow();
        }
        if( resourceRepository.findById(sousTacheRequest.getTaskNum()) !=null){
        tache = taskRepository.findById(sousTacheRequest.getTaskNum()).orElseThrow(() -> new NoSuchElementException("Task with the given ID does not exist"));}
        SubTask subTask = modelMapper.map(sousTacheRequest, SubTask.class);


        subTask.setResource(resource);
        resource.getSubTasks().add(subTask);
        subTask.setTask(tache);
        tache.getSubTaskList().add(subTask);

        SubTask TaskSaved = subtaskRepository.save(subTask);

            resourceRepository.save(resource);
            taskRepository.save(tache);
        return modelMapper.map(TaskSaved, SousTacheResponse.class);
    }



}
