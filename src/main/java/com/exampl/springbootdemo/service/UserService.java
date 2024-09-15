package com.exampl.springbootdemo.service;

import com.exampl.springbootdemo.model.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> findAllUser();
    User saveUser(User user);
    void deleteUser(Long id);
}
