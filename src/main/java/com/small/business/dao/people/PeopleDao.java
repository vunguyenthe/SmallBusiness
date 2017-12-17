package com.small.business.dao.people;

import java.util.List;

import com.small.business.model.people.People;

public interface PeopleDao {

    public List<People> getAllPeople();

    public List<People> getAllPeopleClient();

    public List<People> getAllCandidate();

    public People getPeopleById(Long id);

    public List<People> getPeopleByCompanyId(Long companyId);

    public Long getNextPeopleId();

    public boolean addPeople(People People);

    public boolean deletePeopleById(Long id, boolean permanent);

    public boolean deleteAll();

    public boolean updatePeople(People people);

    List<People> getPeopleByName(String fullName);

    public boolean checkDuplicate(String field, String value);

    public boolean updatePeopleHighlightColor(Long id, String highlightColor);
}
