package com.small.business.jdbc.position;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.Position;

public class PositionExtractor implements ResultSetExtractor {

    public Position extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	Position position = new Position();
        position.setId(resultSet.getLong("id"));
        position.setUserId(resultSet.getLong("userId"));
        position.setLongitude(resultSet.getLong("longitude"));
        position.setLatitude(resultSet.getLong("latitude"));
        position.setDateChecked(resultSet.getString("dateChecked"));
        return position;
    }
}
