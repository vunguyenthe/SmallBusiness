package com.small.business.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.ConsultantDao;
import com.small.business.model.user.Consultant;

@Service("ConsultantService")
public class ConsultantServiceImpl implements ConsultantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsultantServiceImpl.class);

    private static List<Consultant> consultantList = new ArrayList<Consultant>();

    @Autowired
    ConsultantDao consultantDao;

    public List<Consultant> getAllConsultant() {

        List<Consultant> consultantList = consultantDao.getAllConsultant();
        return consultantList;
    }

    public Consultant getConsultantById(Long id) {

        return consultantDao.getConsultantById(id);
    }

    public boolean addConsultant(Consultant consultant) {

        return consultantDao.addConsultant(consultant);
    }

    public boolean deleteConsultantById(Long id) {

        boolean ret;
        ret = consultantDao.deleteConsultantById(id);
        return ret;
    }

    public boolean deleteAll() {

        consultantList.clear();
        return consultantDao.deleteAll();
    }

    public boolean updateConsultant(Consultant consultant) {

        Consultant foundConsultant = findConsultantById(consultant.getId());
        if (foundConsultant != null) {
            consultantList.remove(foundConsultant);
            consultantList.add(consultant);
        }
        return consultantDao.updateConsultant(consultant);

    }

    public Consultant findConsultantById(Long id) {

        return consultantDao.getConsultantById(id);
    }

}
