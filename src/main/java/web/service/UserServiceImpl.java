package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import java.util.List;
@Service

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    public void add (User user){
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
    @Override
    public User createUser (User user){
        System.out.println(user);
        return userDao.createUser(user);
    }

}
