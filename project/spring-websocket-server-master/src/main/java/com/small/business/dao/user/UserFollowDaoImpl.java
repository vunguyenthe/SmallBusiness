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

import com.small.business.jdbc.user.UserFollowRowMapper;
import com.small.business.model.user.UserFollow;

@Service("userFollowDao")
public class UserFollowDaoImpl implements UserFollowDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFollowDaoImpl.class);

    @Autowired
    DataSource dataSource;

    @SuppressWarnings("unchecked")
	public List<UserFollow> getAllUserFollow() {

        List<UserFollow> userFollowList = new ArrayList<UserFollow>();
        String sql = "select * from user_follow";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFollowList = jdbcTemplate.query(sql, new UserFollowRowMapper());
        return userFollowList;
    }
    
    @SuppressWarnings("unchecked")
	public UserFollow getUserFollowById(Long id) {

    	UserFollow userFollow = new UserFollow();
        List<UserFollow> userFllowList = new ArrayList<UserFollow>();
        String sql = "select * from user_follow where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFllowList = jdbcTemplate.query(sql, new UserFollowRowMapper());
        if (userFllowList.size() > 0) {
            return userFllowList.get(0);
        }
        return userFollow;
    }

    public boolean deleteUserFollowById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from user_follow where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteUserFollowById got error: " + ex.getMessage());
        }
        return ret;
    }
    public long getMaxUserFollowId(String sql) {
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
    public long addUserFollow(UserFollow userFollow) {

        boolean ret = true;
        long maxId = 0L;
        try {
            String sql = "INSERT INTO user_follow (userId, followerId, followingId) VALUES (?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollow.getUserId(),
                    		userFollow.getFollowerId(),
                    		userFollow.getFollowingId()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addUser got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM user_follow"; 
        	maxId = getMaxUserFollowId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;
    }
    public boolean updateUserFollow(UserFollow userFollow) {

        boolean ret = true;
        String sql = "update user_follow set userId = ?, followerId = ?, followingId = ? "
                + "where userId = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("userId = " + userFollow.getUserId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userFollow.getUserId(),
                    		userFollow.getFollowerId(),
                    		userFollow.getFollowingId()
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updateUser got error: " + ex.getMessage());
        }
        return ret;
    }

}
