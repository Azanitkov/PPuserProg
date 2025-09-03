package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAll();

    String newUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") Integer age, Model model);

    User createUser(@RequestBody User user);

    public void updateUser(long id, User updatedUser);

    public void deleteUser(long id);

    public User getUserById(long id);
}



