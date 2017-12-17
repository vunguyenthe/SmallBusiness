package com.small.business.service.option;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.option.JournalTypeDao;
import com.small.business.model.option.JournalType;

@Service("journalTypeService")
public class JournalTypeServiceImpl implements JournalTypeService{

    @Autowired
    private JournalTypeDao journalTypeDao;
    
    @Override
    public List<JournalType> getAllJournalType() {
        return journalTypeDao.getAllJournalType();
    }

}
