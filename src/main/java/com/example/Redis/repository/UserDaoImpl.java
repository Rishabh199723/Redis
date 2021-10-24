package com.example.Redis.repository;

import com.example.Redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements
        UserDao{

    @Autowired
    RedisTemplate template;
    private static final String USERKEY = "USER";

    @Override
    public boolean saveUser(User user) {
        try{
            template.opsForHash().put(USERKEY, user.getId().toString(), user);
            return true;
        } catch (Exception ex) {
            System.out.println("Exception occured");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> users = null;
        try {
            users = template.opsForHash().values(USERKEY);
        } catch (Exception ex) {
            System.out.println("Exception occured while fetching all users");
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User fetchUserById(Long id) {
        return (User)template.opsForHash().get(USERKEY,id.toString());
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            template.opsForHash().delete(USERKEY, id.toString());
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


}
