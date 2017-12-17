package com.small.business.dao.bidjob;
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

import com.small.business.jdbc.bidjob.BidJobRowMapper;
import com.small.business.jdbc.bidjob.BidJobRowMapper2;
import com.small.business.model.bidjob.BidJob;
import com.small.business.model.category.Category;
import com.small.business.util.DateHelper;

@Service("BidJobDao")
public class BidJobDaoImpl implements BidJobDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidJobDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<BidJob> getAllBidJobActivated() {
        List<BidJob> bidJobList = new ArrayList<BidJob>();
        String sql = "select b.*, c.categoryName from bid_job b, job_detail j, category_detail c where b.jobDetailId = j.id and j.categoryDetailId = c.id and (j.isExpired = 0 and b.isExpired = 0)";
        LOGGER.warn("getAllBidJobActivated sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobList = jdbcTemplate.query(sql, new BidJobRowMapper());
        return bidJobList;     	
    }
    public List<BidJob> getBidJobDetailId(Long jobDetailId) {
        List<BidJob> bidJobList = new ArrayList<BidJob>();
        String sql = "select b.*, c.categoryName, u.name, ur.level"
        		+ " from bid_job b, job_detail j, category_detail c, "
        		+ " user_rate_info ur, user u "
        		+ " where b.jobDetailId = j.id and j.categoryDetailId = c.id "
        		+ " and (j.isExpired = 0 and b.isExpired = 0)"
        		+ " and b.userId = ur.userId and ur.userId = u.id"
				+ " and b.jobDetailId = " + jobDetailId;        
        LOGGER.warn("getBidJobDetailId sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobList = jdbcTemplate.query(sql, new BidJobRowMapper2());
        return bidJobList; 
    }
    public List<BidJob> getAllBidJob() {

        List<BidJob> bidJobList = new ArrayList<BidJob>();
        String sql = "select b.*, c.categoryName from bid_job b, job_detail j, category_detail c where b.jobDetailId = j.id and j.categoryDetailId = c.id";
        LOGGER.warn("getAllBidJob sql: " + sql);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobList = jdbcTemplate.query(sql, new BidJobRowMapper());
        return bidJobList;        
    }
    public List<BidJob> getAllBidJobByUserId(Long userId) {
        List<BidJob> bidJobList = new ArrayList<BidJob>();
        String sql = "select b.*, c.categoryName from bid_job b, job_detail j, category_detail c where b.jobDetailId = j.id and j.categoryDetailId = c.id and userId = " + userId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobList = jdbcTemplate.query(sql, new BidJobRowMapper());
        return bidJobList;      	
    }
    
    public BidJob getBidJobById(Long id) {
        BidJob BidJob = new BidJob();
        List<BidJob> bidJobList = new ArrayList<BidJob>();
        String sql = "select b.*, c.categoryName from bid_job b, job_detail j, category_detail c where b.jobDetailId = j.id and j.categoryDetailId = c.id and b.id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobList = jdbcTemplate.query(sql, new BidJobRowMapper());
        if (bidJobList.size() > 0) {
            return bidJobList.get(0);
        }  
        return BidJob;
    }
    public boolean setIsExpired(Long id, Integer isExpired) {
        boolean ret = false;
        String sql = "update bid_job set isExpired = " + isExpired + " where id = " +  id;
        LOGGER.warn("setIsExpired sql: " + sql);
        try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			if(pst.executeUpdate() > 0 )
			{
				ret = true;
			}
		} catch (SQLException ex) {
			LOGGER.error("setIsExpired got error: " + ex.getMessage());
			ret = false;
		}
        return ret;
    }    
    public boolean updateBidJob(BidJob bidJob) {

        boolean ret = true;
        String sql = "update bid_job set userId = ?, jobDetailId = ?, bidAsk = ?, location = ?, "
        		+ " isExpired = ?, isSucceded = ?  where id = ? ";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		bidJob.getUserId(),
                    		bidJob.getJobDetailId(),
                    		bidJob.getBidAsk(),
                    		bidJob.getLocation(),
                    		bidJob.getIsExpired(),
                    		bidJob.getIsSucceded(),
                    		bidJob.getId()
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("BidJob got error: " + ex.getMessage());
        }
        return ret;
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
    public Long addBidJob(BidJob bidJob) {

        boolean ret = true;
    	long maxId = 0L;
        try {
            String sql = "INSERT INTO bid_job "
                    + "( userId, jobDetailId, bidAsk, location, isExpired, isSucceded ) VALUES "
                    + "(?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		bidJob.getUserId(),
                    		bidJob.getJobDetailId(),
                    		bidJob.getBidAsk(),
                    		bidJob.getLocation(),
                    		bidJob.getIsExpired(),
                    		bidJob.getIsSucceded()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addBidJob got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM bid_job"; 
        	maxId = getMaxId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;        
    }
    public boolean deleteBidJobById(Long id) {

        boolean ret = true;
        String sql = "";
        try {
            sql = "delete from bid_job where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deleteBidJobById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from bid_job";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }
}
