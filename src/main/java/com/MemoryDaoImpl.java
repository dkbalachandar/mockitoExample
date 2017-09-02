package com;

import java.util.HashMap;
import java.util.Map;

public class MemoryDaoImpl implements UserDao {

    private static Map<String, User> userMap = new HashMap<>();

    @Override
    public User get(String id) {
        return userMap.get(id);
    }

    @Override
    public String save(User user) throws Exception {
        if(user == null){
            throw new Exception("Data is null");
        }
        userMap.put(user.getId(), user);
        return user.getId();
    }

    @Override
    public String remove(String id) throws Exception {
        if(userMap.get(id) == null){
            throw new Exception("Data is not available");
        }
        userMap.remove(id);
        return id;
    }

    @Override
    public String update(User user) throws Exception {
        if(userMap.get(user.getId()) == null){
            throw new Exception("Data is not available");
        }
        userMap.put(user.getId(), user);
        return user.getId();
    }
}
