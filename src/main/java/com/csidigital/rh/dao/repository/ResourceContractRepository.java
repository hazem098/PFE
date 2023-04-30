package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.ResourceContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceContractRepository extends JpaRepository<ResourceContract,Long> {
}
