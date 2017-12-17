package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.category.JobDetail;

public class JobDetailRowMapper implements RowMapper {

    public JobDetail mapRow(ResultSet resultSet, int line) throws SQLException {

        JobDetailExtractor jobDetailExtractor = new JobDetailExtractor();
        return jobDetailExtractor.extractData(resultSet);
    }

}