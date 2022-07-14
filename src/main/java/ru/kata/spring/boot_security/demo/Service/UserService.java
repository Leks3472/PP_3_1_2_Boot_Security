package ru.kata.spring.boot_security.demo.Service;



import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User updatedUser);
    void delete(int id);
}
