package com.small.business.dao.JobDetail;

import java.util.List;

import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.category.JobDetailExt;


public interface JobDetailDao {

    public List<JobDetailExt> getAllJobDetail();

    public JobDetailExt getJobDetailById(Long id);
    
    public JobDetailExt getJobDetailByIdExt(Long id);
    
    public long addJobDetail(JobDetail jobDetailId);

    public boolean deleteJobDetailById(Long id);
    
    public boolean setIsExpired(Long id, Integer isExpired);

    public boolean deleteAll();

    public boolean updateJobDetail(JobDetail jobDetailId);
    
    public List<JobDetailExt> getAllJobDetailActivated();

}
