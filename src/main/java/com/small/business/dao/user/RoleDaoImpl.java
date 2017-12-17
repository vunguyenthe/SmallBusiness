package com.small.business.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.user.RoleRowMapper;
import com.small.business.model.user.Role;

@Service("roleDao")
public class RoleDaoImpl implements RoleDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<Role> getAllRole() {

        List userList = new ArrayList();
        String sql = "select * from role";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new RoleRowMapper());
        return userList;
    }

    public Role getRoleById(Long id) {

        Role user = new Role();
        List<Role> userList = new ArrayList<Role>();
        String sql = "select * from role where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql, new RoleRowMapper());
        if (userList.size() > 0) {
            return userList.get(0);
        }
        return user;
    }

    public boolean addRole(Role role) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO role "
                    + "(name, roleId) "
                    + "VALUES (?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update(
                    sql,
                    new Object[] { role.getName(), role.getRoleId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addRole got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteRoleById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from role where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deleteRoleById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from role";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean updateRole(Role role) {

        boolean ret = true;
        try {
            String sql = "update role set name = ?, roleId = ? "
                    + " where id = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] { role.getName(), role.getRoleId() });
        } catch (Exception ex) {
            LOGGER.error("updateRole got error: " + ex.getMessage());
        }
        return ret;

    }

}
