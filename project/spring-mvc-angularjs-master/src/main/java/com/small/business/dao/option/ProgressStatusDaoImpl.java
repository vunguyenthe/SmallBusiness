package com.small.business.dao.option;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.option.ProgressStatusRowMapper;
import com.small.business.model.option.ProgressStatus;

@Service("progressStatusDao")
public class ProgressStatusDaoImpl implements ProgressStatusDao {

    @Autowired
    DataSource dataSource;

    @Override
    public List<ProgressStatus> getAllProgressStatus() {
        String sql = "select * from progressstatus";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ProgressStatus> progressStatusList = jdbcTemplate.query(sql,
                new ProgressStatusRowMapper());
        return progressStatusList;
    }

    @Override
    public List<ProgressStatus> getAllCandidateProgressStatus() {
        String sql = "select * from candidateprogressstatus";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<ProgressStatus> progressStatusList = jdbcTemplate.query(sql,
                new ProgressStatusRowMapper());
        return progressStatusList;
    }
 
    @Override
    public ProgressStatus getCandidateProgressStatusStatusById(Long id) {
        ProgressStatus progressStatus = new ProgressStatus();
        List<ProgressStatus> progressStatusList = new ArrayList<ProgressStatus>();
        String sql = "select * from candidateprogressstatus where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        progressStatusList = jdbcTemplate.query(sql, new ProgressStatusRowMapper());
        if (progressStatusList.size() > 0) {
            return progressStatusList.get(0);
        }
        return progressStatus;
    }

}
