package ru.pmsmirnov31.__Spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pmsmirnov31.__Spring_boot.dao.UserDao;
import ru.pmsmirnov31.__Spring_boot.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public void update(User user, int id) {
        userDao.update(user, id);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

}
