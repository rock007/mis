package com.sam.abcd.data.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.abcd.data.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
