package com.small.business.dao.people;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.small.business.model.people.People;

@Service("peopleDao")
public class PeopleDaoImpl implements PeopleDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<People> getAllPeople() {

        List<People> peopleList = new ArrayList<People>();

        return peopleList;
    }

    public List<People> getAllPeopleClient() {

        List<People> peopleList = new ArrayList<People>();
        return peopleList;
    }

    public List<People> getAllCandidate() {

        List<People> peopleList = new ArrayList<People>();

        return peopleList;
    }

    public People getPeopleById(Long id) {

        People people = new People();
        return people;
    }

    public boolean addPeople(People people) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO people "
                    + "(fullName, email, phoneNumber, mobilePhone, additionalPhone,"
                    + "companyId, jobTitle, businessPhone,"
                    + "businessFax, linkedIn, address, internalComments, cv,"
                    + "webLink, skypeID, client, candidate,"
                    + "partner, contact, doNotMass, vip, supplier, photo, createBy, companyName, cvShow) VALUES "
                    + "(?, ?, ?, ?, ?,"
                    + " ?, ?, ?,"
                    + "?, ?, ?, ?,"
                    + "?, ?, ?, ?,"
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            people.getFullName(),
                            people.getEmail(),
                            people.getPhoneNumber(),
                            people.getMobilePhone(),
                            people.getAdditionalPhone(),
                            people.getCompanyId(),
                            people.getJobTitle(),
                            people.getBusinessPhone(),
                            people.getBusinessFax(),
                            people.getLinkedIn(),
                            people.getAddress(),
                            people.getInternalComments(),
                            people.getCv(),
                            people.getWebLink(),
                            people.getSkypeID(),
                            people.isClient(),
                            people.isCandidate(),
                            people.isPartner(),
                            people.isContact(),
                            people.isDoNotMass(),
                            people.isVip(),
                            people.isSupplier(),
                            people.getPhoto(),
                            people.getCreateBy(),
                            people.getCompanyName(),
                            people.getCvShow()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addPeople got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deletePeopleById(Long id, boolean permanent) {

        boolean ret = true;
        String sql = "";
        try {
            if (permanent) {
                sql = "delete from people where id =" + id;
            } else {
                sql = "update people set flag_del = 'Y' where id =" + id;
            }
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deletePeopleById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from people";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    @Override
    public Long getNextPeopleId() {

        String sql = "SELECT AUTO_INCREMENT as maxPeopleId FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'hr4' AND TABLE_NAME   = 'people'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Long maxPeopleId = (long) jdbcTemplate.queryForObject(sql, Integer.class);
        if (maxPeopleId == 0L)
            maxPeopleId = 1L;
        return maxPeopleId;
    }

    public boolean updatePeople(People people) {

        boolean ret = true;
        String sql = "update people set fullName = ?, email = ?, phoneNumber = ?, "
                + "mobilePhone = ?, additionalPhone = ?, companyId = ?, jobTitle = ?, businessPhone = ?, "
                + "businessFax = ?, linkedIn = ?, address = ?, internalComments = ?, cv = ?, "
                + "webLink = ?, skypeID = ?, client = ?, candidate = ?, "
                + "partner = ?, contact = ?, doNotMass = ?, "
                + "vip = ?, supplier = ?, photo = ?, createBy = ?, companyName = ?, cvShow = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("PeopleId = " + people.getId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                            people.getFullName(),
                            people.getEmail(),
                            people.getPhoneNumber(),
                            people.getMobilePhone(),
                            people.getAdditionalPhone(),
                            people.getCompanyId(),
                            people.getJobTitle(),
                            people.getBusinessPhone(),
                            people.getBusinessFax(),
                            people.getLinkedIn(),
                            people.getAddress(),
                            people.getInternalComments(),
                            people.getCv(),
                            people.getWebLink(),
                            people.getSkypeID(),
                            people.isClient(),
                            people.isCandidate(),
                            people.isPartner(),
                            people.isContact(),
                            people.isDoNotMass(),
                            people.isVip(),
                            people.isSupplier(),
                            people.getPhoto(),
                            people.getCreateBy(),
                            people.getCompanyName(),
                            people.getCvShow(),
                            people.getId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updatePeople got error: " + ex.getMessage());
        }
        return ret;
    }

    @Override
    public List<People> getPeopleByName(String fullName) {
    	List<People> peopleList = new ArrayList<People>();
    	 return peopleList;
    }

    @Override
    public List<People> getPeopleByCompanyId(Long companyId) {

        People people = new People();
        List<People> peopleList = new ArrayList<People>();
        return peopleList;
    }

    @Override
    public boolean checkDuplicate(String field, String value) {

        boolean duplicate = false;
        String sql = "SELECT count(*) FROM people where " + field + " = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Integer> result = jdbcTemplate.query(sql, new Object[] { value }, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int arg) throws SQLException {

                return rs.getInt(1);
            }

        });

        if (result.size() == 1 && result.get(0) > 0) {
            duplicate = true;
        }
        return duplicate;
    }

    @Override
    public boolean updatePeopleHighlightColor(Long id, String highlightColor) {

        boolean ret = true;
        try {
            String sql = "UPDATE people SET highlightColor = ? WHERE id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql, new Object[] { highlightColor, id });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updatePeopleHighlightColor got error: ", ex);
        }
        return ret;
    }
    
}
