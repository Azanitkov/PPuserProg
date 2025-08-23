package web.service;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

@Service
public interface UserService {

    public User createUser(User user);
    List <User> getAll();

}
