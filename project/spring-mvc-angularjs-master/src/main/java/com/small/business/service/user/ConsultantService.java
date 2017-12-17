package com.small.business.service.user;

import java.util.List;

import com.small.business.model.user.Consultant;

public interface ConsultantService {

    public List<Consultant> getAllConsultant();

    public Consultant getConsultantById(Long id);

    public boolean addConsultant(Consultant Consultant);

    public boolean deleteConsultantById(Long id);

    public boolean deleteAll();

    public boolean updateConsultant(Consultant user);

}
