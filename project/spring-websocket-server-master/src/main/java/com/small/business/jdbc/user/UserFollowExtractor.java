package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.UserFollow;

public class UserFollowExtractor implements ResultSetExtractor<Object> {

    public UserFollow extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	UserFollow userFollow = new UserFollow();
    	userFollow.setId(resultSet.getLong("id"));
    	userFollow.setUserId(resultSet.getLong("userId"));
    	userFollow.setFollowerId(resultSet.getLong("followerId"));
    	userFollow.setFollowingId(resultSet.getLong("followingId"));
    	return userFollow;
    }
}
