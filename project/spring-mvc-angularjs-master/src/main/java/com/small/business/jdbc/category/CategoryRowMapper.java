package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.category.Category;

public class CategoryRowMapper implements RowMapper {

    public Category mapRow(ResultSet resultSet, int line) throws SQLException {

        CategoryExtractor categoryExtractor = new CategoryExtractor();
        return categoryExtractor.extractData(resultSet);
    }

}