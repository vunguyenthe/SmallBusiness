package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.UserFollowingNumber;


public class UserFollowingNumberExtractor implements ResultSetExtractor {

    public UserFollowingNumber extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	UserFollowingNumber userFollowingNumber = new UserFollowingNumber();
    	userFollowingNumber.setId(resultSet.getLong("id"));
    	userFollowingNumber.setUserId(resultSet.getLong("userId"));
    	userFollowingNumber.setFollowingNumber(resultSet.getLong("followingNumber"));
    	return userFollowingNumber;
    }
}
