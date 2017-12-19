package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.Partner;

public interface PartnerDao {

    public List<Partner> getAllPartner();

    public Partner getPartnerById(Long id);
    
    public Partner getPartnerByUserId(Long userId);

    public long addPartner(Partner partner);

    public boolean deletePartnerById(Long id);
    
    public boolean deletePartnerByUserId(Long id);

    public boolean deleteAll();

    public boolean updatePartner(Partner partner);

}
