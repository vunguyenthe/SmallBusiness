package com.small.business.service.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.small.business.dao.user.RoleDao;
import com.small.business.model.user.Role;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    private static List<Role> roleList = new ArrayList<Role>();

    @Autowired
    RoleDao roleDao;

    public List<Role> getAllRole() {

        List<Role> roleList = roleDao.getAllRole();
        return roleList;
    }

    public Role getRoleById(Long id) {

        return roleDao.getRoleById(id);
    }

    public boolean addRole(Role role) {

        return roleDao.addRole(role);
    }

    public boolean deleteRoleById(Long id) {

        boolean ret;
        ret = roleDao.deleteRoleById(id);
        return ret;
    }

    public boolean deleteAll() {

        roleList.clear();
        return roleDao.deleteAll();
    }

    public boolean updateRole(Role role) {

        Role foundRole = findRoleById(role.getId());
        if (foundRole != null) {
            roleList.remove(foundRole);
            roleList.add(role);
        }
        return roleDao.updateRole(role);

    }

    public Role findRoleById(Long id) {

        return roleDao.getRoleById(id);
    }

}
