package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.Category;
import com.small.business.model.category.JobDetail;
import com.small.business.model.user.Position;

public class JobDetailExtractor implements ResultSetExtractor {

    public JobDetail extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	JobDetail jobDetail = new JobDetail();
    	jobDetail.setId(resultSet.getLong("id"));
    	jobDetail.setEmployerId(resultSet.getLong("employerId"));
    	jobDetail.setCategoryDetailId(resultSet.getLong("categoryDetailId"));
    	jobDetail.setDescription(resultSet.getString("description"));
    	jobDetail.setPriceOrder(resultSet.getDouble("priceOrder"));
    	jobDetail.setLocation(resultSet.getString("location"));
    	jobDetail.setDistance(resultSet.getLong("distance"));
    	jobDetail.setDatePost(resultSet.getString("datePost"));
    	java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(resultSet.getString("datePost"));
        long tsTime2 = ts2.getTime();    	
        jobDetail.setiDatePost(tsTime2);    	
        return jobDetail;
    }
}
