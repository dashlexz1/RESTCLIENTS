package com.dashlexz.spring.pp_312.DAO;


import com.dashlexz.spring.pp_312.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void deleteById(Long id);
    User getUser(Long id);
}
