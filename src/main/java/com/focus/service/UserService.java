package com.focus.service;

import com.focus.model.Role;
import com.focus.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);

    List<Role> getAllRoles();
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
