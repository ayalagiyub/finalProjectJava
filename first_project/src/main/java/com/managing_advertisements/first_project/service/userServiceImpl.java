package com.managing_advertisements.first_project.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.internal.bytebuddy.description.type.TypeVariableToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managing_advertisements.first_project.dal.UsersRepository;
import com.managing_advertisements.first_project.dto.usersDTO;
import com.managing_advertisements.first_project.model.users;

@Service
public class userServiceImpl implements userService {
    @Autowired
    UsersRepository UsersRep;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addUser(usersDTO user) {

        if (isExist(user)) {
            throw new IllegalStateException("this user already exist");
        }
        if (UsersRep.existsById(user.getPassword())) {
            throw new IllegalStateException("mmm this password somone already choosed");
        } else {
            UsersRep.save(mapper.map(user,users.class));
        }
    }

    @Override
    public List<usersDTO> getAllUsers() {
        Type t=new TypeToken<List<usersDTO>>(){}.getType();
        return mapper.map(((List<users>) UsersRep.findAll()),t); 
    }

    @Override
    public boolean isExist(usersDTO user) {
        if (isExist(user)) {
            return true;
        }
        return false;
    }

}
