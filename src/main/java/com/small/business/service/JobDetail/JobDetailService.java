package com.small.business.service.JobDetail;

import java.util.List;

import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.category.JobDetailExt;

public interface JobDetailService {

    public List<JobDetailExt> getAllJobDetail();

    public JobDetailExt getJobDetailById(Long id);
    
    public JobDetailExt getJobDetailByIdExt(Long categoryDetailId);
    
    public long addJobDetail(JobDetail jobDetail);

    public boolean deleteJobDetailById(Long id);

    public boolean deleteAll();

    public boolean updateJobDetail(JobDetail jobDetail);
}
