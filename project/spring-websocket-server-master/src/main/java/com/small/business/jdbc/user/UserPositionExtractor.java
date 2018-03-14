package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.UserPosition;

public class UserPositionExtractor implements ResultSetExtractor {

    public UserPosition extractData(ResultSet resultSet) throws SQLException, DataAccessException {
    	UserPosition userPosition = new UserPosition();
    	userPosition.setUserId(resultSet.getLong("id"));
        userPosition.setName(resultSet.getString("name"));
        userPosition.setPhoneNumber(resultSet.getString("phoneNumber"));
        userPosition.setDayOfBirth(resultSet.getString("dayOfBirth"));
        //
        userPosition.setCMND(resultSet.getString("CMND"));
        userPosition.setPassKey(resultSet.getString("passKey"));
        userPosition.setIssuedDay(resultSet.getString("issuedDay"));
        userPosition.setIssuedPlace(resultSet.getString("issuedPlace"));
        //
        userPosition.setFrontPhoto(resultSet.getString("frontPhoto"));
        userPosition.setBackPhoto(resultSet.getString("backPhoto"));
        userPosition.setEmail(resultSet.getString("email"));
        userPosition.setDegree(resultSet.getString("degree"));
        //
        userPosition.setCertificateOfInformatics(resultSet.getString("certificateOfInformatics"));
        userPosition.setUserType(resultSet.getInt("userType"));
        userPosition.setIsActivated(resultSet.getInt("isActivated"));

        userPosition.setRegisteredDay(resultSet.getString("registeredDay"));
        userPosition.setiRegisteredDay(resultSet.getLong("iRegisteredDay"));
        
        userPosition.setLongitude(resultSet.getLong("longitude"));
        userPosition.setLatitude(resultSet.getLong("latitude"));
        
        return userPosition;
    }
}
