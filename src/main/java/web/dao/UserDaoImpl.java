package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public User createUser(@RequestBody User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public void updateUser(User updatedUser) {
        entityManager.persist(updatedUser);

    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }


    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

}
