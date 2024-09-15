package com.exampl.springbootdemo.repository;

import com.exampl.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
