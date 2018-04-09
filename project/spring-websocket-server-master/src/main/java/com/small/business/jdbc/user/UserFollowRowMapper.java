package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.user.UserFollow;

public class UserFollowRowMapper implements RowMapper {

    public UserFollow mapRow(ResultSet resultSet, int line) throws SQLException {

        UserFollowExtractor userFollowExtractor = new UserFollowExtractor();
        return userFollowExtractor.extractData(resultSet);
    }

}