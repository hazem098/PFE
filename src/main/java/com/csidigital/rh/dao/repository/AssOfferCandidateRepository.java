package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.OfferCandidate;
import com.csidigital.rh.dao.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssOfferCandidateRepository extends JpaRepository<OfferCandidate, Long> {
//     List<OfferCandidate> findByOffer(Offer offer);
//     List<OfferCandidate> findByCandidate(Employee employee);
}
