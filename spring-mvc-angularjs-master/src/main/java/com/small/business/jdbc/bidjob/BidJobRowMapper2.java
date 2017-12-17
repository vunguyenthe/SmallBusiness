package com.small.business.jdbc.bidjob;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.bidjob.BidJob;

public class BidJobRowMapper2 implements RowMapper {

    public BidJob mapRow(ResultSet resultSet, int line) throws SQLException {

    	BidJobExtractor2 bidJobExtractor = new BidJobExtractor2();
        return bidJobExtractor.extractData(resultSet);
    }

}