package workInPair;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    private static Connection connection;
    private static Statement statement;

    public List<Department> findAll() throws SQLException {
        connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM departmentOfCompany";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("departmentId");
            String name = resultSet.getString("nameDepartment");
            departments.add(new Department(id, name));
        }
        return departments;
    }

    public Department findById(int departmentId) throws SQLException {
        connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM departmentOfCompany WHERE departmentId = " + departmentId + "; ";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("departmentId");
            String name = resultSet.getString("nameDepartment");
            return new Department(id, name);
        }
        return null;
    }

    public void deleteById(int departmentId) throws SQLException {
        connection = DatabaseConnection.getConnection();
        String sql = "DELETE FROM departmentOfCompany WHERE departmentId = " + departmentId + "; ";
        statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);


    }

    public void save(Department department) throws SQLException{
        connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO departmentOfCompany VALUES(?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, department.getId());
        preparedStatement.setString(2, department.getName());
        preparedStatement.executeUpdate();
        System.out.println("Dabatabase saved");


    }

    public static void updateByName(Department department, int id) throws SQLException {
        connection = DatabaseConnection.getConnection();
        String sql = "UPDATE departmentOfCompany SET departmentId = ?, nameDepartment = ? WHERE departmentId = ?;";
        PreparedStatement preSt = connection.prepareStatement(sql);
        preSt.setInt(1, department.getId());
        preSt.setString(2, department.getName());
        preSt.setInt(3, id);
        preSt.executeUpdate();

    }

    public static List<Department> findByNameSegment(String nameSegment) throws SQLException{ //WHERE lastName like "S%"
        connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM departmentOfCompany WHERE nameDepartment like '%" + nameSegment + "%'";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Department> departments = new ArrayList<>();
        while(resultSet.next()){
            int id = resultSet.getInt("departmentId");
            String departmentName = resultSet.getString("nameDepartment");
            departments.add(new Department(id, departmentName));
        }
        return departments;
    }
}
