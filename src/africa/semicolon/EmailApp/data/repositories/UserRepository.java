package africa.semicolon.EmailApp.data.repositories;

import africa.semicolon.EmailApp.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    User findByEmailAddress(String email);
//    User save(User user);
//
//    User findById(int id);
//
//    long count();
//
//    List<User> findAll();
//
//    void delete(int id);
//
//    void delete(User user);
//
//    void deleteAll();
//
//
//    User findByUsername(String username);
//
//    User findByEmail(String emailAddress);
//
//    int findId(int id);

}

