package com.small.business.dao.option;

import java.util.List;

import com.small.business.model.option.ProgressStatus;

public interface ProgressStatusDao {

    public List<ProgressStatus> getAllProgressStatus();

    public List<ProgressStatus> getAllCandidateProgressStatus();

    public ProgressStatus getCandidateProgressStatusStatusById(Long id);

} 
