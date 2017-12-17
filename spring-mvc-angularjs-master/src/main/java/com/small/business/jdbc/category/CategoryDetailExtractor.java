package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.CategoryDetail;

public class CategoryDetailExtractor implements ResultSetExtractor {

    public CategoryDetail extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	CategoryDetail categoryDetail = new CategoryDetail();
    	categoryDetail.setId(resultSet.getLong("id"));
    	categoryDetail.setCategoryId(resultSet.getLong("categoryId"));
    	categoryDetail.setCategoryName(resultSet.getString("categoryName"));
        return categoryDetail;
    }
}
