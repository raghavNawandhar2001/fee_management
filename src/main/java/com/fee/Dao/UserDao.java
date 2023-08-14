package com.fee.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fee.Entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
