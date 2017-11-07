package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.JobDetailExt;

public class JobDetailExtExtractor implements ResultSetExtractor {

    public JobDetailExt extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	JobDetailExt JobDetailEx = new JobDetailExt();
    	JobDetailEx.setCategoryDetailId(resultSet.getLong("categoryDetailId"));
    	JobDetailEx.setDescription(resultSet.getString("description"));
    	JobDetailEx.setPriceOder(resultSet.getDouble("priceOder"));
    	JobDetailEx.setLocation(resultSet.getString("location"));
    	JobDetailEx.setDistance(resultSet.getLong("distance"));
    	JobDetailEx.setDatePost(resultSet.getString("datePost"));
    	JobDetailEx.setCategoryDetailName(resultSet.getString("categoryDetailName"));
        return JobDetailEx;
    }
}
