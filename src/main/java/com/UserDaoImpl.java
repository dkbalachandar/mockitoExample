package com;

public class UserDaoImpl implements UserDao {

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public String save(User user) throws Exception {
        return "id";
    }

    @Override
    public String remove(String id) throws Exception {
       return id;
    }

    @Override
    public String update(User user) throws Exception {
        return "id";
    }
}
