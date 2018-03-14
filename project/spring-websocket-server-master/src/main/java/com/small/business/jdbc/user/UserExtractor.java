package com.small.business.jdbc.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.user.User;

public class UserExtractor implements ResultSetExtractor {

    public User extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPhoneNumber(resultSet.getString("phoneNumber"));
        user.setDayOfBirth(resultSet.getString("dayOfBirth"));
        //
        user.setCMND(resultSet.getString("CMND"));
        user.setPassKey(resultSet.getString("passKey"));
        user.setIssuedDay(resultSet.getString("issuedDay"));
        user.setIssuedPlace(resultSet.getString("issuedPlace"));
        //
        user.setFrontPhoto(resultSet.getString("frontPhoto"));
        user.setBackPhoto(resultSet.getString("backPhoto"));
        user.setEmail(resultSet.getString("email"));
        user.setDegree(resultSet.getString("degree"));
        //
        user.setCertificateOfInformatics(resultSet.getString("certificateOfInformatics"));
        user.setUserType(resultSet.getInt("userType"));
        user.setIsActiavated(resultSet.getInt("isActivated"));
        //
        user.setRegisteredDay(resultSet.getString("registeredDay"));
        user.setiRegisteredDay(resultSet.getLong("iRegisteredDay"));
        user.setSex(resultSet.getString("sex"));
        return user;
    }
}
