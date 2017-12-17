package com.small.business.service.user;

import java.util.List;

import com.small.business.model.user.Role;

public interface RoleService {

    public List<Role> getAllRole();

    public Role getRoleById(Long id);

    public boolean addRole(Role Role);

    public boolean deleteRoleById(Long id);

    public boolean deleteAll();

    public boolean updateRole(Role user);

}
