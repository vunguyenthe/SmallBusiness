package com.small.business.jdbc.category;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.category.JobDetailExt;

public class JobDetailExtRowMapper implements RowMapper {

    public JobDetailExt mapRow(ResultSet resultSet, int line) throws SQLException {

        JobDetailExtExtractor JobDetailExtExtractor = new JobDetailExtExtractor();
        return JobDetailExtExtractor.extractData(resultSet);
    }

}