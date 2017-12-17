package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.category.Category;
import com.small.business.model.user.Position;

public class CategoryExtractor implements ResultSetExtractor {

    public Category extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	Category category = new Category();
    	category.setId(resultSet.getLong("id"));
    	category.setName(resultSet.getString("name"));
        return category;
    }
}
