package com.csidigital.rh.dao.repository;


import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}

