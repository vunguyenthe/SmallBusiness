package com.small.business.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.dao.user.UserDaoImpl;
import com.small.business.model.user.Partner;
import com.small.business.model.user.User;
import com.small.business.service.user.PartnerService;
import com.small.business.service.user.UserService;
@Controller
@RequestMapping("/api")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;
    @Autowired
    private UserService userService;    

    private static final Logger logger = LoggerFactory.getLogger(PartnerController.class);
    
    @RequestMapping(value = "/partner", method = RequestMethod.GET)
    public @ResponseBody List<Partner> getAllPartner() {

        return partnerService.getAllPartner();
    }
    @RequestMapping(value = "/partner/{id}", method = RequestMethod.GET)
    public @ResponseBody Partner getPartner(@PathVariable("id") Long id) {
    	return partnerService.getPartnerById(id);
    }
    @RequestMapping(value = "/partnerUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody Partner getPartnerUserId(@PathVariable("userId") Long userId) {
    	return partnerService.getPartnerByUserId(userId);
    }    
    @RequestMapping(value = "/partner", method = RequestMethod.POST)
    public @ResponseBody Long addPartner(@RequestBody Partner partner) {
    	Partner localPartner = partnerService.getPartnerByUserId(partner.getUserId());
    	if(localPartner.getUserId() > 0) {
    		logger.error("Cannot add new this partner, b/c the partner already existed");
    		System.out.println("Cannot add new this partner, b/c the partner already existed");
    		return -1L;
    	}
    	else {
    		//check whether the userId exist or not 
    		User user = userService.getUserById(partner.getUserId());
    		if(user.getId() <= 0L) {
    			return -2L;
    		}
    	}
        return partnerService.addPartner(partner);
    }

    @RequestMapping(value = "/partner", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePartner(@RequestBody Partner partner) {
        return partnerService.updatePartner(partner);
    }

    @RequestMapping(value = "/partner/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deletePartnerById(@PathVariable("id") Long id) {

        return partnerService.deletePartnerById(id);
    }

    @RequestMapping(value = "/partnerUserId/{userId}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deletePartnerByUserId(@PathVariable("userId") Long userId) {
    	//delete userId from user table
    	boolean ret = false;
    	Partner localPartner = partnerService.getPartnerByUserId(userId);
    	if(localPartner.getUserId() <= 0L) {
    		logger.error("The partner with " + userId  + " does not exist");
    	}    	
    	else {
            ret =  partnerService.deletePartnerByUserId(userId);
        	if(!ret) {
        		logger.error("Cannot delete partner: " + userId + " from partner table");
        	}   		
    	}
		User user = userService.getUserById(userId);
		if(user.getId() <= 0L) {
    		logger.error("The user " + userId  + " does not exist");
		}  
		else {
	    	ret &= userService.deleteUserById(userId);
	    	if(!ret) {
	    		logger.error("Cannot delete userid: " + userId + " from user table");
	    	}   
		}
    	return ret;
    }
    
    @RequestMapping(value = "/removeAllPartner", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPartner() {

        return partnerService.deleteAll();
    }
}
