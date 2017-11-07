package com.small.business.service.JobDetail;

import java.util.List;

import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailExt;

public interface JobDetailService {

    public List<JobDetail> getAllJobDetail();

    public JobDetailExt getJobDetailExtByCategoryDetailId(Long categoryDetailId);
    
    public JobDetail getJobDetailById(Long id);
    
    public boolean addJobDetail(JobDetail jobDetail);

    public boolean deleteJobDetailById(Long id);

    public boolean deleteAll();

    public boolean updateJobDetail(JobDetail jobDetail);
}
