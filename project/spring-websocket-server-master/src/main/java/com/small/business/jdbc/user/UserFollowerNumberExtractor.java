package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.UserFollowerNumber;


public class UserFollowerNumberExtractor implements ResultSetExtractor {

    public UserFollowerNumber extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	UserFollowerNumber userFollowerNumber = new UserFollowerNumber();
    	userFollowerNumber.setId(resultSet.getLong("id"));
    	userFollowerNumber.setUserId(resultSet.getLong("userId"));
    	userFollowerNumber.setFollowerNumber(resultSet.getLong("followerNumber"));
    	return userFollowerNumber;
    }
}
