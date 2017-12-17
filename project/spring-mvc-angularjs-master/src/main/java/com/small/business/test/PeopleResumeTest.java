package com.small.business.test;

import java.util.ArrayList;
import java.util.List;

import com.small.business.model.people.Resume.BasicInformation;
import com.small.business.model.people.Resume.Description;
import com.small.business.model.people.Resume.Name;
import com.small.business.model.people.Resume.PeopleResume;

public class PeopleResumeTest extends BaseMessageTest {

    public PeopleResumeTest() {
        super(createMessage());
    }
    private static PeopleResume createMessage() {
    	PeopleResume peopleResume = new PeopleResume();
    	List<Description> summary = new ArrayList<Description>();
    	List<Description> education_and_training = new ArrayList<Description>();
    	Description description =new Description();
    	//summary
    	description.setDescription("OF KEY QUALIFICATIONS\n\n 12 years\u2019 experience in the construction field on Engineering");
    	summary.add(description);
    	peopleResume.setSummary(summary);
    	//education_and_training
    	description =new Description();
    	description.setDescription("C# 4.0 Master Brainbench License 7691089 November 2012 ASP.NET 4.0 Brainbench License 7691089 February 2013 JavaScript");
    	education_and_training.add(description);
    	description =new Description();
    	description.setDescription("ICFAI University Post Graduate Diploma, Logistics, Materials, and Supply Chain Management, 2006 - 2007 Grade");
    	education_and_training.add(description);
    	peopleResume.setEducation_and_training(education_and_training);
    	//skills
    	List<Description> skills = new ArrayList<Description>();
    	description =new Description();
    	description.setDescription("Microsoft SQL Server C# ASP.NET ASP.NET MVC jQuery JavaScript Python HTML CSS3");
    	skills.add(description);
    	description =new Description();
    	description.setDescription("English (Full professional proficiency) Tamil (Professional working proficiency) French");
    	skills.add(description);
    	description =new Description();
    	description.setDescription("Software Debugging CS259\n\nAdvanced Design and Analysis of Algorithms from Stanford Online");
    	skills.add(description);
    	peopleResume.setSkills(skills);
    	//basics
    	BasicInformation basics = new BasicInformation();
    	Name name = new Name();
    	name.setFirstName("Vu");
    	name.setMiddleName("The");
    	name.setSurname("Nguyen");
    	basics.setName(name);
    	basics.setTitle("Software Engineer");
    	//email
    	List<Description> email = new ArrayList<Description>();
    	description =new Description();
    	description.setDescription("abc@gmail.com");
    	email.add(description);
    	//basics.setEmail(email);
    	//phone 
    	List<Description> phone = new ArrayList<Description>();
    	description =new Description();
    	description.setDescription("0987453101");
    	phone.add(description);
    	//basics.setPhone(phone);
    	peopleResume.setBasics(basics);    	
    	return peopleResume;
    }
}
