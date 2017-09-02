package com;

public interface UserDao {
    public User get(String id);
    public String save(User user) throws Exception;
    public String remove(String id) throws Exception;
    public String update(User user) throws Exception;
}
