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
    public void newUser();

    String newUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") Integer age, Model model);

    User createUser(@RequestBody User user);

    public List<User> readUser();
    public List<User> updateUser();
    public void deleteUser();
}
