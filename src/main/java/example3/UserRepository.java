package example3;

import example2.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final String SELECT = "SELECT id, name, email, country FROM user WHERE name = ?;";
    private static final String INSERT = "INSERT INTO user(name, email, country) VALUES (?, ?, ?);";
    private static final String DELETE = "DELETE FROM user WHERE id = ?;";
    private static final String UPDATE = "UPDATE user SET name = ?, email = ?, country = ? WHERE id = ?;";
    private Connection connection;

    public UserRepository() throws SQLException {
        this.connection = DatabaseUtils.getConnection();
    }

    public List<User> findUserByName(String name) throws SQLException {
        List<User> user = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            String userEmail = resultSet.getString("email");
            String userCountry = resultSet.getString("country");
            user.add(new User(userId, userName, userEmail, userCountry));
        }
        return user;
    }

    public void insertUser(User user) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(INSERT);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        int insertedRows = ps.executeUpdate();
        System.out.println("Insert operation returned: " + (insertedRows ==1 ? "Ok" : "Nothing was inserted"));
        System.out.println("Inserted user: " + user);
    }

    public void deleteById(int idToDelete) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(DELETE);
        ps.setInt(1, idToDelete);
        int deletedRows = ps.executeUpdate();
        System.out.println("Deleted rows: " + deletedRows);
    }

    public void updateById(User user) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(UPDATE);
        ps.setString(1, user.getName());
        ps.setString(2, user.getEmail());
        ps.setString(3, user.getCountry());
        ps.setInt(4, user.getId());
        int updateRows = ps.executeUpdate();
        System.out.println("Update operation returned: " + (updateRows ==1 ? "Ok" : "Nothing was updated"));

    }
}
