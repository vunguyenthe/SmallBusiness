package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.category.CategoryDetail;

public class CategoryDetailRowMapper implements RowMapper {

    public CategoryDetail mapRow(ResultSet resultSet, int line) throws SQLException {

    	CategoryDetailExtractor categoryExtractor = new CategoryDetailExtractor();
        return categoryExtractor.extractData(resultSet);
    }

}