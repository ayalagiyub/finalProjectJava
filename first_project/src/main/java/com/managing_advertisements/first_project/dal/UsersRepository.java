package com.managing_advertisements.first_project.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.managing_advertisements.first_project.model.users;


@Repository
public interface UsersRepository extends CrudRepository<users,Integer> {
    
}
