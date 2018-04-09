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

import com.small.business.jdbc.user.UserDeviceRowMapper;
import com.small.business.model.user.UserDevice;

@Service("userDeviceDao")
public class UserDeviceDaoImpl implements UserDeviceDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDeviceDaoImpl.class);

    @Autowired
    DataSource dataSource;

    @SuppressWarnings("unchecked")
	public List<UserDevice> getAllUserDevice() {

        List<UserDevice> userFollowList = new ArrayList<UserDevice>();
        String sql = "select * from user_device";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFollowList = jdbcTemplate.query(sql, new UserDeviceRowMapper());
        return userFollowList;
    }
    
    @SuppressWarnings("unchecked")
	public UserDevice getUserDeviceById(Long id) {

    	UserDevice userFollow = new UserDevice();
        List<UserDevice> userFllowList = new ArrayList<UserDevice>();
        String sql = "select * from user_device where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userFllowList = jdbcTemplate.query(sql, new UserDeviceRowMapper());
        if (userFllowList.size() > 0) {
            return userFllowList.get(0);
        }
        return userFollow;
    }

    public boolean deleteUserDeviceById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from user_device where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteUserDeviceById got error: " + ex.getMessage());
        }
        return ret;
    }
    public long getMaxUserDeviceId(String sql) {
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
    public long addUserDevice(UserDevice userDevice) {

        boolean ret = true;
        long maxId = 0L;
        try {
            String sql = "INSERT INTO user_device (userId, uuid, token) VALUES (?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userDevice.getUserId(),
                    		userDevice.getUuid(),
                    		userDevice.getToken()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addUser got error: " + ex.getMessage());
        }
        if(ret) {
        	String sql = "SELECT MAX(id) as maxid FROM user_follow"; 
        	maxId = getMaxUserDeviceId(sql);
        	LOGGER.debug("maxId: " + maxId);
        }        
        return maxId;
    }
    public boolean updateUserDevice(UserDevice userDevice) {

        boolean ret = true;
        String sql = "update user_device set userId = ?, uuid = ?, token = ? "
                + "where userId = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("userId = " + userDevice.getUserId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		userDevice.getUserId(),
                    		userDevice.getUuid(),
                    		userDevice.getToken()
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("UserDevice got error: " + ex.getMessage());
        }
        return ret;
    }

}
