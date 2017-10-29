package com.small.business.jdbc.people;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.small.business.model.people.People;

public class PeopleExtractor implements ResultSetExtractor {

    public People extractData(ResultSet resultSet) throws SQLException, DataAccessException {

        People people = new People();

        int id = 1;
        people.setId(resultSet.getLong("id"));
        people.setFullName(resultSet.getString("fullName"));
        people.setEmail(resultSet.getString("email"));
        people.setPhoneNumber(resultSet.getString("phoneNumber"));
        people.setMobilePhone(resultSet.getString("mobilePhone"));
        people.setCompanyId(resultSet.getLong("companyId"));
        people.setJobTitle(resultSet.getString("jobTitle"));
        people.setBusinessPhone(resultSet.getString("businessPhone"));
        people.setBusinessFax(resultSet.getString("businessFax"));
        people.setLinkedIn(resultSet.getString("linkedIn"));
        people.setAddress(resultSet.getString("address"));
        people.setInternalComments(resultSet.getString("internalComments"));
        people.setCv(resultSet.getString("cv"));
        people.setWebLink(resultSet.getString("webLink"));
        people.setSkypeID(resultSet.getString("skypeID"));
        people.setClient(resultSet.getBoolean("client"));
        people.setCandidate(resultSet.getBoolean("candidate"));
        people.setPartner(resultSet.getBoolean("partner"));
        people.setContact(resultSet.getBoolean("contact"));
        people.setDoNotMass(resultSet.getBoolean("doNotMass"));
        people.setVip(resultSet.getBoolean("vip"));
        people.setSupplier(resultSet.getBoolean("supplier"));
        people.setPhoto(resultSet.getString("photo"));
        people.setCreateBy(resultSet.getString("createBy"));
        people.setCompanyName(resultSet.getString("companyName"));
        people.setCvShow(resultSet.getString("cvShow"));
        people.setAdditionalPhone(resultSet.getString("additionalPhone"));
        people.setHighlightColor(resultSet.getString("highlightColor"));
        return people;
    }
}
