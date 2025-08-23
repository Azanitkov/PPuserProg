package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    private List<User> user = getAll();

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void newUser() {

    }

    @Override
    @GetMapping("/new")
    public String newUser(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("age") Integer age, Model model) {
        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setAge(age);

        model.addAttribute("user", user);
        return "users/new";
    }

    @Override
    public User createUser(@RequestBody User user) {
        entityManager.persist(user);
        return user;
    }


    @Override
    public List<User> readUser() {
        return null;
    }

    @Override
    public List<User> updateUser() {
        return null;
    }

    @Override
    public void deleteUser() {

    }

}
