package com.small.business.service.option;

import java.util.List;

import com.small.business.model.option.ProgressStatus;

public interface ProgressStatusService {

    public List<ProgressStatus> getAllProgressStatus();

    public List<ProgressStatus> getAllCandidateProgressStatus();
    
    public ProgressStatus getCandidateProgressStatusStatusById(Long id);
}
