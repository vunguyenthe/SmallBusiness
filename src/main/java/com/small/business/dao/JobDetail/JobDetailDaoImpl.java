package com.small.business.dao.JobDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.category.JobDetailCategoryIdRowMapper;
import com.small.business.jdbc.category.JobDetailExtRowMapper;
import com.small.business.jdbc.category.JobDetailRowMapper;
import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.category.JobDetailExt;
@Service("JobDetailDao")
public class JobDetailDaoImpl implements JobDetailDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobDetailDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<JobDetailExt> getAllJobDetail() {

        List<JobDetailExt> jobDetailExtList = new ArrayList<JobDetailExt>();
        String sql = "select j.*, cd.categoryName as categoryDetailName, c.name as categoryName, cd.categoryId "
        		+ " from job_detail j, category_detail cd, category c "
        		+ " where cd.id= j.categoryDetailId"
        		+ " and c.id = cd.categoryId";
        System.out.println("sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jobDetailExtList = jdbcTemplate.query(sql, new JobDetailExtRowMapper());  
        return jobDetailExtList;
    }
    public JobDetailExt getJobDetailByIdExt(Long categoryDetailId) {
    	JobDetailExt jobDetailExt = new JobDetailExt();
        List<JobDetailExt> jobDetailExtList = new ArrayList<JobDetailExt>();
        String sql = "select j.*, cd.categoryName as categoryDetailName, c.name as categoryName, cd.categoryId "
        		+ " from job_detail j, category_detail cd, category c "
        		+ " where cd.id= j.categoryDetailId"
        		+ " and c.id = cd.categoryId and j.categoryDetailId = " + categoryDetailId;
        System.out.println("sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jobDetailExtList = jdbcTemplate.query(sql, new JobDetailExtRowMapper());
        if (jobDetailExtList.size() > 0) {
            return jobDetailExtList.get(0);
        }  
        return jobDetailExt;
    }    
    public JobDetailExt getJobDetailById(Long id) {
    	JobDetailExt jobDetailExt = new JobDetailExt();
        List<JobDetailExt> jobDetailExtList = new ArrayList<JobDetailExt>();
        String sql = "select j.*, cd.categoryName as categoryDetailName, c.name as categoryName, cd.categoryId "
        		+ " from job_detail j, category_detail cd, category c "
        		+ " where cd.id= j.categoryDetailId"
        		+ " and c.id = cd.categoryId and j.id = " + id;
        System.out.println("sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jobDetailExtList = jdbcTemplate.query(sql, new JobDetailExtRowMapper());
        if (jobDetailExtList.size() > 0) {
            return jobDetailExtList.get(0);
        }  
        return jobDetailExt;
    }
    public long addJobDetail(JobDetail jobDetail) {

    	long maxId = 0L;
        boolean ret = true;
        try {
            String sql = "INSERT INTO job_detail "
                    + "( employerId, categoryDetailId, description, priceOrder, location, distance, datePost ) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		jobDetail.getEmployerId(),
                    		jobDetail.getCategoryDetailId(),
                    		jobDetail.getDescription(),
                    		jobDetail.getPriceOrder(),
                    		jobDetail.getLocation(),
                    		jobDetail.getDistance(),
                    		jobDetail.getDatePost()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addJobDetail got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM job_detail"; 
        	maxId = getMaxId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;
    }
    private long getCategoryId(Long categoryDetailId) {
    	String sql = "select categoryId from category_detail where id = " + categoryDetailId;
    	System.out.println("sql: " + sql);
    	long categoryId = 0L;
    	try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while( rs.next() )
			{
				categoryId = rs.getLong("categoryId");
			}
		} catch (SQLException ex) {
			LOGGER.error("getCategoryId got error: " + ex.getMessage());
		}
    	System.out.println("categoryId: " + categoryId);
    	return categoryId;
    }    
    public long getMaxId(String sql) {
    	long maxId = 0L;
    	try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while( rs.next() )
			{
			    maxId = rs.getLong("maxid");
			}
		} catch (SQLException ex) {
			LOGGER.error("getMaxId got error: " + ex.getMessage());
		}
    	System.out.println("maxPostId: " + maxId);
    	return maxId;
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
        String sql = "update job_detail set employerId = ?, categoryDetailId = ?, description = ?, priceOrder = ?, "
        		+ "location = ?, distance = ?, datePost = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		jobDetail.getEmployerId(),
                    		jobDetail.getCategoryDetailId(),
                    		jobDetail.getDescription(),
                    		jobDetail.getPriceOrder(),
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
