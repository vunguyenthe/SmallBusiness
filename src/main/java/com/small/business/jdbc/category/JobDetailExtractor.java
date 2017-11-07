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
    	JobDetail JobDetail = new JobDetail();
    	JobDetail.setCategoryDetailId(resultSet.getLong("categoryDetailId"));
    	JobDetail.setDescription(resultSet.getString("description"));
    	JobDetail.setPriceOder(resultSet.getDouble("priceOder"));
    	JobDetail.setLocation(resultSet.getString("location"));
    	JobDetail.setDistance(resultSet.getLong("distance"));
    	JobDetail.setDatePost(resultSet.getString("datePost"));
        return JobDetail;
    }
}
