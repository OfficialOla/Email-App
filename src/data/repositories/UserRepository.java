package data.repositories;

import data.model.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User findById(int id);

    long count();

    List<User> findAll();

    void delete(int id);

    void delete(User user);

    void deleteAll();


    User findByUsername(String username);

    User findByEmail(String emailAddress);

    int findId(int id);

}

