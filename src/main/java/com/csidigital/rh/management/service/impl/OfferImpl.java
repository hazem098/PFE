package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Offer;
import com.csidigital.rh.dao.repository.OfferRepository;
import com.csidigital.rh.management.service.OfferService;
import com.csidigital.rh.shared.dto.request.OfferRequest;
import com.csidigital.rh.shared.dto.response.OfferResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OfferImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OfferResponse createOffer(OfferRequest request) {
        Offer offer = modelMapper.map(request, Offer.class);
        Offer OfferSaved = offerRepository.save(offer);
        return modelMapper.map(OfferSaved, OfferResponse.class);
    }

    @Override
    public List<OfferResponse> getAllOffer() {
        List<Offer> offer = offerRepository.findAll();
        List<OfferResponse> offerList = new ArrayList<>();


        for (Offer offers: offer) {
            OfferResponse response = modelMapper.map(offers, OfferResponse.class);
            offerList.add(response);
        }

        return offerList;
    }

    @Override
    public OfferResponse getOfferById(Long id) {
        Offer offer =offerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Offer with id " +id+ " not found"));
        OfferResponse offerResponse = modelMapper.map(offer, OfferResponse.class);
        return offerResponse;
    }

    @Override
    public OfferResponse updateOffer(OfferRequest request, Long id) {
        Offer existingOffer = offerRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Offer with id: " + id + " not found"));
        modelMapper.map(request, existingOffer);
        Offer savedOffer = offerRepository.save(existingOffer);
        return modelMapper.map(savedOffer, OfferResponse.class);
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }

}
