package com.small.business.web.controller;

import com.small.business.model.bidjob.BidJob;
import com.small.business.service.bidjob.BidJobService;
import com.small.business.web.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/21/12
 * Time: 12:23 AM
 */
@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private BidJobService bidJobService;
    
    @RequestMapping(value = "/bidJob", method = RequestMethod.GET)
    public @ResponseBody List<BidJob> getAllBidJob() {

        return bidJobService.getAllBidJob();
    }
    
    @RequestMapping("/carlist.json")
    public @ResponseBody List<String> getCarList() {
        return carService.getAllCars();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String helloWorld() {
        return "helloWorld";
    }
    
    @RequestMapping(value = "/addCar/{car}", method = RequestMethod.POST)
    public @ResponseBody void addCar(@PathVariable("car") String car) {
        carService.addCar(car);
    }

    @RequestMapping(value = "/removeCar/{car}", method = RequestMethod.DELETE)
    public @ResponseBody void removeCar(@PathVariable("car") String car) {
        carService.deleteCar(car);
    }

    @RequestMapping(value = "/removeAllCars", method = RequestMethod.DELETE)
    public @ResponseBody void removeAllCars() {
        carService.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCarPartialPage() {
        return "cars/layout";
    }
}