package com.project.BlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApplication.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
