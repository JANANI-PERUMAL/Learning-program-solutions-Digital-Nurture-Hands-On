package com.example.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supermarket.model.Users;

public interface Usersrepo extends JpaRepository<Users, String> {

}
