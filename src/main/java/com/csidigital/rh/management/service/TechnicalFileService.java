package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.SkillsRequest;
import com.csidigital.rh.shared.dto.request.TechnicalFileRequest;
import com.csidigital.rh.shared.dto.response.SkillsResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;

import java.util.List;

public interface TechnicalFileService {
    TechnicalFileResponse createTechnicalFile(TechnicalFileRequest request);
    List<TechnicalFileResponse> getAllTechnicalFiles();
    TechnicalFileResponse getTechnicalFileById(Long id);

    TechnicalFileResponse updateTechnicalFile(TechnicalFileRequest request, Long id);

    void deleteTechnicalFile(Long id);
}
