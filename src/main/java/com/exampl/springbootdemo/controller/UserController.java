package com.exampl.springbootdemo.controller;

import com.exampl.springbootdemo.model.User;
import com.exampl.springbootdemo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {


    private UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }


    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userServiceImp.findAllUser();
        model.addAttribute("users", users);
        return "userlist";
    }

    @GetMapping("/userCreate")
    public String createUserForm(User user) {
        return "usercreate";
    }


    @PostMapping("/userCreate")
    public String createUser(User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";

    }

    @GetMapping("userDelete/{id}")
    public String deleteUserForm(@PathVariable("id") Long id) {
        userServiceImp.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("userUpdate/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userServiceImp.findUserById(id);
        model.addAttribute("user", user);
        return "userupdate";
    }

    @PostMapping("/userUpdate")
    public String updateUser(User user) {
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }



}
