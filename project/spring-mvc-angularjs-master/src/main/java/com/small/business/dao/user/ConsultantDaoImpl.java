package com.small.business.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.user.ConsultantRowMapper;
import com.small.business.model.user.Consultant;

@Service("consultantDao")
public class ConsultantDaoImpl implements ConsultantDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<Consultant> getAllConsultant() {

        List userList = new ArrayList();
        String sql = "select * from consultant";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new ConsultantRowMapper());
        return userList;
    }

    public Consultant getConsultantById(Long id) {

        Consultant user = new Consultant();
        List<Consultant> userList = new ArrayList<Consultant>();
        String sql = "select * from consultant where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new ConsultantRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return user;
    }

    public boolean addConsultant(Consultant role) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO consultant "
                    + "(name, consultantId) "
                    + "VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] { role.getName(), role.getConsultantId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addConsultant got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteConsultantById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from consultant where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteConsultantById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from consultant";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateConsultant(Consultant role) {

        boolean ret = true;
        try {
            String sql = "update consultant set name = ?, consultantId = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] { role.getName(), role.getConsultantId() });
        } catch (Exception ex) {
            LOGGER.error("updateConsultant got error: " + ex.getMessage());
        }
        return ret;

    }

}
