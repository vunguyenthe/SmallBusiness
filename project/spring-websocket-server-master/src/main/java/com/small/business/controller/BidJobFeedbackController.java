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
import com.small.business.model.bidjob.BidJobFeedback;
import com.small.business.service.bidjob.BidJobFeedbackService;
@Controller
@RequestMapping("/api")
public class BidJobFeedbackController {

    @Autowired
    private BidJobFeedbackService bidJobFeedbackService;
    @Autowired

    private static final Logger logger = LoggerFactory.getLogger(BidJobFeedbackController.class);
    
    @RequestMapping(value = "/bidJobFeedback", method = RequestMethod.GET)
    public @ResponseBody List<BidJobFeedback> getAllBidJobFeedback() {

        return bidJobFeedbackService.getAllBidJobFeedback();
    }
    
    @RequestMapping(value = "/bidJobFeedback/{id}", method = RequestMethod.GET)
    public @ResponseBody BidJobFeedback getBidJobFeedback(@PathVariable("id") Long id) {
    	return bidJobFeedbackService.getBidJobFeedbackById(id);
    }
    
    @RequestMapping(value = "/bidJobFeedbackByUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody List<BidJobFeedback> getAllBidJobFeedbackByUserId(@PathVariable("userId") Long userId) {
    	return bidJobFeedbackService.getAllBidJobFeedbackByUserId(userId);
    }
    
    @RequestMapping(value = "/bidJobFeedback", method = RequestMethod.POST)
    public @ResponseBody Long addBidJobFeedback(@RequestBody BidJobFeedback bidJobFeedback) {
        return bidJobFeedbackService.addBidJobFeedback(bidJobFeedback);
    }
    @RequestMapping(value = "/bidJobFeedback", method = RequestMethod.PUT)
    public @ResponseBody boolean updateBidJobFeedback(@RequestBody BidJobFeedback bidJobFeedback) {
        return bidJobFeedbackService.updateBidJobFeedback(bidJobFeedback);
    }

    @RequestMapping(value = "/bidJobFeedback/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteBidJobFeedbackById(@PathVariable("id") Long id) {

        return bidJobFeedbackService.deleteBidJobFeedbackById(id);
    }

    //@RequestMapping(value = "/removeAllBidJobFeedback", method = RequestMethod.DELETE)
    //public @ResponseBody boolean removeAllBidJobFeedback() {

    //    return bidJobFeedbackService.deleteAll();
    //}
}
