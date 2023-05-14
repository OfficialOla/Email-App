package africa.semicolon.EmailApp.data.repositories;

import africa.semicolon.EmailApp.data.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;

    private User user;

@BeforeEach
public  void setUser(){
    userRepository = new UserRepositoryImpl();
    user = new User();
}

@Test public void saveOneUser_countIsOneTest(){
userRepository.save(user);
assertEquals(1, userRepository.count());
}
    @Test public void saveOneUser_IdOfUserIsOne(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());
    }

    @DisplayName("Update User test")
    @Test public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, userRepository.count());
        savedUser.setLastName("PriestHood");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }
    @Test public void saveOneUser_findUserByIdTest(){
        User savedUser = userRepository.save(user);
        assertEquals(1, savedUser.getUserId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test public void saveOneUser_deleteOneUser_countIsZeroTest(){
        userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }


}