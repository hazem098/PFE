package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {


}
