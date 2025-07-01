package com.managing_advertisements.first_project.service;

import java.util.List;

import com.managing_advertisements.first_project.model.users;

public interface userService {
    void addUser(users user);
    List<users> getAllUsers();
    boolean isExist(users user);
}
