package ru.rast.SB2.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.rast.SB2.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }


    @Override
    public List<User> listUsers() {
        return entityManager.unwrap(Session.class).createQuery("FROM User").getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        return entityManager.unwrap(Session.class).createQuery("from User where id = '" + id + "'", User.class).getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.unwrap(Session.class).saveOrUpdate(user);
    }

    @Override
    public void removeUser(Integer id) {
        User user = getUserById(id);
        entityManager.unwrap(Session.class).delete(user);
    }
}
