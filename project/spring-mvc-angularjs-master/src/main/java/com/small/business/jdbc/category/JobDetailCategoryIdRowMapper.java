package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.category.JobDetailCategoryId;

public class JobDetailCategoryIdRowMapper implements RowMapper {

    public JobDetailCategoryId mapRow(ResultSet resultSet, int line) throws SQLException {

        JobDetailCategoryIdExtractor jobDetailExtractor = new JobDetailCategoryIdExtractor();
        return jobDetailExtractor.extractData(resultSet);
    }

}