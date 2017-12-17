package com.small.business.jdbc.position;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.user.Position;
import com.small.business.model.user.User;

public class PositionRowMapper implements RowMapper {

    public Position mapRow(ResultSet resultSet, int line) throws SQLException {

    	PositionExtractor positionExtractor = new PositionExtractor();
        return positionExtractor.extractData(resultSet);
    }

}