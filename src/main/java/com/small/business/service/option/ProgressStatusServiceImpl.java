package com.small.business.service.option;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.option.ProgressStatusDao;
import com.small.business.model.option.ProgressStatus;

@Service("progressStatusService")
public class ProgressStatusServiceImpl implements ProgressStatusService {

    @Autowired
    private ProgressStatusDao progressStatusDao;

    @Override
    public List<ProgressStatus> getAllProgressStatus() {
        return progressStatusDao.getAllProgressStatus();
    }

    @Override
    public List<ProgressStatus> getAllCandidateProgressStatus() {
        return progressStatusDao.getAllCandidateProgressStatus();
    }

    @Override
    public ProgressStatus getCandidateProgressStatusStatusById(Long id) {
    	return progressStatusDao.getCandidateProgressStatusStatusById(id);
    }
    
}
