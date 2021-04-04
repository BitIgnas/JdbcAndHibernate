package example3;


import java.sql.SQLException;
import java.util.List;

public class PrepairedStatementMain {
    public static void main(String[] args) {

        try {
            UserRepository userRepository = new UserRepository();
            List<User> users = userRepository.findUserByName("Danny");
            users.forEach(System.out::println);


            User user1 = new User();
            user1.setName("David");
            user1.setEmail("David123@gmail.com");
            user1.setCountry("Russian");
            userRepository.insertUser(user1);

            userRepository.deleteById(7);

            User userToUpdate = new User(2, "Anton", "Anton123@gmail.com", "Maldovia");
            userRepository.updateById(userToUpdate);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }




    }
}
