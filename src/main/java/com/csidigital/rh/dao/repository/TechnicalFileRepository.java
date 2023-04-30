package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.TechnicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalFileRepository extends JpaRepository<TechnicalFile,Long> {
}
