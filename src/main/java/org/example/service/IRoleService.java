package org.example.service;

import org.example.domain.Permission;
import org.example.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    public void save(Role role)throws Exception;

    public Role findById(int id) throws Exception;

    public void deleteRoleById(int id)throws Exception;

    public List<Permission> findOtherPermissions(int id)throws Exception;

    public void addPermissionToRole(int roleId, int[] pIds)throws Exception;
}
