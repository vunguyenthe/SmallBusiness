package com.small.business.dao.JobDetail;

import java.util.List;

import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailExt;


public interface JobDetailDao {

    public List<JobDetail> getAllJobDetail();

    public JobDetailExt getJobDetailExtByCategoryDetailId(Long categoryDetailId);
    
    public JobDetail getJobDetailById(Long id);
    
    public long addJobDetail(JobDetail jobDetailId);

    public boolean deleteJobDetailById(Long id);

    public boolean deleteAll();

    public boolean updateJobDetail(JobDetail jobDetailId);

}
