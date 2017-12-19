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
import com.small.business.model.people.People;
import com.small.business.model.user.Position;
import com.small.business.service.position.PositionService;

@Controller
@RequestMapping("/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    public @ResponseBody List<Position> getAllPosition() {

        return positionService.getAllPosition();
    }
    @RequestMapping(value = "/position/{id}", method = RequestMethod.GET)
    public @ResponseBody Position getPosition(@PathVariable("id") Long id) {
    	return positionService.getPositionById(id);
    }
    @RequestMapping(value = "/positionUser/{userId}", method = RequestMethod.GET)
    public @ResponseBody Position getPositionUserId(@PathVariable("userId") Long userId) {
    	return positionService.getPositionUserId(userId);
    }    
    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public @ResponseBody boolean addPosition(@RequestBody Position position) {
        return positionService.addPosition(position);
    }

    @RequestMapping(value = "/position", method = RequestMethod.PUT)
    public @ResponseBody boolean updatePosition(@RequestBody Position position) {
        return positionService.updatePosition(position);
    }

    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removePosition(@PathVariable("id") Long id) {

        return positionService.deletePositionById(id);
    }

    @RequestMapping(value = "/removeAllPosition", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllPosition() {

        return positionService.deleteAll();
    }
}
