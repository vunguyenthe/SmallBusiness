package com.small.business.test;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.people.People;

public class PeopleTest extends BaseMessageTest {

    private static final long id = 1;
    private static final long journaType = 1;
    private static final long peopleId = 1;
    private static final long userId = 1;
    private static final long yearStarted = 1999;
    private static final long endedYear = 2016;
    private static final long companyId = 1;
    private static final String address = "Ha noi";
    private static final String createBy = "admin";
    private static final String email = "vu@gmail.com";
    private static final String fullName = "Nguyen The Vu";
    private static final String jobTitle = "PSE";
    private static final String companyName = "GCS";
    private static final long assignmentId = 1;
    private static final String assignmentName = "assignmentName test";
    private static final String documentName = "a.doc";
    private static final String notes = "notes sample";
    private static final long dateCreated = 1;

    public PeopleTest() {
        super(createMessage());
    }

    private static People createMessage() {

        People people = new People();
        people.setId(id);
        people.setAddress("aaa");
        people.setClient(true);
        people.setCompanyId(companyId);
        people.setCreateBy(createBy);
        people.setEmail(email);
        people.setFullName(fullName);
        people.setJobTitle(jobTitle);
        return people;
    }
}
