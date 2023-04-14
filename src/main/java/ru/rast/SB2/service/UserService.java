package ru.rast.SB2.service;

import ru.rast.SB2.model.User;

import java.util.List;

public interface UserService {

    User getById(int id);

    List<User> listUsers();

    void addUser(User user);

    void removeUser(int id);

    void updateUser(User user);


}
