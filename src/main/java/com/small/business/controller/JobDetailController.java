package com.small.business.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.small.business.model.category.JobDetail;
import com.small.business.model.category.JobDetailCategoryId;
import com.small.business.model.category.JobDetailExt;
import com.small.business.service.JobDetail.JobDetailService;
@Controller
@RequestMapping("/api")
public class JobDetailController {

    @Autowired
    private JobDetailService jobDetailService;

    @RequestMapping(value = "/jobDetail", method = RequestMethod.GET)
    public @ResponseBody List<JobDetail> getAllJobDetail() {

        return jobDetailService.getAllJobDetail();
    }
    
    @RequestMapping(value = "/jobDetail/{id}", method = RequestMethod.GET)
    public @ResponseBody JobDetailCategoryId getJobDetail(@PathVariable("id") Long id) {
    	return jobDetailService.getJobDetailByIdExt(id);
    }
    
    @RequestMapping(value = "/jobDetailExt/{categoryDetailId}", method = RequestMethod.GET)
    public @ResponseBody JobDetailExt getJobDetailExtByCategoryDetailId(@PathVariable("categoryDetailId") Long categoryDetailId) {

        return jobDetailService.getJobDetailExtByCategoryDetailId(categoryDetailId);
    }
    
    @RequestMapping(value = "/jobDetail", method = RequestMethod.POST)
    public @ResponseBody long addJobDetail(@RequestBody JobDetail jobDetail) {
        return jobDetailService.addJobDetail(jobDetail);
    }

    @RequestMapping(value = "/jobDetail", method = RequestMethod.PUT)
    public @ResponseBody boolean updateJobDetail(@RequestBody JobDetail jobDetail) {
        return jobDetailService.updateJobDetail(jobDetail);
    }

    @RequestMapping(value = "/JobDetail/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeJobDetail(@PathVariable("id") Long id) {

        return jobDetailService.deleteJobDetailById(id);
    }

    @RequestMapping(value = "/removeAllJobDetail", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllJobDetail() {

        return jobDetailService.deleteAll();
    }
}
