package com.small.business.dao.JobDetail;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.category.JobDetailExtRowMapper;
import com.small.business.jdbc.category.JobDetailRowMapper;
import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailExt;
@Service("JobDetailDao")
public class JobDetailDaoImpl implements JobDetailDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobDetailDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<JobDetail> getAllJobDetail() {

        List<JobDetail> JobDetailList = new ArrayList<JobDetail>();
        String sql = "select * from job_detail";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        JobDetailList = jdbcTemplate.query(sql, new JobDetailRowMapper());
        return JobDetailList;        
    }
    public JobDetailExt getJobDetailExtByCategoryDetailId(Long categoryDetailId) {
    	JobDetailExt jobDetailExt = new JobDetailExt();
        List<JobDetailExt> jobDetailExtList = new ArrayList<JobDetailExt>();
        String sql = "select j.*, c.categoryName as categoryDetailName from job_detail j, category_detail c "
        		+ "where c.id= j.categoryDetailId"
        		+ " and j.categoryDetailId = " + categoryDetailId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jobDetailExtList = jdbcTemplate.query(sql, new JobDetailExtRowMapper());
        if (jobDetailExtList.size() > 0) {
            return jobDetailExtList.get(0);
        }  
        return jobDetailExt;
    }    
    public JobDetail getJobDetailById(Long id) {
        JobDetail JobDetail = new JobDetail();
        List<JobDetail> JobDetailList = new ArrayList<JobDetail>();
        String sql = "select * from job_detail where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        JobDetailList = jdbcTemplate.query(sql, new JobDetailRowMapper());
        if (JobDetailList.size() > 0) {
            return JobDetailList.get(0);
        }  
        return JobDetail;
    }
    public boolean addJobDetail(JobDetail jobDetail) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO job_detail "
                    + "( categoryDetailId, description, priceOder, location, distance, datePost ) VALUES "
                    + "(?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		jobDetail.getCategoryDetailId(),
                    		jobDetail.getDescription(),
                    		jobDetail.getPriceOder(),
                    		jobDetail.getLocation(),
                    		jobDetail.getDistance(),
                    		jobDetail.getDatePost()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addJobDetail got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteJobDetailById(Long id) {

        boolean ret = true;
        String sql = "";
        try {
            sql = "delete from job_detail where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deleteJobDetailById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from job_detail";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    public boolean updateJobDetail(JobDetail jobDetail) {

        boolean ret = true;
        String sql = "update job_detail set categoryDetailId = ?, description = ?, priceOder = ?, "
        		+ "location = ?, distance = ?, datePost = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		jobDetail.getCategoryDetailId(),
                    		jobDetail.getDescription(),
                    		jobDetail.getPriceOder(),
                    		jobDetail.getLocation(),
                    		jobDetail.getDistance(),
                    		jobDetail.getDatePost(),
                    		jobDetail.getId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateJobDetail got error: " + ex.getMessage());
        }
        return ret;
    }
}
