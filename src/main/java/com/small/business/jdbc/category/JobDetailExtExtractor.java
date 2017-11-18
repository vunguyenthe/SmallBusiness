package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.JobDetailExt;

public class JobDetailExtExtractor implements ResultSetExtractor {

    public JobDetailExt extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	JobDetailExt JobDetailEx = new JobDetailExt();
    	JobDetailEx.setId(resultSet.getLong("id"));
    	JobDetailEx.setId(resultSet.getLong("employerId"));
    	JobDetailEx.setCategoryDetailId(resultSet.getLong("categoryDetailId"));
    	JobDetailEx.setDescription(resultSet.getString("description"));
    	JobDetailEx.setPriceOrder(resultSet.getDouble("priceOrder"));
    	JobDetailEx.setLocation(resultSet.getString("location"));
    	JobDetailEx.setDistance(resultSet.getLong("distance"));
    	JobDetailEx.setDatePost(resultSet.getString("datePost"));
    	JobDetailEx.setCategoryDetailName(resultSet.getString("categoryDetailName"));
    	java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf(resultSet.getString("datePost"));
        long tsTime2 = ts2.getTime();    	
    	JobDetailEx.setiDatePost(tsTime2);
    	JobDetailEx.setCategoryName(resultSet.getString("categoryName"));    	
        return JobDetailEx;
    }
}
