package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.small.business.model.user.UserFollowingNumber;

public class UserFollowingNumberRowMapper implements RowMapper {

    public UserFollowingNumber mapRow(ResultSet resultSet, int line) throws SQLException {

        UserFollowingNumberExtractor userFollowingNumberExtractor = new UserFollowingNumberExtractor();
        return userFollowingNumberExtractor.extractData(resultSet);
    }

}