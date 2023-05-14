//package africa.semicolon.EmailApp.data.repositories;
//
//import africa.semicolon.EmailApp.data.model.User;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class UserRepositoryImpl implements UserRepository{
//    int count = 0;
//
//    public List<User> users = new ArrayList<>();
//    @Override
//    public User save(User user) {
//        boolean userHasNotBeenSaved = user.getUserId() ==0;
//        if (userHasNotBeenSaved) saveNew(user);
//        return user;
//    }
//
//    private void saveNew(User user) {
//        user.setUserId(generateUserId());
//        users.add(user);
//        count++;
//    }
//    private int generateUserId() {
//        return count + 1;
//    }
//
//    @Override
//    public User findById(int id) {
//        for (User user : users) if (user.getUserId() == id) return user;
//        throw new NullPointerException("User not found");
//
//    }
//
//    @Override
//    public long count() {
//        return count;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return users;
//    }
//
//    @Override
//    public void delete(int id) {
//        for (User user : users) {
//            boolean userHasNotBeenSaved = user.getUserId() == id;
//            if (userHasNotBeenSaved) {
//                users.remove(user);
//                count--;
//                break;
//            }
//        }
//
//    }
//
//    @Override
//    public void delete(User user) {
//
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//
//    @Override
//    public User findByUsername(String username) {
//        for (User user : users){
//            if (Objects.equals(user.getUsername(), username)){
//                return user;
//            }
//        }
//
//        return null;
//    }
//
//    @Override
//    public User findByEmail(String emailAddress) {
//        for (User user : users) {
//            if (user.getEmailAddress().equalsIgnoreCase(emailAddress)) return user;
//            else throw new NullPointerException("Email Address not found");
//        }
//        return null;
//    }
//
//    @Override
//    public int findId(int id) {
//        for (User user : users) {
//            if (user.getUserId() == id) {
//                return id;
//            } else {
//                throw new NullPointerException("Id not found");
//            }
//        }
//        return 0;
//    }
//
//}
