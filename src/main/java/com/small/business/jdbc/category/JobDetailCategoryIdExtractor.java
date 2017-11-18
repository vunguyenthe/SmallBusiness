package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.Category;
import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.user.Position;

public class JobDetailCategoryIdExtractor implements ResultSetExtractor {

    public JobDetailCategoryId extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	JobDetailCategoryId jobDetailCategoryId = new JobDetailCategoryId();
    	jobDetailCategoryId.setId(resultSet.getLong("id"));
    	jobDetailCategoryId.setEmployerId(resultSet.getLong("employerId"));
    	jobDetailCategoryId.setCategoryDetailId(resultSet.getLong("categoryDetailId"));
    	jobDetailCategoryId.setCategoryId(resultSet.getLong("categoryId"));
    	jobDetailCategoryId.setDescription(resultSet.getString("description"));
    	jobDetailCategoryId.setPriceOrder(resultSet.getDouble("priceOrder"));
    	jobDetailCategoryId.setLocation(resultSet.getString("location"));
    	jobDetailCategoryId.setDistance(resultSet.getLong("distance"));
    	jobDetailCategoryId.setDatePost(resultSet.getString("datePost"));
    	java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(resultSet.getString("datePost"));
        long tsTime2 = ts2.getTime();    	
        jobDetailCategoryId.setiDatePost(tsTime2);
        return jobDetailCategoryId;
    }
}
