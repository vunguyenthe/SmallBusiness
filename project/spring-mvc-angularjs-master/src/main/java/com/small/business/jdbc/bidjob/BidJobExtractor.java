package com.small.business.jdbc.bidjob;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.bidjob.BidJob;
import com.small.business.util.DateHelper;

public class BidJobExtractor implements ResultSetExtractor {

    public BidJob extractData(ResultSet resultSet) throws SQLException, DataAccessException {

    	BidJob bidJob = new BidJob();
    	bidJob.setId(resultSet.getLong("id"));
    	bidJob.setUserId(resultSet.getLong("userId"));
    	bidJob.setJobDetailId(resultSet.getLong("jobDetailId"));
    	bidJob.setBidAsk(resultSet.getDouble("bidAsk"));
    	bidJob.setLocation(resultSet.getString("location"));
    	bidJob.setIsExpired(resultSet.getInt("isExpired"));
    	bidJob.setIsSucceded(resultSet.getInt("isSucceded"));
    	bidJob.setBidTime(resultSet.getString("bidTime"));
    	bidJob.setiBidTime(resultSet.getLong("iBidTime"));
    	bidJob.setJobName(resultSet.getString("categoryName"));
        return bidJob;
    }
}
