package org.example.service;

import org.example.domain.Role;
import org.example.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    public List<UserInfo> findAll() throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(int id) throws Exception;

    public List<Role> findOtherRoles(int id) throws Exception;

    public void addRoleToUser(int userId, int[] roleIds)throws Exception;
}
