package com.small.business.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.small.business.annotations.Monitor;
import com.small.business.model.user.Role;
import com.small.business.service.user.RoleService;

@Controller
@RequestMapping("/api")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Monitor
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public @ResponseBody Role getRole(@PathVariable long id) {

        return roleService.getRoleById(id);
    }

    @Monitor
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public @ResponseBody List<Role> getRoleList() {

        return roleService.getAllRole();
    }

    @Monitor
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public @ResponseBody boolean addRole(@RequestBody Role role) {

        return roleService.addRole(role);
    }

    @Monitor
    @RequestMapping(value = "/role", method = RequestMethod.PUT)
    public @ResponseBody boolean updateRole(@RequestBody Role role) {

        return roleService.updateRole(role);
    }

    @Monitor
    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeRole(@PathVariable("id") Long id) {

        return roleService.deleteRoleById(id);
    }

    @Monitor
    @RequestMapping(value = "/removeAllRole", method = RequestMethod.DELETE)
    public @ResponseBody boolean removeAllRole() {

        return roleService.deleteAll();
    }
}
