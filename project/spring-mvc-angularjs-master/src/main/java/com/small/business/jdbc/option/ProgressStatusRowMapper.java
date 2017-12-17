package com.small.business.jdbc.option;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.option.ProgressStatus;

public class ProgressStatusRowMapper implements RowMapper {

    @Override
    public ProgressStatus mapRow(ResultSet resultSet, int line)
            throws SQLException {
        ProgressStatus progressStatus = new ProgressStatus();
        progressStatus.setId(resultSet.getLong("id"));
        progressStatus.setProgressStatus(resultSet.getString("progressStatus"));
        return progressStatus;
    }
}
