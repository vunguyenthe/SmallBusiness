package com.small.business.jdbc.bidjob;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.bidjob.BidJob;
import com.small.business.model.bidjob.BidJobFeedback;
import com.small.business.util.DateHelper;

public class BidJobFeedbackExtractor implements ResultSetExtractor {

    public BidJobFeedback extractData(ResultSet resultSet) throws SQLException, DataAccessException {

    	BidJobFeedback bidJobFeedback = new BidJobFeedback();
    	bidJobFeedback.setId(resultSet.getLong("id"));
    	bidJobFeedback.setBidJobId(resultSet.getLong("bidJobId"));
    	bidJobFeedback.setComment(resultSet.getString("comment"));
    	bidJobFeedback.setiLevel(resultSet.getLong("iLevel"));
    	bidJobFeedback.setUserId(resultSet.getLong("userId"));
        return bidJobFeedback;
    }
}
