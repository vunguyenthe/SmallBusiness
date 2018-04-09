package com.small.business.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.user.UserFollowingNumberRowMapper;
import com.small.business.model.user.UserFollowingNumber;


@Service("userFollowingNumberDao")
public class UserFollowingNumberDaoImpl implements UserFollowingNumberDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowingNumberDaoImpl.class);

    @Autowired
    DataSource dataSource;

    @SuppressWarnings("unchecked")
	public List<UserFollowingNumber> getAllUserFollowingNumber() {

        List<UserFollowingNumber> userFollowingNumberList = new ArrayList<UserFollowingNumber>();
        String sql = "select * from user_following_number";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFollowingNumberList = jdbcTemplate.query(sql, new UserFollowingNumberRowMapper());
        return userFollowingNumberList;
    }
    
    @SuppressWarnings("unchecked")
	public UserFollowingNumber getUserFollowingNumberById(Long id) {

    	UserFollowingNumber userFollowingNumber = new UserFollowingNumber();
        List<UserFollowingNumber> userFllowList = new ArrayList<UserFollowingNumber>();
        String sql = "select * from user_following_number where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFllowList = jdbcTemplate.query(sql, new UserFollowingNumberRowMapper());
        if (userFllowList.size() > 0) {
            return userFllowList.get(0);
        }
        return userFollowingNumber;
    }

    public boolean deleteUserFollowingNumberById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from user_following_number where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteUserFollowingNumberById got error: " + ex.getMessage());
        }
        return ret;
    }
    public long getMaxUserFollowingNumberId(String sql) {
    	long maxId = 0L;
    	try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while( rs.next() )
			{
			    maxId = rs.getLong("maxid");
			}
		} catch (SQLException ex) {
			LOGGER.error("getMaxId got error: " + ex.getMessage());
		}
    	System.out.println("maxUserId: " + maxId);
    	return maxId;
    }
    public long addUserFollowingNumber(UserFollowingNumber userFollowingNumber) {

        boolean ret = true;
        long maxId = 0L;
        try {
            String sql = "INSERT INTO user_following_number (userId, followerNumber) VALUES (?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollowingNumber.getUserId(),
                    		userFollowingNumber.getFollowingNumber()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addUser got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM user_follower_number"; 
        	maxId = getMaxUserFollowingNumberId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;
    }
    public boolean updateUserFollowingNumber(UserFollowingNumber userFollowingNumber) {

        boolean ret = true;
        String sql = "update user_following_number set userId = ?, followingNumber = ? "
                + "where userId = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("userId = " + userFollowingNumber.getUserId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollowingNumber.getUserId(),
                    		userFollowingNumber.getFollowingNumber()
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateUser got error: " + ex.getMessage());
        }
        return ret;
    }

}
