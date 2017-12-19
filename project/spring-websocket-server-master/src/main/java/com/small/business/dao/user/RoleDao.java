package com.small.business.dao.user;

import java.util.List;

import com.small.business.model.user.Role;

public interface RoleDao {

    public List<Role> getAllRole();

    public Role getRoleById(Long id);

    public boolean addRole(Role role);

    public boolean deleteRoleById(Long id);

    public boolean deleteAll();

    public boolean updateRole(Role role);
}
