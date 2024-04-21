package com.dashlexz.spring.pp_312.service;

import com.dashlexz.spring.pp_312.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void deleteById(Long id);

    public User getUser(Long id);

}
