package com;

import java.util.UUID;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(String id) {
        return userDao.get(id);
    }

    public String save(String firstName, String lastName, int age) throws Exception {
        User user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    public String remove(String id) throws Exception {
        return userDao.remove(id);
    }

    public String update(String id, String firstName, String lastName, int age) throws Exception {
        User user = new User();
        user.setAge(age);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setId(id);
        return userDao.update(user);
    }
}



