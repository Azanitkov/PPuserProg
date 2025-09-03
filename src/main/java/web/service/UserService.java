package web.service;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    List <User> getAll();
    public void deleteUser(long id);
    public void updateUser(long id, User updatedUser);
    public User getUserById(long id);

}
