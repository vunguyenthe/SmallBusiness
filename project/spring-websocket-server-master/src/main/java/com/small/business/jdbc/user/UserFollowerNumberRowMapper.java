package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.user.UserFollowerNumber;

public class UserFollowerNumberRowMapper implements RowMapper {

    public UserFollowerNumber mapRow(ResultSet resultSet, int line) throws SQLException {

        UserFollowerNumberExtractor userFollowingNumberExtractor = new UserFollowerNumberExtractor();
        return userFollowingNumberExtractor.extractData(resultSet);
    }

}