package ru.rast.SB2.dao;

import ru.rast.SB2.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void removeUser(Integer id);

    User getUserById(Integer id);


}
