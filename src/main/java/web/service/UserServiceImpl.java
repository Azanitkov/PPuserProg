package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        User user = userDao.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public void updateUser(long id, User updatedUser) {
        User user = userDao.getUserById(id);
        if (user != null) {
            user.setName(updatedUser.getName());
            user.setSurname(updatedUser.getSurname());
            user.setAge(updatedUser.getAge());
        }
        userDao.updateUser(user);

    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        System.out.println(user);
        return userDao.createUser(user);
    }

}
