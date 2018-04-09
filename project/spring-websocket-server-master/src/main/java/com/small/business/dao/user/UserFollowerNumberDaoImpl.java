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

import com.small.business.jdbc.user.UserFollowerNumberRowMapper;
import com.small.business.model.user.UserFollowerNumber;


@Service("userFollowerNumberDao")
public class UserFollowerNumberDaoImpl implements UserFollowerNumberDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowerNumberDaoImpl.class);

    @Autowired
    DataSource dataSource;

    @SuppressWarnings("unchecked")
	public List<UserFollowerNumber> getAllUserFollowerNumber() {

        List<UserFollowerNumber> userFollowerNumberList = new ArrayList<UserFollowerNumber>();
        String sql = "select * from user_follower_number";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFollowerNumberList = jdbcTemplate.query(sql, new UserFollowerNumberRowMapper());
        return userFollowerNumberList;
    }
    
    @SuppressWarnings("unchecked")
	public UserFollowerNumber getUserFollowerNumberById(Long id) {

    	UserFollowerNumber userFollowNumber = new UserFollowerNumber();
        List<UserFollowerNumber> userFllowList = new ArrayList<UserFollowerNumber>();
        String sql = "select * from user_follower_number where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFllowList = jdbcTemplate.query(sql, new UserFollowerNumberRowMapper());
        if (userFllowList.size() > 0) {
            return userFllowList.get(0);
        }
        return userFollowNumber;
    }

    public boolean deleteUserFollowerNumberById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from user_follower_number where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteUserFollowerNumberById got error: " + ex.getMessage());
        }
        return ret;
    }
    public long getMaxUserFollowerNumberId(String sql) {
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
    public long addUserFollowerNumber(UserFollowerNumber userFollowNumber) {

        boolean ret = true;
        long maxId = 0L;
        try {
            String sql = "INSERT INTO user_follower_number (userId, followerNumber) VALUES (?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollowNumber.getUserId(),
                    		userFollowNumber.getFollowerNumber()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addUser got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM user_follower_number"; 
        	maxId = getMaxUserFollowerNumberId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;
    }
    public boolean updateUserFollowerNumber(UserFollowerNumber userFollowerNumber) {

        boolean ret = true;
        String sql = "update user_follower_number set userId = ?, followerNumber = ? "
                + "where userId = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("userId = " + userFollowerNumber.getUserId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollowerNumber.getUserId(),
                    		userFollowerNumber.getFollowerNumber()
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateUser got error: " + ex.getMessage());
        }
        return ret;
    }

}
