package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.Consultant;

public interface ConsultantDao {

    public List<Consultant> getAllConsultant();

    public Consultant getConsultantById(Long id);

    public boolean addConsultant(Consultant role);

    public boolean deleteConsultantById(Long id);

    public boolean deleteAll();

    public boolean updateConsultant(Consultant role);
}
