package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {

        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }

    @Override
    public User show(int id) {

        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {

        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(User updatedUser) {

        entityManager.merge(updatedUser);


    }

    @Transactional
    @Override
    public void delete(int id) {

        entityManager.remove(show(id));
    }
}