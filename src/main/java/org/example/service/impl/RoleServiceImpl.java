package org.example.service.impl;

import org.example.dao.IRoleDao;
import org.example.domain.Permission;
import org.example.domain.Role;
import org.example.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(int id) throws Exception {
        return iRoleDao.findById(id);
    }

    @Override
    public void deleteRoleById(int id) throws Exception {
        //从user_role表中删除
        iRoleDao.deleteFromUser_RoleByRoleId(id);
        //从role_permission表中删除
        iRoleDao.deleteFromRole_PermissionByRoleId(id);
        //从role表中删除
        iRoleDao.deleteRoleById(id);
    }

    @Override
    public List<Permission> findOtherPermissions(int id) throws Exception {
        return iRoleDao.findOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] pIds) throws Exception {
        for(int pId:pIds){
            iRoleDao.addPermissionToRole(roleId,pId);
        }
    }
}
