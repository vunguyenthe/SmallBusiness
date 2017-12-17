package com.small.business.adapter;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.base.BaseMessage;
import com.small.business.model.people.People;
import com.small.business.models.PersonReferalDTO;

public class PeopleReferalAdaper extends BaseMessage {

    public static PersonReferalDTO mapBy(People people) {

        PersonReferalDTO peopleReferalDTO = new PersonReferalDTO();
        peopleReferalDTO.setId(people.getId());
        peopleReferalDTO.setCompanyName(people.getCompanyName());
        peopleReferalDTO.setFullName(people.getFullName());
        peopleReferalDTO.setJobTitle(people.getJobTitle());
        peopleReferalDTO.setMobilePhone(people.getMobilePhone());
        return peopleReferalDTO;
    }

    public static List<PersonReferalDTO> getPeopleReferals(List<People> peoples) {

        List<PersonReferalDTO> peopleReferal = new ArrayList<>();
        for (People person : peoples) {
            PersonReferalDTO personReferalDTO = mapBy(person);
            peopleReferal.add(personReferalDTO);
        }

        return peopleReferal;
    }
}