package com.small.business.jdbc.option;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.option.JournalType;


public class JournalTypeRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        JournalType journalType = new JournalType();
        journalType.setId(resultSet.getLong("id"));
        journalType.setJournalType(resultSet.getString("journalType"));
        return journalType;
    }

}
