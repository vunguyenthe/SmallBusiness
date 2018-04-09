package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.user.UserDevice;

public class UserDeviceRowMapper implements RowMapper {

    public UserDevice mapRow(ResultSet resultSet, int line) throws SQLException {

        UserDeviceExtractor userDeviceExtractor = new UserDeviceExtractor();
        return userDeviceExtractor.extractData(resultSet);
    }

}