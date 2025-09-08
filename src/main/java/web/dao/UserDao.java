package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import web.models.User;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAll();

    User createUser(@RequestBody User user);

    public void updateUser(User updatedUser);

    public void deleteUser(User user);

    public User getUserById(long id);
}



