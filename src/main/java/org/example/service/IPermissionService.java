package org.example.service;

import org.example.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll() throws Exception;

    public void save(Permission permission) throws Exception;

    public void deleteById(int id) throws Exception;
}
