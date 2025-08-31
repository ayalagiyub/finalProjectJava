package com.managing_advertisements.first_project.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.managing_advertisements.first_project.model.users;


@Repository
// public interface UsersRepository extends CrudRepository<users,Integer>,JpaRepository<users, Integer> {
public interface UsersRepository extends JpaRepository<users, Integer> {
    boolean existsByPassword(String password);

}
