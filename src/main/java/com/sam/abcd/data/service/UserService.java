package com.sam.abcd.data.service;

import java.util.List;

import com.sam.abcd.data.entity.User;

public interface UserService {

    User save(User user);

    List<User> getList();

}
