package com.small.business.dao.position;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.position.PositionRowMapper;
import com.small.business.jdbc.user.UserRowMapper;
import com.small.business.model.user.Position;
import com.small.business.model.user.User;

@Service("positionDao")
public class PositionDaoImpl implements PositionDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<Position> getAllPosition() {

        List<Position> positionList = new ArrayList<Position>();
        String sql = "select * from position";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        positionList = jdbcTemplate.query(sql, new PositionRowMapper());
        return positionList;        
    }

    public Position getPositionById(Long id) {
        Position position = new Position();
        List<Position> positionList = new ArrayList<Position>();
        String sql = "select * from position where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        positionList = jdbcTemplate.query(sql, new PositionRowMapper());
        if (positionList.size() > 0) {
            return positionList.get(0);
        }  
        return position;
    }
    public Position getPositionUserId(Long userId) {
        Position position = new Position();
        List<Position> positionList = new ArrayList<Position>();
        String sql = "select * from position where userId = " + userId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        positionList = jdbcTemplate.query(sql, new PositionRowMapper());
        if (positionList.size() > 0) {
            return positionList.get(0);
        }  
        return position;
    }
    public boolean addPosition(Position position) {

        boolean ret = true;
        try {
            String sql = "INSERT INTO position "
                    + "(userId, longtitude, latitude, dateChecked ) VALUES "
                    + "(?, ?, ?, ?)";

            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		position.getUserId(),
                    		position.getLongitude(),
                    		position.getLatitude(),
                    		position.getDateChecked()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addPosition got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deletePositionById(Long id) {

        boolean ret = true;
        String sql = "";
        try {
            sql = "delete from Position where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("deletePositionById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from Position";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            ret = false;
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;

    }

    public boolean updatePosition(Position position) {

        boolean ret = true;
        String sql = "update Position set userId = ?, longtitude = ?, latitude = ?, "
                + "dateChecked = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("PositionId = " + position.getId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		position.getUserId(),
                    		position.getLongitude(),
                    		position.getLatitude(),
                    		position.getDateChecked(),
                    		position.getId() });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updatePosition got error: " + ex.getMessage());
        }
        return ret;
    }
}
