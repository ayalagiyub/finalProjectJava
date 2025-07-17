package com.managing_advertisements.first_project.service;

import java.util.List;

import com.managing_advertisements.first_project.dto.usersDTO;
import com.managing_advertisements.first_project.model.users;

public interface userService {
    void addUser(usersDTO user);
    List<usersDTO> getAllUsers();
    boolean isExist(usersDTO user);
}
