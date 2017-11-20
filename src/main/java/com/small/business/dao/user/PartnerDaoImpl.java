package com.small.business.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.small.business.jdbc.user.PartnerRowMapper;
import com.small.business.model.user.Partner;

@Service("partnerDao")
public class PartnerDaoImpl implements PartnerDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerDaoImpl.class);

    @Autowired
    DataSource dataSource;

    public List<Partner> getAllPartner() {

        List partnerList = new ArrayList();
        String sql = "select * from partner";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        partnerList = jdbcTemplate.query(sql, new PartnerRowMapper());
        return partnerList;
    }
    public Partner getPartnerById(Long id) {

        Partner partner = new Partner();
        List<Partner> partnerList = new ArrayList<Partner>();
        String sql = "select * from partner where id= " + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        partnerList = jdbcTemplate.query(sql, new PartnerRowMapper());
        if (partnerList.size() > 0) {
            return partnerList.get(0);
        }
        return partner;
    }

    public Partner getPartnerByUserId(Long userId) {

        Partner partner = new Partner();
        List<Partner> partnerList = new ArrayList<Partner>();
        String sql = "select * from partner where userId= " + userId;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        partnerList = jdbcTemplate.query(sql, new PartnerRowMapper());
        if (partnerList.size() > 0) {
            return partnerList.get(0);
        }
        return partner;
    }
    
    public boolean deletePartnerById(Long id) {

        boolean ret = true;
        try {
            String sql = "delete from partner where id =" + id;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deletePartnerById got error: " + ex.getMessage());
        }
        return ret;
    }

    public boolean deletePartnerByUserId(Long userId) {

        boolean ret = true;
        try {
            String sql = "delete from partner where userId =" + userId;
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.error("deletePartnerById got error: " + ex.getMessage());
        }
        return ret;
    }
    
    public boolean deleteAll() {

        boolean ret = true;
        try {
            String sql = "delete from partner";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(sql);
        } catch (Exception ex) {
            LOGGER.debug("deleteAll got error: " + ex.getMessage());
        }
        return ret;
    }
    public long getMaxPartnerId(String sql) {
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
    	System.out.println("maxPartnerId: " + maxId);
    	return maxId;
    }
    public long addPartner(Partner partner) {

        boolean ret = true;
        long maxId = 0L;
        try {
            String sql = "INSERT INTO partner "
                    + "(userId, idCard, passportNumber, tempAddress, permanentAddress, bankAccountNumberId)  VALUES "
                    + "(?, ?, ?, ?, ?, ?)";

                    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		partner.getUserId(),
                    		partner.getIdCard(),
                    		partner.getPassportNumber(),
                    		partner.getTempAddress(),
                    		partner.getPermanentAddress(),
                    		partner.getBankAccountNumberId()
                    });
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("addPartner got error: " + ex.getMessage());
        }
        if(ret) {
        	maxId = partner.getUserId();
        }        
        return maxId;
    }
    public boolean updatePartner(Partner partner) {

        boolean ret = true;
        String sql = "update partner set idCard = ?, passportNumber = ?, tempAddress = ?, "
                + " permanentAddress = ?, bankAccountNumberId = ? "
                + " where userId = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        LOGGER.debug("userId = " + partner.getUserId());
        try {
            jdbcTemplate.update(
                    sql,
                    new Object[] {
                    		partner.getIdCard(),
                    		partner.getPassportNumber(),
                    		partner.getTempAddress(),
                    		partner.getPermanentAddress(),
                    		partner.getBankAccountNumberId(),
                    		partner.getUserId()                    		
                    		});
        } catch (Exception ex) {
            ret = false;
            LOGGER.error("updatePartner got error: " + ex.getMessage());
        }
        return ret;
    }

}
