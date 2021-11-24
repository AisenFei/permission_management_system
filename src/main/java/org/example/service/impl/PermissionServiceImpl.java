package org.example.service.impl;

import org.example.dao.IPermissionDao;
import org.example.domain.Permission;
import org.example.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);
    }

    @Override
    public void deleteById(int id) throws Exception {
        iPermissionDao.deleteFromRole_Permission(id);
        iPermissionDao.deleteById(id);
    }
}
