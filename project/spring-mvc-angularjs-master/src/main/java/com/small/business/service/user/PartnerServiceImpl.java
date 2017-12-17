package com.small.business.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.PartnerDao;
import com.small.business.model.user.Partner;


@Service("PartnerService")
public class PartnerServiceImpl implements PartnerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PartnerServiceImpl.class);

    private static List<Partner> partnerList = new ArrayList<Partner>();

    @Autowired
    PartnerDao partnerDao;

    public List<Partner> getAllPartner() {

        List<Partner> PartnerList = partnerDao.getAllPartner();
        return PartnerList;
    }
    public Partner getPartnerById(Long id) {

        return partnerDao.getPartnerById(id);
    }
    
    public Partner getPartnerByUserId(Long userId) {

        return partnerDao.getPartnerByUserId(userId);
    }
    
    public long addPartner(Partner partner) {

        return partnerDao.addPartner(partner);
    }

    public boolean deletePartnerById(Long id) {

        boolean ret;
        ret = partnerDao.deletePartnerById(id);
        return ret;
    }

    public boolean deletePartnerByUserId(Long userId) {

        boolean ret;
        ret = partnerDao.deletePartnerByUserId(userId);
        return ret;
    }
    
    public boolean deleteAll() {

        return partnerDao.deleteAll();
    }


    public boolean updatePartner(Partner Partner) {

        Partner foundPartner = findPartnerById(Partner.getId());
        if (foundPartner != null) {
            partnerList.remove(foundPartner);
            partnerList.add(Partner);
        }
        return partnerDao.updatePartner(Partner);

    }

    public Partner findPartnerById(Long id) {

        return partnerDao.getPartnerById(id);
    }

}
