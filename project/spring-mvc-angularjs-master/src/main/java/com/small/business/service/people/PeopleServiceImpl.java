package com.small.business.service.people;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.dao.people.PeopleDao;
import com.small.business.model.people.People;

@Service("PeopleService")
public class PeopleServiceImpl implements PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleServiceImpl.class);

    private static List<People> peopleList = new ArrayList<People>();

    @Autowired
    PeopleDao peopleDao;
    
    public List<People> getAllPeople() {

        List<People> peopleList = peopleDao.getAllPeople();
        return peopleList;
    }

    public List<People> getAllCandidate() {

        List<People> peopleList = peopleDao.getAllCandidate();
        return peopleList;
    }

    public List<People> getAllPeopleClient() {

        List<People> peopleList = peopleDao.getAllPeopleClient();
        return peopleList;
    }

    public Long getNextPeopleId() {

        return peopleDao.getNextPeopleId();
    }

    public List<People> getPeopleByCompanyId(Long companyId) {

        return peopleDao.getPeopleByCompanyId(companyId);
    }

    public People getPeopleById(Long id) {

        return peopleDao.getPeopleById(id);
    }

    public boolean addPeople(People people) {

        return peopleDao.addPeople(people);
    }

    public boolean deletePeopleById(Long id, boolean permanent) {

        boolean ret = false;
        ret = peopleDao.deletePeopleById(id, permanent);
        id--;
        return ret;
    }

    public boolean deleteAll() {

        peopleList.clear();
        return peopleDao.deleteAll();
    }

    @Override
    public List<People> getPeopleByName(String fullName) {

        return peopleDao.getPeopleByName(fullName);
    }

    public boolean uploadFilePostMethod(MultipartFile file, String targetFile) {

        LOGGER.debug("Upload file - post method");
        if (file != null) {

            try {
                InputStream inputStream = file.getInputStream();
                if (inputStream == null)
                	LOGGER.warn("File inputstream is null");
                File upload = new File(targetFile);
                file.transferTo(upload);
                LOGGER.debug("imagePath ->" + targetFile);
                IOUtils.closeQuietly(inputStream);

            } catch (IOException ex) {
                LOGGER.error("uploadFilePostMethod got error: " + ex.getMessage());
                return false;
            }
        }

        return true;

    }

    public boolean updatePeople(People people) {

        People foundPeople = findPeopleById(people.getId());
        if (foundPeople != null) {
            peopleList.remove(foundPeople);
            peopleList.add(people);
        }
        return peopleDao.updatePeople(people);

    }

    public boolean checkDuplicate(String field, String value) {

        return peopleDao.checkDuplicate(field, value);
    }

    @Override
    public boolean updatePeopleHighlightColor(Long id, String highlightColor) {

        return peopleDao.updatePeopleHighlightColor(id, highlightColor);
    }

    private People findPeopleById(Long id) {

        return peopleDao.getPeopleById(id);
    }
}
