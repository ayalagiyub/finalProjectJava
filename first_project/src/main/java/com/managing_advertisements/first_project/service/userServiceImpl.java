package com.managing_advertisements.first_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managing_advertisements.first_project.dal.UsersRepository;
import com.managing_advertisements.first_project.model.users;

@Service
public class userServiceImpl implements userService {
    @Autowired
    UsersRepository UsersRep;

    @Override
    public void addUser(users user) {

        if (isExist(user)) {
            throw new IllegalStateException("this user already exist");
        }
        if (UsersRep.existsById(user.getPassword())) {
            throw new IllegalStateException("mmm this password somone already choosed");
        } else {
            UsersRep.save(user);
        }
    }

    @Override
    public List<users> getAllUsers() {
        return (List<users>) UsersRep.findAll();
    }

    @Override
    public boolean isExist(users user) {
        if (isExist(user)) {
            return true;
        }
        return false;
    }

}
