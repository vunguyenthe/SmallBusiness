package com.small.business.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.small.business.model.user.User;
import com.small.business.model.user.UserDevice;
import com.small.business.model.user.UserFollow;
import com.small.business.model.user.UserFollowerNumber;
import com.small.business.model.user.UserFollowingNumber;
import com.small.business.model.user.UserPosition;
import com.small.business.service.user.UserDeviceService;
import com.small.business.service.user.UserFollowService;
import com.small.business.service.user.UserFollowerNumberService;
import com.small.business.service.user.UserFollowingNumberService;
import com.small.business.service.user.UserService;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    UserFollowService userFollowService;

    @Autowired
    UserDeviceService userDeviceService;
    
    @Autowired
    UserFollowerNumberService userFollowerNumberService;
    
    @Autowired
    UserFollowingNumberService userFollowingNumberService;
    
    //userFollowerNumber
    @RequestMapping(value = "/userFollowerNumber", method = RequestMethod.GET)
    public @ResponseBody List<UserFollowerNumber> getAllUserFollowerNumber() {

        return userFollowerNumberService.getAllUserFollowerNumber();
    }

    @RequestMapping(value = "/userFollowerNumber/{id}", method = RequestMethod.GET)
    public @ResponseBody UserFollowerNumber getUserFollowerNumberById(@PathVariable long id) {

        return userFollowerNumberService.getUserFollowerNumberById(id);
    }
    
    @RequestMapping(value = "/userFollowerNumber", method = RequestMethod.POST)
    public @ResponseBody long addUserFollowerNumber(@RequestBody UserFollowerNumber userFollowerNumber) {
        return userFollowerNumberService.addUserFollowerNumber(userFollowerNumber);
    }
    @RequestMapping(value = "/userFollowerNumber", method = RequestMethod.PUT)
    public @ResponseBody boolean updateUserFollow(@RequestBody UserFollowerNumber userFollowerNumber) {
        return userFollowerNumberService.updateUserFollowerNumber(userFollowerNumber);
    }
    @RequestMapping(value = "/userFollowerNumber/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteUserFollowerNumberById(@PathVariable("id") Long id) {

        return userFollowerNumberService.deleteUserFollowerNumberById(id);
    }
    //userFollowingNumber
    @RequestMapping(value = "/userFollowingNumber", method = RequestMethod.GET)
    public @ResponseBody List<UserFollowingNumber> getAllUserFollowingNumber() {

        return userFollowingNumberService.getAllUserFollowingNumber();
    }

    @RequestMapping(value = "/userFollowingNumber/{id}", method = RequestMethod.GET)
    public @ResponseBody UserFollowingNumber getUserFollowingNumberById(@PathVariable long id) {

        return userFollowingNumberService.getUserFollowingNumberById(id);
    }

    @RequestMapping(value = "/userFollowingNumber", method = RequestMethod.POST)
    public @ResponseBody long addUserFollowingNumber(@RequestBody UserFollowingNumber userFollowingNumber) {
        return userFollowingNumberService.addUserFollowingNumber(userFollowingNumber);
    }
    @RequestMapping(value = "/userFollowingNumber", method = RequestMethod.PUT)
    public @ResponseBody boolean updateUserFollowing(@RequestBody UserFollowingNumber userFollowingNumber) {
        return userFollowingNumberService.updateUserFollowingNumber(userFollowingNumber);
    }
    @RequestMapping(value = "/userFollowingNumber/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteUserFollowingNumberById(@PathVariable("id") Long id) {

        return userFollowingNumberService.deleteUserFollowingNumberById(id);
    }
    //userDevice
    @RequestMapping(value = "/userDevice", method = RequestMethod.GET)
    public @ResponseBody List<UserDevice> getUserDeviceList() {

        return userDeviceService.getAllUserDevice();
    }

    @RequestMapping(value = "/userDevice/{id}", method = RequestMethod.GET)
    public @ResponseBody UserDevice getUserDeviceById(@PathVariable long id) {

        return userDeviceService.getUserDeviceById(id);
    }

    @RequestMapping(value = "/userDevice", method = RequestMethod.POST)
    public @ResponseBody long addUserDevice(@RequestBody UserDevice userDevice) {
        return userDeviceService.addUserDevice(userDevice);
    }
    @RequestMapping(value = "/userDevice", method = RequestMethod.PUT)
    public @ResponseBody boolean updateUserDevice(@RequestBody UserDevice userDevice) {
        return userDeviceService.updateUserDevice(userDevice);
    }
    @RequestMapping(value = "/userDevice/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteUserDeviceById(@PathVariable("id") Long id) {

        return userDeviceService.deleteUserDeviceById(id);
    }
    //UserDeviceService
    @RequestMapping(value = "/userFollow", method = RequestMethod.GET)
    public @ResponseBody List<UserFollow> getUserFollowList() {

        return userFollowService.getAllUserFollow();
    }

    @RequestMapping(value = "/userFollow/{id}", method = RequestMethod.GET)
    public @ResponseBody UserFollow getUserFollowById(@PathVariable long id) {

        return userFollowService.getUserFollowById(id);
    }

    @RequestMapping(value = "/userFollow", method = RequestMethod.POST)
    public @ResponseBody long addUserFollow(@RequestBody UserFollow userFollow) {
        return userFollowService.addUserFollow(userFollow);
    }
    @RequestMapping(value = "/userFollow", method = RequestMethod.PUT)
    public @ResponseBody boolean updateUserFollow(@RequestBody UserFollow userFollow) {
        return userFollowService.updateUserFollow(userFollow);
    }
    @RequestMapping(value = "/userFollow/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean deleteUserFollowById(@PathVariable("id") Long id) {

        return userFollowService.deleteUserFollowById(id);
    }    
    
    //user
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody List<User> getUserList() {

        return userService.getAllUser();
    }
    
    @RequestMapping(value = "/userPosition", method = RequestMethod.GET)
    public @ResponseBody List<UserPosition> getUserPositionList() {

        return userService.getAllUserPosition();
    }
    
    @RequestMapping(value = "/userPosition/{userId}", method = RequestMethod.GET)
    public @ResponseBody UserPosition getUserPosition(@PathVariable("userId") Long userId) {

        return userService.getUserPosition(userId);
    }    
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody long addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeUser(@PathVariable("id") Long id) {

        return userService.deleteUserById(id);
    }
    @RequestMapping(value = "/removeAllUser", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllUser() {

        return userService.deleteAll();
    }

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public @ResponseBody String fileUpload(
            @RequestParam(value = "file", required = false) MultipartFile file,
            HttpServletRequest request) {

        return userService.uploadFilePostMethod(file, request);

    }
}
