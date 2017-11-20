package com.small.business.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.small.business.annotations.Monitor;
import com.small.business.model.bidjob.BidJob;
import com.small.business.model.people.People;
import com.small.business.service.bidjob.BidJobService;
@Controller
@RequestMapping("/api")
public class BidJobController {

    @Autowired
    private BidJobService bidJobService;

    @RequestMapping(value = "/bidjob", method = RequestMethod.GET)
    public @ResponseBody List<BidJob> getAllBidJob() {

        return bidJobService.getAllBidJob();
    }
    
    @RequestMapping(value = "/bidjob/{id}", method = RequestMethod.GET)
    public @ResponseBody BidJob getBidJob(@PathVariable("id") Long id) {
    	return bidJobService.getBidJobById(id);
    }
    @RequestMapping(value = "/bidjobUserId/{userId}", method = RequestMethod.GET)
    public @ResponseBody List<BidJob> getAllBidJobByUserId(@PathVariable("userId") Long userId) {
    	return bidJobService.getAllBidJobByUserId(userId);
    }    
    @RequestMapping(value = "/bidjob", method = RequestMethod.POST)
    public @ResponseBody Long addBidJob(@RequestBody BidJob BidJob) {
        return bidJobService.addBidJob(BidJob);
    }

    @RequestMapping(value = "/bidjob", method = RequestMethod.PUT)
    public @ResponseBody boolean updateBidJob(@RequestBody BidJob BidJob) {
        return bidJobService.updateBidJob(BidJob);
    }

    @RequestMapping(value = "/bidjob/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeBidJob(@PathVariable("id") Long id) {

        return bidJobService.deleteBidJobById(id);
    }

    @RequestMapping(value = "/removeAllBidJob", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllBidJob() {

        return bidJobService.deleteAll();
    }
}
