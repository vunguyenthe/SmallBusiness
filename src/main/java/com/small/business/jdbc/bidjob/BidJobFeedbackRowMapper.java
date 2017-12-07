package com.small.business.jdbc.bidjob;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.bidjob.BidJobFeedback;

public class BidJobFeedbackRowMapper implements RowMapper {

    public BidJobFeedback mapRow(ResultSet resultSet, int line) throws SQLException {

    	BidJobFeedbackExtractor bidJobFeedbackExtractor = new BidJobFeedbackExtractor();
        return bidJobFeedbackExtractor.extractData(resultSet);
    }

}