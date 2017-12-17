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

import com.small.business.jdbc.bidjob.BidJobFeedbackRowMapper;
import com.small.business.model.bidjob.BidJobFeedback;

@Service("bidJobFeedbackDao")
public class BidJobFeedbackDaoImpl implements BidJobFeedbackDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(BidJobFeedbackDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<BidJobFeedback> getAllBidJobFeedback() {
    	String sql = "select * from bid_job_feedback";
    	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<BidJobFeedback> bidJobFeedbackList = new ArrayList<BidJobFeedback>();
        bidJobFeedbackList = jdbcTemplate.query(sql, new BidJobFeedbackRowMapper());
        return bidJobFeedbackList;
    }

    public BidJobFeedback getBidJobFeedbackById(Long id) {
    	BidJobFeedback bidJobFeedback = new BidJobFeedback();
        List<BidJobFeedback> bidJobFeedbackList = new ArrayList<BidJobFeedback>();
        String sql = "select * from bid_job_feedback where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobFeedbackList = jdbcTemplate.query(sql, new BidJobFeedbackRowMapper());
        if (bidJobFeedbackList.size() > 0) {
            return bidJobFeedbackList.get(0);
        }
        return bidJobFeedback;
        
    }
    public List<BidJobFeedback> getAllBidJobFeedbackByUserId(Long userId) {
    	List<BidJobFeedback> bidJobFeedbackList = new ArrayList<BidJobFeedback>();
        String sql = "select * from bid_job_feedback where userId= " + userId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        bidJobFeedbackList = jdbcTemplate.query(sql, new BidJobFeedbackRowMapper());
        return bidJobFeedbackList;
        
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
    public long addBidJobFeedback(BidJobFeedback bidJobFeedback) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO bid_job_feedback "
                    + "(bidJobId, comment, iLevel, userId) VALUES "
                    + "(?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		bidJobFeedback.getBidJobId(),
                    		bidJobFeedback.getComment(),
                    		bidJobFeedback.getiLevel(),
                    		bidJobFeedback.getUserId()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addBidJobFeedback got error: " + ex.getMessage());
        }
        long maxId = 0L;
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM bid_job_feedback"; 
        	maxId = getMaxId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }         
        return maxId;
    }

    public boolean deleteBidJobFeedbackById(Long id) {

        boolean ret = true;
        String sql = "";
        try {
             sql = "delete from bid_job_feedback where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deleteBidJobFeedbackById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from bid_job_feedback";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    @Override
    public Long getNextBidJobFeedbackId() {

        String sql = "SELECT AUTO_INCREMENT as maxBidJobFeedbackId FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'mia' AND TABLE_NAME   = 'bid_job_feedback'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxBidJobFeedbackId = (long) jdbcTemplate.queryForObject(sql, Integer.class);
        if (maxBidJobFeedbackId == 0L)
            maxBidJobFeedbackId = 1L;
        return maxBidJobFeedbackId;
    }

    public boolean updateBidJobFeedback(BidJobFeedback bidJobFeedback) {

        boolean ret = true;
        String sql = "update bid_job_feedback set bidJobId = ?, comment = ?, iLevel = ?, userId = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("BidJobFeedbackId = " + bidJobFeedback.getId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		bidJobFeedback.getBidJobId(),
                    		bidJobFeedback.getComment(),
                    		bidJobFeedback.getiLevel(),
                    		bidJobFeedback.getUserId(),
                    		bidJobFeedback.getId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateBidJobFeedback got error: " + ex.getMessage());
        }
        return ret;
    }

}
