package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.UserDevice;
import com.small.business.model.user.UserFollow;

public class UserDeviceExtractor implements ResultSetExtractor {

    public UserDevice extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	UserDevice userDevice = new UserDevice();
    	userDevice.setId(resultSet.getLong("id"));
    	userDevice.setUserId(resultSet.getLong("userId"));
    	userDevice.setUuid(resultSet.getString("uuid"));
    	userDevice.setToken(resultSet.getString("token"));
    	userDevice.setRegisteredDay(resultSet.getString("registeredDay"));
    	return userDevice;
    }
}
