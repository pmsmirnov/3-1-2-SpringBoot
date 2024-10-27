package ru.pmsmirnov31.__Spring_boot.dao;

import ru.pmsmirnov31.__Spring_boot.model.User;

import java.util.List;


public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getUserById(int id);

    void update(User user, int id);
    void deleteUser(User user);

}
