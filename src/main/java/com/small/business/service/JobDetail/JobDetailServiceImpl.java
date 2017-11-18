package com.small.business.service.JobDetail;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.JobDetail.JobDetailDao;
import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.category.JobDetailExt;
import com.small.business.service.JobDetail.JobDetailService;

@Service("JobDetailService")
public class JobDetailServiceImpl implements JobDetailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobDetailServiceImpl.class);

    private static List<JobDetail> jobDetailList = new ArrayList<JobDetail>();

    @Autowired
    JobDetailDao jobDetailDao;

    public List<JobDetail> getAllJobDetail() {
        List<JobDetail> JobDetailList = jobDetailDao.getAllJobDetail();
        return JobDetailList;
    }

    public JobDetail getJobDetailById(Long id) {
        return jobDetailDao.getJobDetailById(id);
    }
    
    public JobDetailCategoryId getJobDetailByIdExt(Long id) {
    	  return jobDetailDao.getJobDetailByIdExt(id);
    }
    
    public JobDetailExt getJobDetailExtByCategoryDetailId(Long categoryDetailId) {
    	return jobDetailDao.getJobDetailExtByCategoryDetailId(categoryDetailId);
    }
    public long addJobDetail(JobDetail JobDetail) {

        return jobDetailDao.addJobDetail(JobDetail);
    }

    public boolean deleteAll() {
    	jobDetailList.clear();
        return jobDetailDao.deleteAll();
    }

    public boolean updateJobDetail(JobDetail JobDetail) {
        return jobDetailDao.updateJobDetail(JobDetail);
    }
	@Override
	public boolean deleteJobDetailById(Long id) {
        boolean ret = jobDetailDao.deleteJobDetailById(id);
        return ret;
	}

}
