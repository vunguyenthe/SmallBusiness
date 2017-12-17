package com.small.business.dao.option;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.option.JournalTypeRowMapper;
import com.small.business.model.option.JournalType;

@Service("journalTypeDao")
public class JournalTypeDaoImpl implements JournalTypeDao {

    @Autowired
    DataSource dataSource;
    
    @Override
    public List<JournalType> getAllJournalType() {

        String sql = "select * from journaltype";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<JournalType> journalTypeList = jdbcTemplate.query(sql,
                new JournalTypeRowMapper());
        return journalTypeList;
    }

}
