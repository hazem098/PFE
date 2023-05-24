package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.AssResourceProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssResourceProjetRepository extends JpaRepository<AssResourceProjet , Long> {

}
