package com.small.business.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.annotations.Monitor;
import com.small.business.json.JSONParser;
import com.small.business.model.people.People;
import com.small.business.model.people.Resume.PeopleResume;
import com.small.business.service.cvparser.CvParseService;
import com.small.business.service.people.PeopleService;
import com.small.business.util.FileParser;

@Controller
@RequestMapping("/api")
public class PeopleController {


    @Autowired
    private CvParseService cvParseService;
    private PeopleService peopleService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleController.class);
    

    @Monitor
    @RequestMapping(value = "/people/{peopleId}", method = RequestMethod.GET)
    public @ResponseBody People getPeople(@PathVariable long peopleId) {
        People people = new People();
        return people;
    }

    @Monitor
    @RequestMapping(value = "/getCurrentPeopleId", method = RequestMethod.GET)
    public @ResponseBody Long getCurrentPeopleId() {

        return peopleService.getNextPeopleId() - 1;

    }


    @Monitor
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/uploadcvdoc", method = RequestMethod.POST)
    public @ResponseBody JSONObject uploadcvdoc(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request, @RequestParam("peopleId") Long peopleId)
            throws IOException {

        String pathUpDir = request.getSession().getServletContext()
                .getRealPath("/")
                + "/resources/docs/cv/";

        LOGGER.debug("pathUpDir: " + pathUpDir);
        File lfile = new File(pathUpDir);
        if (!lfile.exists()) {
            if (lfile.mkdirs()) {
                LOGGER.debug("Multiple directories are created!");
            } else {
                LOGGER.warn("Failed to create multiple directories!");
            }
        }

        String cv = "";
        if (!file.isEmpty()) {
            if (peopleId == 0L) {
                peopleId = peopleService.getNextPeopleId();
            }
            String targetFile = pathUpDir + peopleId + "_"
                    + file.getOriginalFilename();
            boolean ret = peopleService.uploadFilePostMethod(file, targetFile);
            if (ret) {
                cv = peopleId + "_" + file.getOriginalFilename();
            }
        }

        LOGGER.debug(String.format("receive %s", "resources/docs/cv/" + cv));
        JSONObject obj = new JSONObject();
        obj.put("docId", cv);
        obj.put("docShow", file.getOriginalFilename());
        obj.put("docPath", "resources/docs/cv/" + cv);
        return obj;

    }

    @Monitor
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/importcv", method = RequestMethod.POST)
    public @ResponseBody People importcv(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request) throws IOException {

        String pathUpDir = request.getSession().getServletContext()
                .getRealPath("/")
                + "/resources/docs/importcv/";

        LOGGER.info("pathUpDir for import CV: " + pathUpDir);
        File lfile = new File(pathUpDir);
        if (!lfile.exists()) {
            if (lfile.mkdirs()) {
                LOGGER.info("Multiple directories are created!");
            } else {
                LOGGER.warn("Failed to create multiple directories!");
            }
        }

        String targetFile = "";
        String parsedJsonFile = "";
        People peopleForImport = null;
        if (!file.isEmpty()) {
            targetFile = pathUpDir + UUID.randomUUID() + "_"
                    + file.getOriginalFilename();
            parsedJsonFile = targetFile.substring(0, targetFile.lastIndexOf(".")) + ".json";
            boolean ret = peopleService.uploadFilePostMethod(file, targetFile);
            if (ret) {
                LOGGER.info(String.format("receive %s", "/resources/docs/importcv/" + targetFile));
                cvParseService.parseCv(targetFile, parsedJsonFile);
                String json = FileParser.convertToArgonautFormat(parsedJsonFile);
                JSONParser.registerType(PeopleResume.class);
                PeopleResume peopleResume = (PeopleResume) JSONParser.fromJsonToObject(json);
                //TODO convert parse json to people model object here
                peopleForImport = FileParser.migratePeopleResumeToPeople(peopleResume);
               // peopleForImport.setJobTitle("IT");
               // peopleForImport.setAddress("Test for import");
            }
        }

        return peopleForImport;
    }

    @Monitor
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/uploaddoc", method = RequestMethod.POST)
    public @ResponseBody JSONObject uploaddoc(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request,
            @RequestParam("documentId") Long documentId) throws IOException {

        JSONObject obj = new JSONObject();
       // obj.put("docId", documentName);
      //  obj.put("docShow", file.getOriginalFilename());
      //  obj.put("docPath", "resources/docs/peopledoc/" + documentName);
      //  LOGGER.debug("docPath: " + "resources/docs/peopledoc/" + documentName);
        return obj;

    }

    @Monitor
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody JSONObject upload(
            @RequestParam("file") MultipartFile file,
            HttpServletRequest request, @RequestParam("peopleId") Long peopleId)
            throws IOException {

        String pathUpDir = request.getSession().getServletContext()
                .getRealPath("/")
                + "/resources/images/";

        LOGGER.debug("pathUpDir: " + pathUpDir);
        File lfile = new File(pathUpDir);
        if (!lfile.exists()) {
            if (lfile.mkdirs()) {
                LOGGER.debug("Multiple directories are created!");
            } else {
                LOGGER.warn("Failed to create multiple directories!");
            }
        }

        String peopleImageId = "";
        if (!file.isEmpty()) {
            if (peopleId == 0L) {
                peopleId = peopleService.getNextPeopleId();
            }
            String targetFile = pathUpDir + "people_" + peopleId + "."
                    + FilenameUtils.getExtension(file.getOriginalFilename());
            boolean ret = peopleService.uploadFilePostMethod(file, targetFile);
            if (ret) {
                peopleImageId = "people_"
                        + peopleId
                        + "."
                        + FilenameUtils
                                .getExtension(file.getOriginalFilename());
            }
        }
        LOGGER.debug(String.format("receive %s", "resources/images/" + file.getOriginalFilename()));
        JSONObject obj = new JSONObject();
        obj.put("imageId", peopleImageId);
        return obj;

    }

    @Monitor
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public @ResponseBody Long addPeople(HttpServletRequest request, @RequestBody People people,
            @RequestHeader("X-Access-Username") String XAccessUsername) {
    		Long peopleId = 0L;
            return peopleId;
            
    }

    @Monitor
    @RequestMapping(value = "/people", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePeople(HttpServletRequest request, @RequestBody People people, 
            @RequestHeader("X-Access-Username") String XAccessUsername) {
    	return true;

    }

    @Monitor
    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePeople(@PathVariable("id") Long id, @RequestHeader("X-Access-Username") String XAccessUsername) {
    	return true;
    }

    
}
